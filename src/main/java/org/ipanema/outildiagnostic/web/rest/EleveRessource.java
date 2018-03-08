package org.ipanema.outildiagnostic.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.codahale.metrics.annotation.Timed;

import org.ipanema.outildiagnostic.service.dto.CritereRecherche;
import org.ipanema.outildiagnostic.service.dto.Eleve;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EleveRessource{
    private final Logger log = LoggerFactory.getLogger(EleveRessource.class);
    @PostMapping("/eleves")
    @Timed
    public ResponseEntity<List<Eleve>> appelWebService(@Valid @RequestBody CritereRecherche critere){
        log.debug("REST request to get Record : {}", critere);
        // appel webService
        List<Eleve> entities = new ArrayList<Eleve>();
        List<String> parent=new ArrayList<String>();
        Eleve eleve1=new Eleve();
        Eleve eleve2=new Eleve();
        Eleve eleve3=new Eleve();
        parent.add("uuid1");
        parent.add("uuid2");
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
         
        eleve1.setNomAten("nomAten");
        eleve1.setPrenomAten("prenomAten");
        eleve1.setEtablissementAten("ledantec");
        eleve1.setRepresentantLegalAten(parent);
        eleve1.setRepresentantLegalSiecle(parent);

        eleve2.setNomAaf("titi");
        eleve2.setClasseAaf("cm2");
        eleve2.setPrenomAaf("loulu");
        eleve2.setDateNaissanceAaf("25/08/1993"); 
        eleve2.setEtablissementAaf("lyce briquigni"); 
        eleve2.setIdentifiantAaf("identifant aaf");
        eleve2.setRepresentantLegalAten(parent);
        eleve2.setRepresentantLegalSiecle(parent); 

        eleve2.setNomToutatice("titi");
        eleve2.setPrenomToutatice("loulu");
        eleve2.setIdentifiantToutatice("uid7");
        eleve2.setEtatCompteToutatice("active");

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
        eleve3.setRepresentantLegalAten(parent);
        eleve3.setRepresentantLegalSiecle(parent);
        entities.add(eleve1);
        entities.add(eleve2);
        entities.add(eleve3);
        return  new ResponseEntity<>(entities, HttpStatus.OK);
    }
}