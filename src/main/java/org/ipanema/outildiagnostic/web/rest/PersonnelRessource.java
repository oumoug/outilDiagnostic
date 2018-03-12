package org.ipanema.outildiagnostic.web.rest;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.codahale.metrics.annotation.Timed;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.ipanema.outildiagnostic.service.dto.CritereRecherche;
import org.ipanema.outildiagnostic.service.dto.Record;
import org.ipanema.outildiagnostic.service.dto.Personnel;

@RestController
@RequestMapping("/api")
public class PersonnelRessource{
    private final Logger log = LoggerFactory.getLogger(PersonnelRessource.class);

    @PostMapping("/personnels")
    @Timed
    public ResponseEntity<List<Personnel>> appelWebService(@Valid @RequestBody CritereRecherche critere){
        log.debug("REST request to get Record : {}", critere);
        
        // appel webService
        List<Personnel> entities = new ArrayList<Personnel>();
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
        personnel2.setDisciplineAaf("phisique");
        personnel3.setNomSirhen("Loge");
        personnel3.setDateNaissanceSirhen("25/01/1978");
        personnel3.setPositionSirhen("administratif");
        personnel3.setPrenomSirhen("Kerentrech");
        personnel3.setLibelleSirhen("0560028B");
        personnel3.setNomAaf("bornibus");
        personnel1.setPrenomAaf("toto");
        personnel1.setDateNaissanceAaf("18/07/1993");
        personnel1.setEtablissementAaf("emil zola");
        personnel1.setVilleAaf("lannion");
        personnel1.setFonctionAaf("enseignant");
        personnel1.setDisciplineAaf("electronique");
        personnel1.setNomEpp("loulou");
        personnel1.setNomEppPrive("nomEppPrive");
        personnel1.setPositionAgora("positionAgora");
        entities.add(personnel1);
        entities.add(personnel2);
        entities.add(personnel3);
        return  new ResponseEntity<>(entities, HttpStatus.OK);
    }


}