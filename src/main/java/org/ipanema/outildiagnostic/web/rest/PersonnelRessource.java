package org.ipanema.outildiagnostic.web.rest;
import java.awt.Menu;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.net.URLEncoder;
import javax.validation.Valid;

import com.codahale.metrics.annotation.Timed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ipanema.outildiagnostic.service.dto.CritereRecherche;
import org.ipanema.outildiagnostic.service.dto.RecordPersonnel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.ipanema.outildiagnostic.service.dto.Personnel;

@RestController
@RequestMapping("/api")
public class PersonnelRessource{
    private final Logger log = LoggerFactory.getLogger(PersonnelRessource.class);
    private final String urlApi="localhost:/api/v1";
    @PostMapping("/personnels")
    @Timed
    public ResponseEntity<RecordPersonnel>  appelWebService(@Valid @RequestBody CritereRecherche critere) throws IOException{
        String url= formatUrl(critere);
        RecordPersonnel recordPersonnel;
        URL urlJsonServeur = new URL("http://localhost:3000/api/v1/personnel");
        HttpURLConnection conn = (HttpURLConnection) urlJsonServeur.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        recordPersonnel= ParseResultat(in);
        log.debug("REST request to get Record : {}", url);
       return  new ResponseEntity<>(recordPersonnel, HttpStatus.OK);
    }

    public RecordPersonnel ParseResultat(BufferedReader in ) throws IOException{
        String inputLine;
        StringBuffer response = new StringBuffer();
        String systemInf;
       JSONArray myResponse; 
        JSONArray resulatSiTous;
        JSONObject resultatSi; 
        Iterator<?> iterator;
        Object cle;
        Object val;
        RecordPersonnel recordPersonnel=new RecordPersonnel();
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
                            resumeTmps=ParseResume((JSONArray)val);
                        }else if(String.valueOf(cle).endsWith(".3")){
                            detailleTmps=Parsedetaille((JSONArray) val);
                        }  
                    }
                   
                    recordPersonnel=createRecordWithList(resumeTmps, detailleTmps, systemInf,recordPersonnel);
                    
                }

            }
            recordPersonnel.setMenus(menus);
            
		} catch (JSONException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            log.debug("erreur creation objet", e);
		}
        return  recordPersonnel;
    }
    public  RecordPersonnel createRecordWithList( List<Map<String,List<String>>> resumeTmps, List<Map<String,List<String>>> detailleTmps,String systemInf,RecordPersonnel recordPersonnel){
        Personnel personnel;  
        for(int v=0;v< detailleTmps.size();v++){
            personnel=new Personnel();
            personnel.setSystemeInf(systemInf);
            personnel.setPersonnelDetaille(detailleTmps.get(v));
            personnel.setPersonnelResume(resumeTmps.get(v));
            recordPersonnel.getPersonnels().add(personnel);
        }
        return recordPersonnel;

    }

    public  List<Map<String,List<String>>> ParseResume(JSONArray  personnelResumes) throws JSONException{
        Iterator<?>  iterator1;
        JSONObject personnelResume;
        Object val1;
        Object cle1;
        JSONArray jsonArray;
        List<String> tmp;
        Map<String,List<String>> resumeTmp;
        List<Map<String,List<String>>> resumeTmps=new  ArrayList<Map<String,List<String>>>();
        for(int k=0;k< personnelResumes.length();k++){ 
            personnelResume= personnelResumes.getJSONObject(k);
            resumeTmp=new  HashMap<String,List<String>>();
            for ( iterator1 = personnelResume.keys(); iterator1.hasNext();) {
                cle1 = iterator1.next();
                val1 =personnelResume.get(String.valueOf(cle1));
                if(val1.getClass().equals(JSONArray.class)){
                    jsonArray=(JSONArray) val1;
                    tmp=new ArrayList<String>();
                    for(int x=0;x<jsonArray.length();x++){
                        tmp.add(jsonArray.getString(x)); 
                    }
                    resumeTmp.put(String.valueOf(cle1),tmp);  
                }else if(val1.getClass().equals(String.class)){
                    tmp=new ArrayList<String>();
                    tmp.add(String.valueOf(val1));
                    resumeTmp.put(String.valueOf(cle1),tmp);  
                }
                
            }
            resumeTmps.add(resumeTmp);    
        }
        return  resumeTmps;
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
                if(val2.getClass().equals(JSONArray.class)){
                    jsonArray=(JSONArray) val2;
                    tmp=new ArrayList<String>();
                    for(int x=0;x<jsonArray.length();x++){
                        tmp.add(jsonArray.getString(x)); 
                    }
                    detailleTmp.put(String.valueOf(cle2),tmp);  
                }else if(val2.getClass().equals(String.class)){
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
        String url=urlApi+"personnels";
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