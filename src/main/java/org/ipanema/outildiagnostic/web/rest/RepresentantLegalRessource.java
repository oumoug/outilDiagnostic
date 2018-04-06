package org.ipanema.outildiagnostic.web.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.validation.Valid;

import com.codahale.metrics.annotation.Timed;

import org.ipanema.outildiagnostic.service.dto.CritereRecherche;
import org.ipanema.outildiagnostic.service.dto.Enfant;
import org.ipanema.outildiagnostic.service.dto.RecordResponsable;
import org.ipanema.outildiagnostic.service.dto.Responsable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RepresentantLegalRessource{
    private final Logger log = LoggerFactory.getLogger(EleveRessource.class);
    @PostMapping("/representantLegals")
    @Timed
    public ResponseEntity<RecordResponsable> appelWebService(@Valid @RequestBody CritereRecherche critere) throws IOException{
        log.debug("REST request to get Record : {}", critere);
        // appel webService
        URL  urlJsonServeur = new URL(" http://localhost:3000/api/v1/responsable");
        HttpURLConnection conn = (HttpURLConnection) urlJsonServeur.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        RecordResponsable recordResponsable= ParseResultat(in);    
        return  new ResponseEntity<>(recordResponsable, HttpStatus.OK);
    }
    public RecordResponsable ParseResultat(BufferedReader in ) throws IOException{
        String inputLine;
        StringBuffer response = new StringBuffer();
        String systemInf;
       JSONArray myResponse; 
        JSONArray resulatSiTous;
        JSONObject resultatSi; 
        Iterator<?> iterator;
        Object cle;
        Object val;
        RecordResponsable recordResponsable=new RecordResponsable();
        List<Map<String,List<String>>> resumeTmps=new ArrayList<Map<String,List<String>>>();
        List<Map<String,List<String>>> detailleTmps;
        List<String> menus=new ArrayList<String>();
        Map<Enfant,Integer> enfants=new HashMap<Enfant,Integer>();
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
                    enfants=new HashMap<Enfant,Integer>();
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
                            ParseResume((JSONArray)val,enfants,resumeTmps);
                        }else if(String.valueOf(cle).endsWith(".3")){
                            detailleTmps=Parsedetaille((JSONArray) val);
                        }  
                    }
                   
                    recordResponsable=createRecordWithList(resumeTmps, detailleTmps, systemInf,recordResponsable,enfants);
                    
                }

            }
            recordResponsable.setMenus(menus);
            
		} catch (JSONException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            log.debug("erreur creation objet", e);
		}
        return recordResponsable;
    }
    public RecordResponsable createRecordWithList( List<Map<String,List<String>>> resumeTmps, List<Map<String,List<String>>> detailleTmps,String systemInf,RecordResponsable recordResponsable,Map<Enfant,Integer>enfants){
        Responsable responsable;  
        for(int v=0;v< detailleTmps.size();v++){
            responsable=new  Responsable ();
            responsable.setSystemeInf(systemInf);
            for(Entry<Enfant, Integer> entry : enfants.entrySet()) {
                Enfant cle = entry.getKey();
                Integer valeur = entry.getValue();
                if(valeur==v){
                    cle.setSystemInf(systemInf);
                    responsable.getEnfants().add(cle);
 
                }
             }
            responsable.setResponsableDetaille(detailleTmps.get(v));
            responsable.setResponsableResume(resumeTmps.get(v));
            recordResponsable.getResponsables().add(responsable);
        }
        return    recordResponsable;

    }

    public void  ParseResume(JSONArray  personnelResumes, Map<Enfant,Integer> enfantTmps,  List<Map<String,List<String>>> resumeTmps) throws JSONException{
        Iterator<?>  iterator1,iterator;
        JSONObject personnelResume, enfants;
        Object val1 ,cle1,cle,val;
        JSONArray jsonArray;
        Enfant enfantTmp;
        List<String> tmp;
        Map<String,List<String>> resumeTmp;
        for(int k=0;k< personnelResumes.length();k++){ 
            personnelResume= personnelResumes.getJSONObject(k);
            resumeTmp=new  HashMap<String,List<String>>();
            for ( iterator1 = personnelResume.keys(); iterator1.hasNext();) {
                cle1 = iterator1.next();
                val1 =personnelResume.get(String.valueOf(cle1));
                tmp=new ArrayList<String>();
                if(String.valueOf(cle1).equals("0.0.0")){
                    jsonArray=(JSONArray) val1;
                    for(int x=0;x<jsonArray.length();x++){
                        enfants=jsonArray.getJSONObject(x);
                        enfantTmp=new Enfant();
                        for(iterator= enfants.keys();iterator.hasNext();){
                            cle = iterator.next();
                            val =enfants.get(String.valueOf(cle));
                            if(String.valueOf(cle).equals("0.0.1")){
                                enfantTmp.setPrenom((String)val);  

                            }else if(String.valueOf(cle).equals("0.1.0")){
                                enfantTmp.setNom((String)val);

                            }else if(String.valueOf(cle).equals("1.0.0")){
                               // enfantTmp.setLien((String)val);

                            }
                        }
                        enfantTmps.put( enfantTmp, k);
                    }
                    resumeTmp.put(String.valueOf(cle1),tmp);  
                }else{
                    if(val1.getClass().equals(JSONArray.class)){
                        jsonArray=(JSONArray) val1;
                    
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
}