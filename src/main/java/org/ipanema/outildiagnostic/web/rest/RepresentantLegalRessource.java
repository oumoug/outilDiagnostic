package org.ipanema.outildiagnostic.web.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.codahale.metrics.annotation.Timed;

import org.ipanema.outildiagnostic.service.dto.CritereRecherche;
import org.ipanema.outildiagnostic.service.dto.RepresentantLegal;
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
    public ResponseEntity<List<RepresentantLegal>> appelWebService(@Valid @RequestBody CritereRecherche critere){
        log.debug("REST request to get Record : {}", critere);
        // appel webService
        List<RepresentantLegal> entities = new ArrayList<RepresentantLegal>();
        List<String> enfant=new  ArrayList<String>();
        enfant.add("uid1");
        enfant.add("uid2");
        enfant.add("uid3");
        RepresentantLegal representant1=new RepresentantLegal();
        RepresentantLegal representant2=new RepresentantLegal();
        RepresentantLegal representant3=new RepresentantLegal();
        representant1.setNomAaf("moa");
        representant1.setPrenomAaf("lulu");
        representant1.setEtablissementAaf("jeanne d'arc");


        representant1.setNomAten("moa");
        representant1.setPrenomAten("lulu");
        representant1.setLastConAten("10/01/2018");
        representant1.setEtatcompteAten("activé");
        representant1.setIdentifiantEnfantAten(enfant);

        representant1.setNomEduconnect("moa");
        representant1.setPrenomEduconnect("lulu");
        representant1.setMailEduconnect("ouloulou.borgnol@hotmail.fr");
        representant1.setIdentifiantEnfantEduconnect(enfant);


        representant2.setNomAaf("moa");
        representant2.setPrenomAaf("lulu");
        representant2.setEtablissementAaf("jeanne d'arc");
        
        representant2.setNomEduconnect("moa");
        representant2.setPrenomEduconnect("lulu");
        representant2.setMailEduconnect("ouloulou.borgnol@hotmail.fr");
        representant2.setIdentifiantEnfantEduconnect(enfant);

        representant2.setNomAten("moa");
        representant2.setPrenomAten("lulu");
        representant2.setLastConAten("10/01/2018");
        representant2.setEtatcompteAten("activé");
        representant2.setIdentifiantEnfantAten(enfant);


        representant3.setNomAaf("moa");
        representant3.setPrenomAaf("lulu");
        representant3.setEtablissementAaf("jeanne d'arc");

        representant3.setNomAten("moa");
        representant3.setPrenomAten("lulu");
        representant3.setLastConAten("10/01/2018");
        representant3.setEtatcompteAten("activé");
        representant3.setIdentifiantEnfantAten(enfant);


        representant3.setNomEduconnect("moa");
        representant3.setPrenomEduconnect("lulu");
        representant3.setMailEduconnect("ouloulou.borgnol@hotmail.fr");
        representant3.setIdentifiantEnfantEduconnect(enfant);
        entities.add(representant1);
        entities.add(representant2);
        entities.add(representant3);

        return  new ResponseEntity<>(entities, HttpStatus.OK);
    }
}