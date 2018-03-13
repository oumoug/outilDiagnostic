package org.ipanema.outildiagnostic.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.codahale.metrics.annotation.Timed;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import org.ipanema.outildiagnostic.service.dto.CritereRecherche;
import org.ipanema.outildiagnostic.service.dto.Eleve;
import org.ipanema.outildiagnostic.service.dto.Parent;
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
    public ResponseEntity<List<Eleve>> appelWebService(@Valid @RequestBody CritereRecherche critere) throws UnsupportedEncodingException{
       String url= formatUrl(critere);
        log.debug("REST request to get Record : {}", url);
        // appel webService
        List<Eleve> entities = new ArrayList<Eleve>();
        List<Parent> parent=new ArrayList<Parent>();
        Eleve eleve1=new Eleve();
        Eleve eleve2=new Eleve();
        Eleve eleve3=new Eleve();
        Parent parent1=new Parent();
        Parent parent2=new Parent();
        parent1.setNom("papa");
        parent2.setNom("maman");
        parent2.setPrenom("borgnol");
        parent1.setPrenom("borgnol");
        

        parent.add( parent1);
        parent.add( parent2);
        eleve1.setNomAaf("titi");
        eleve1.setPrenomAaf("loulu");
        eleve1.setClasseAaf("cm2");
        eleve1.setDateNaissanceAaf("25/08/1993");  
        eleve1.setEtablissementAaf("lyce briquigni");
        eleve1.setIdentifiantAaf("identifant aaf");

        eleve1.setNomToutatice("titi");
        eleve1.setPrenomToutatice("loulu");
        eleve1.setIdentifiantToutatice("uid7");
        eleve1.setEtatCompteToutatice("active");
        eleve1.setLastConToutatice("12/03/2018");
        eleve1.setMailToutatice("titi.lulu@ac-rennes.fr");
         
        eleve1.setNomAten("paul");
        eleve1.setPrenomAten("ramsess");
        eleve1.setEtablissementAten("ledantec");
        eleve1.setIdentifiantAten("vgfg851");
        eleve1.setDateNaissanceAten("17/03/1953");
        eleve1.setRepresentantLegalAten(parent);

        eleve1.setNomSiecle("emilie");
        eleve1.setPrenomSiecle("bozaz");
        eleve1.setIdentifiantSiecle("0125rrg");
        eleve1.setDateNaissanceSiecle("25/11/1993");
        eleve1.setEtablissementSiecle("etablissement Rennes");
        eleve1.setRepresentantLegalSiecle(parent);

        eleve2.setNomAaf("titi");
        eleve2.setClasseAaf("cm2");
        eleve2.setPrenomAaf("loulu");
        eleve2.setDateNaissanceAaf("25/08/1993"); 
        eleve2.setEtablissementAaf("lyce briquigni"); 
        eleve2.setIdentifiantAaf("identifant aaf");

        eleve2.setNomAten("paul");
        eleve2.setPrenomAten("ramsess");
        eleve2.setEtablissementAten("ledantec");
        eleve2.setIdentifiantAten("vgfg851");
        eleve2.setDateNaissanceAten("17/03/1953");
        eleve2.setRepresentantLegalAten(parent);

        eleve2.setNomSiecle("dada");
        eleve2.setPrenomSiecle("borgnol");
        eleve2.setIdentifiantSiecle("0125rrg");
        eleve2.setDateNaissanceSiecle("25/11/1993");
        eleve2.setEtablissementSiecle("etablissement Rennes");
        eleve2.setRepresentantLegalSiecle(parent); 

        eleve2.setNomToutatice("titi");
        eleve2.setPrenomToutatice("loulu");
        eleve2.setIdentifiantToutatice("uid7");
        eleve2.setEtatCompteToutatice("active");
        eleve2.setLastConToutatice("12/03/2018");
        eleve2.setMailToutatice("titi.lulu@ac-rennes.fr");

        eleve3.setNomAaf("titi");
        eleve3.setClasseAaf("cm2");
        eleve3.setPrenomAaf("loulu");
        eleve3.setDateNaissanceAaf("25/08/1993");  
        eleve3.setEtablissementAaf("lyce briquigni");
        eleve3.setIdentifiantAaf("identifant aaf");
        
        eleve3.setNomToutatice("titi");
        eleve3.setPrenomToutatice("loulu");
        eleve3.setIdentifiantToutatice("uid7");
        eleve3.setEtatCompteToutatice("active");
        eleve3.setLastConToutatice("12/03/2018"); 
        eleve3.setMailToutatice("titi.lulu@ac-rennes.fr");

        eleve3.setNomAten("paul");
        eleve3.setPrenomAten("ramsess");
        eleve3.setEtablissementAten("ledantec");
        eleve3.setIdentifiantAten("vgfg851");
        eleve3.setDateNaissanceAten("17/03/1953"); 
        eleve3.setRepresentantLegalAten(parent);

        eleve3.setNomSiecle("thomas");
        eleve3.setPrenomSiecle("bozaz");
        eleve3.setIdentifiantSiecle("0125rrg");
        eleve3.setDateNaissanceSiecle("25/11/1993");
        eleve3.setEtablissementSiecle("etablissement Rennes");
        eleve3.setRepresentantLegalSiecle(parent);
        entities.add(eleve1);
        entities.add(eleve2);
        entities.add(eleve3);
        return  new ResponseEntity<>(entities, HttpStatus.OK);
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