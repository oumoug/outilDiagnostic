package org.ipanema.outildiagnostic.web.rest;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    public ResponseEntity<RecordPersonnel> appelWebService(@Valid @RequestBody CritereRecherche critere) throws IOException{
        String url= formatUrl(critere);
        JSONArray myResponse;
        JSONArray resulats;
        JSONObject resultatSi; 
        Iterator<?> iterator, iterator2;
        Object cle, cle1;
        Object val,val1;
        Personnel personnel;
        RecordPersonnel recordPersonnel;
        JSONArray personnelResumes;
        JSONObject personnelResume;

        log.debug("REST request to get Record : {}", url);
        URL urlJsonServeur = new URL("http://localhost:3000/api/v1/personnels/search?*");
        HttpURLConnection conn = (HttpURLConnection) urlJsonServeur.openConnection();
        conn.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        String systemInf;
        List<String> tmp;
        recordPersonnel=new RecordPersonnel();
         while ((inputLine = in.readLine()) != null) {
          response.append(inputLine);
        }
        in.close();
        try {
            myResponse = new JSONArray(response.toString());
            for(int i=0;i< myResponse.length();i++){
                resulats=myResponse.getJSONObject(i).getJSONArray("resultats");
                for (int j=0;j<resulats.length();j++){
                    resultatSi=resulats.getJSONObject(j);
                    systemInf="";
                    for ( iterator = resultatSi.keys(); iterator.hasNext();) {
                        cle = iterator.next();
                        val = resultatSi.get(String.valueOf(cle));
                       
                        if(String.valueOf(cle).equals("2.25.b1196a4db489417ea343f425a5033060.1")){

                            systemInf=String.valueOf(val);
                             recordPersonnel.getMenu().add(String.valueOf(val));
                             // donnée résumé plusieurs personnel
                        }else if(String.valueOf(cle).equals("2.25.b1196a4db489417ea343f425a5033060.2")){
                            personnelResumes= (JSONArray)val;
                            for(int k=0;k< personnelResumes.length();k++){
                                personnel=new Personnel();
                                personnelResume= personnelResumes.getJSONObject(k);
                                for ( iterator2 = personnelResume.keys(); iterator2.hasNext();) {
                                    cle1 = iterator2.next();
                                    val1 =personnelResume.get(String.valueOf(cle1));
                                  
                                    if(String.valueOf(cle1).equals("2.5.4.4")){
                                        tmp=new ArrayList<String>();
                                        tmp.add(String.valueOf(val1));
                                        personnel.getPersonnelResume().put("Nom",tmp);

                                    }else if(String.valueOf(cle1).equals("2.5.6.1")){
                                        tmp=new ArrayList<String>();
                                        tmp.add(String.valueOf(val1)); 
                                        personnel.getPersonnelResume().put("Prénom",tmp);
                                    }else if(String.valueOf(cle1).equals("2.25.b1196a4db489417ea343f425a5033060.5")){
                                        tmp=new ArrayList<String>();
                                        tmp.add(String.valueOf(val1)); 
                                        personnel.getPersonnelResume().put("Date de naissance",tmp);


                                    }else if(String.valueOf(cle1).equals("2.25.b1196a4db489417ea343f425a5033060.8")){
                                        tmp=new ArrayList<String>();
                                        tmp.add(String.valueOf(val1)); 
                                        personnel.getPersonnelResume().put("Établissement",tmp);

                                    }
                                  
                                }
                                personnel.setSystemeInf(systemInf);
                                recordPersonnel.getResultat().add(personnel);


                            }


                        }
                      
                       
                    }

                }

            }
            
		} catch (JSONException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
            log.debug("erreur creation objet", e);
		}
    
       
        // appel webService
       /* List<Personnel> entities = new ArrayList<Personnel>();
        List<String> infoCom=new ArrayList<String>();
        List<String> infoCom1=new ArrayList<String>();
        infoCom.add("Libellé discipline : ARTS PLAST");
        infoCom.add("Modalité affectation :TPD POSTE DEF");
        infoCom.add("Dates affectations:P 01/09/1996 31/12/9999");

        infoCom1.add("Libellé discipline : ECO.GE.FIN");
        infoCom1.add("Modalité affectation :TPD POSTE DEF");
        infoCom1.add("Dates affectations: P 01/09/2017 31/12/9999 ");
        Personnel personnel1=new Personnel();
        Personnel personnel2=new Personnel();
        Personnel personnel3=new Personnel();
        personnel1.setNomSirhen("Atoss");
        personnel1.setPrenomSirhen("Kerhallet");
        personnel1.setLibelleSirhen("0290149E");
        personnel1.setDateNaissanceSirhen("25/06/1998");
        personnel1.setPositionSirhen("enseignant");


        personnel1.setNomAaf("nomAaf");
        personnel1.setPrenomAaf("prenomAaf");
        personnel1.setDateNaissanceAaf("18/07/1993");
        personnel1.setEtablissementAaf("emil zola");
        personnel1.setVilleAaf("Rennes");
        personnel1.setFonctionAaf("enseignant");
        personnel1.setDisciplineAaf("Math");

        personnel1.setNomEpp("simon");
        personnel1.setPrenomEpp("claire");
        personnel1.setInfoCompEpp(infoCom1);
        personnel1.setGradeEpp("Inspecteur");
        personnel1.setNumenEpp("numenEpp");
        personnel1.setPositionEpp("positionEpp");
        personnel1.setLibelleEpp("libelleEpp");
        personnel1.setDateNaissanceEpp("12/12/1993");
        personnel1.setFonctionEpp("enseignant");

        personnel1.setNomEppPrive("simon");
        personnel1.setPrenomEppPrive("charles");
        personnel1.setDateNaissanceEppPrive("18/01/1998");
        personnel1.setLibelleEppPrive("libelleEppPrive");
        personnel1.setPositionEppPrive("positionEppPrive");
        personnel1.setGradeEppPrive("Directeur");
        personnel1.setNumenEppPrive("05886655");
        personnel1.setInfoCompEppPrive(infoCom1);


        personnel2.setNomSirhen("Le-Helley");
        personnel2.setPrenomSirhen("Kévin");
        personnel2.setDateNaissanceSirhen("25/08/1988");
        personnel2.setPositionSirhen("enseignant");
        personnel2.setLibelleSirhen("0350063D");

        personnel2.setNomAaf("borgnol");
        personnel2.setPrenomAaf("lilou");
        personnel2.setDateNaissanceAaf("18/07/1993");
        personnel2.setEtablissementAaf("emil zola");
        personnel2.setVilleAaf("cesson sevigné");
        personnel2.setFonctionAaf("enseignant");
        personnel2.setDisciplineAaf("physique");

        personnel2.setNomEpp("gwendal");
        personnel2.setPrenomEpp("claire");
        personnel2.setInfoCompEpp(infoCom1);
        personnel2.setGradeEpp("Inspecteur");
        personnel2.setNumenEpp("numenEpp");
        personnel2.setPositionEpp("positionEpp");
        personnel2.setLibelleEpp("libelleEpp");
        personnel2.setDateNaissanceEpp("12/12/1993");
        personnel2.setFonctionEpp("enseignant");



        personnel2.setNomEppPrive("simon");
        personnel2.setPrenomEppPrive("Hug");
        personnel2.setDateNaissanceEppPrive("18/01/1998");
        personnel2.setLibelleEppPrive("libelleEppPrive");
        personnel2.setPositionEppPrive("positionEppPrive");
        personnel2.setGradeEppPrive("Directeur");
        personnel2.setNumenEppPrive("05886655");
        personnel2.setInfoCompEppPrive(infoCom1);


        personnel3.setNomSirhen("Loge");
        personnel3.setDateNaissanceSirhen("25/01/1978");
        personnel3.setPositionSirhen("administratif");
        personnel3.setPrenomSirhen("Kerentrech");
        personnel3.setLibelleSirhen("0560028B");
        personnel3.setNomAaf("bornibus");


        personnel3.setPrenomAaf("toto");
        personnel3.setDateNaissanceAaf("18/07/1993");
        personnel3.setEtablissementAaf("emil zola");
        personnel3.setVilleAaf("lannion");
        personnel3.setFonctionAaf("enseignant");
        personnel3.setDisciplineAaf("electronique");

        personnel3.setNomEpp("loulou");
        personnel3.setPrenomEpp("claire");
        personnel3.setInfoCompEpp(infoCom1);
        personnel3.setGradeEpp("Directeur");
        personnel3.setNumenEpp("numenEpp");
        personnel3.setPositionEpp("positionEpp");
        personnel3.setLibelleEpp("libelleEpp");
        personnel3.setDateNaissanceEpp("12/12/1993");
        personnel3.setFonctionEpp("enseignant");

        personnel3.setNomEppPrive("romain");
        personnel3.setPrenomEppPrive("charles");
        personnel3.setDateNaissanceEppPrive("18/01/1998");
        personnel3.setLibelleEppPrive("libelleEppPrive");
        personnel3.setPositionEppPrive("positionEppPrive");
        personnel3.setGradeEppPrive("Directeur");
        personnel3.setNumenEppPrive("05886655");
        personnel3.setInfoCompEppPrive(infoCom1);

        personnel3.setPrenomAgora("vincent");
        personnel3.setNomAgora("romain");
        personnel3.setDateNaissanceAgora("14/09/1983");
        personnel3.setPositionAgora("positionAgora");
        personnel3.setLibelleAgora("libelleAgora");
        personnel3.setInfoCompAgora(infoCom);
       
        entities.add(personnel1);
        entities.add(personnel2);
        entities.add(personnel3);*/
        return  new ResponseEntity<>(recordPersonnel, HttpStatus.OK);
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