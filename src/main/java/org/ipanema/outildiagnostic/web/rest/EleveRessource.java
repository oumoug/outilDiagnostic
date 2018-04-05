package org.ipanema.outildiagnostic.web.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.validation.Valid;

import com.codahale.metrics.annotation.Timed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import org.ipanema.outildiagnostic.service.dto.CritereRecherche;
import org.ipanema.outildiagnostic.service.dto.Eleve;
import org.ipanema.outildiagnostic.service.dto.Parent;
import org.ipanema.outildiagnostic.service.dto.RecordEleve;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EleveRessource{
    private final Logger log = LoggerFactory.getLogger(EleveRessource.class);
    private final String urlApi="localhost:/api/v1";
    @PostMapping("/eleves")
    @Timed
    public ResponseEntity<RecordEleve> appelWebService(@Valid @RequestBody CritereRecherche critere) throws IOException{
       String url= formatUrl(critere);
       RecordEleve recordEleve;
        log.debug("REST request to get Record : {}", url);
        URL urlJsonServeur = new URL(" http://localhost:3000/api/v1/eleve");
        HttpURLConnection conn = (HttpURLConnection) urlJsonServeur.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        recordEleve= ParseResultat(in);
       
        
        return  new ResponseEntity<>(recordEleve, HttpStatus.OK);
    }
    public RecordEleve ParseResultat(BufferedReader in ) throws IOException{
        String inputLine;
        StringBuffer response = new StringBuffer();
        String systemInf;
        JSONArray myResponse; 
        JSONArray resulatSiTous;
        JSONObject resultatSi; 
        Iterator<?> iterator;
        Object cle;
        Object val;
        Map<Parent,Integer> parentTmps;
        RecordEleve recordEleve=new RecordEleve();
        List<Map<String,List<String>>> resumeTmps;
        List<Map<String,List<String>>> detailleTmps;
        List<String> menus=new ArrayList<String>();
        menus.add("Résumé");
     
         while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
        }
        in.close();
        try {
            myResponse =  new JSONArray(response.toString());
            for(int i=0;i< myResponse.length();i++){
                resulatSiTous=myResponse.getJSONObject(i).getJSONArray("resultats");
                for (int j=0;j<resulatSiTous.length();j++){
                    resumeTmps=new  ArrayList<Map<String,List<String>>>();
                    detailleTmps=new ArrayList<Map<String,List<String>>>();
                    parentTmps=new HashMap<Parent,Integer>();
                    resultatSi=resulatSiTous.getJSONObject(j);
                    systemInf="";
                 
                    for ( iterator = resultatSi.keys(); iterator.hasNext();) {
                        cle = iterator.next();
                        val = resultatSi.get(String.valueOf(cle));
                      // nom SI
                        if(String.valueOf(cle).endsWith(".1")){
                            systemInf=String.valueOf(val);     
                            menus.add(String.valueOf(val));
                             // donnée résumé plusieurs personnel
                        }else if(String.valueOf(cle).endsWith(".2")){
                         ParseResume((JSONArray)val, parentTmps,  resumeTmps);
                        }else if(String.valueOf(cle).endsWith(".3")){
                            detailleTmps=Parsedetaille((JSONArray) val);
                        }  
                    }
                   
                    recordEleve=createRecordWithList(resumeTmps, detailleTmps, systemInf,recordEleve,parentTmps);
                    
                }

            }
            recordEleve.setMenus(menus);
            
		} catch (JSONException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            log.debug("erreur creation objet", e);
		}
        return  recordEleve;
    }
    public  RecordEleve createRecordWithList( List<Map<String,List<String>>> resumeTmps, List<Map<String,List<String>>> detailleTmps,String systemInf,RecordEleve recordEleve,  Map<Parent,Integer> parentTmps){
       Eleve eleve; 

        for(int v=0;v< detailleTmps.size();v++){
            eleve=new Eleve();
            eleve.setSystemeInf(systemInf);
            for(Entry<Parent, Integer> entry : parentTmps.entrySet()) {
               Parent cle = entry.getKey();
               Integer valeur = entry.getValue();
               if(valeur==v){
                   cle.setSystemInf(systemInf);
                   eleve.getRepresentant().add(cle);

               }
            }
            eleve.setEleveDetaille(detailleTmps.get(v));
            eleve.setEleveResume(resumeTmps.get(v));
            recordEleve.getEleves().add(eleve);
        }
        return recordEleve;

    }

    public  void ParseResume(JSONArray  personnelResumes, Map<Parent,Integer> parentTmps, List<Map<String,List<String>>> resumeTmps) throws JSONException{
        Iterator<?>  iterator1, iterator;
        JSONObject personnelResume, responsableLegals;
        Object val1, val;
        Object cle1 ,cle;
        JSONArray jsonArray;
        List<String> tmp;
        Map<String,List<String>> resumeTmp;
        Parent parentTmp;
        for(int k=0;k< personnelResumes.length();k++){ 
            personnelResume= personnelResumes.getJSONObject(k);
            resumeTmp=new  HashMap<String,List<String>>();
            for ( iterator1 = personnelResume.keys(); iterator1.hasNext();) {
                cle1 = iterator1.next();
                val1 =personnelResume.get(String.valueOf(cle1));
                tmp=new ArrayList<String>();
                //traitemment responsable légal
                if(String.valueOf(cle1).equals("0.0.0")){
                    jsonArray=(JSONArray) val1;
                    for(int x=0;x<jsonArray.length();x++){
                        responsableLegals=jsonArray.getJSONObject(x);
                        parentTmp=new Parent();
                        for(iterator= responsableLegals.keys();iterator.hasNext();){
                            cle = iterator.next();
                            val =responsableLegals.get(String.valueOf(cle));
                            if(String.valueOf(cle).equals("0.0.1")){
                                parentTmp.setPrenom((String)val);  

                            }else if(String.valueOf(cle).equals("0.1.0")){
                                parentTmp.setNom((String)val);

                            }


                        }
                        parentTmps.put( parentTmp, k);
                    }
                    resumeTmp.put(String.valueOf(cle1),tmp);  
                }else{
                    if(val1.getClass()==JSONArray.class){
                        jsonArray=(JSONArray) val1;
                        for(int x=0;x<jsonArray.length();x++){
                            tmp.add(jsonArray.getString(x)); 
                        }
                        resumeTmp.put(String.valueOf(cle1),tmp);  
                    }else{
                        tmp.add(String.valueOf(val1));
                        resumeTmp.put(String.valueOf(cle1),tmp);  
                    }
                }
               
               

            }
            resumeTmps.add(resumeTmp); 
        }
    }

    public  List<Map<String,List<String>>>  Parsedetaille(JSONArray   personnelDetailles) throws JSONException{
        Map<String,List<String>> detailleTmp;
        JSONObject personnelDetaille;
        JSONArray jsonArray;
        Iterator<?>  iterator2;
        Object cle2, val2;
        List<String> tmp;
        List<Map<String,List<String>>> detailleTmps=new ArrayList<Map<String,List<String>>>();
        for(int l=0;l<personnelDetailles.length();l++){
            personnelDetaille=personnelDetailles.getJSONObject(l);
            detailleTmp=new HashMap<String,List<String>>();
            for ( iterator2 = personnelDetaille.keys(); iterator2.hasNext();) {
                cle2 = iterator2.next();
                val2 =personnelDetaille.get(String.valueOf(cle2));
                if(val2.getClass()==JSONArray.class){
                    jsonArray=(JSONArray) val2;
                    tmp=new ArrayList<String>();
                    for(int x=0;x<jsonArray.length();x++){
                        tmp.add(jsonArray.getString(x)); 
                    }
                    detailleTmp.put(String.valueOf(cle2),tmp);  
                }else{
                    tmp=new ArrayList<String>();
                    tmp.add(String.valueOf(val2));
                    detailleTmp.put(String.valueOf(cle2),tmp);  
                }
            }
            detailleTmps.add( detailleTmp);
        }
       return   detailleTmps;
    }
    public String formatUrl(CritereRecherche critere) throws UnsupportedEncodingException{
        String url=urlApi+"eleves";
        if(! critere.getNom().equals("")){
            url=url+"nom="+critere.getNom();
        }
        if(! critere.getNom().equals("")){
            url=url+"nom="+critere.getNom();
        }
        if(! critere.getEtablissement().equals("")){
            url=url+"structure="+critere.getEtablissement();
        }
        if(! critere.getMail().equals("")){
            url=url+"courriel="+critere.getMail();

        }


        return URLEncoder.encode(url,"UTF-8");

    }
}