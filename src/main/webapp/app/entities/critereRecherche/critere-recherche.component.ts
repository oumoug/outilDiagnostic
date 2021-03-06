import { Component, OnInit } from '@angular/core';
import { CritereRecherche } from './CritereRecherche.model';
import { CritereRechercheService } from './critere-recherche.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
@Component({
  selector: 'jhi-critere-recherche',
  templateUrl: './critere-recherche.component.html',
  styles: []
})
export class CritereRechercheComponent implements OnInit {
  subscription: Subscription;
  optionProfils: {};
  isResultat: Boolean;
  isErreur: Boolean;
  lengthChampsValid: Boolean;
  profil: Boolean;
  loulou: string[];
  rechercheRepresantant: CritereRecherche;
  constructor(
    private critereRechercheService: CritereRechercheService,
    private router: Router,
    private activatedRoute: ActivatedRoute) {
    this.optionProfils = {'personnel': 'Personnels',
    'eleve': 'Élève',
    'representantLegal': 'Représentants légaux'};
    this.isResultat = false;
    this.isErreur = false;
    this.lengthChampsValid = false;
    this.profil = false;
  }

  ngOnInit() {
    this.subscription = this.activatedRoute.queryParams.subscribe((params) => {
     if (params !== undefined) {
          this.loulou = params['profil'];
        /* this.rechercheRepresantant.profil=params['profil']
          this.rechercheRepresantant.nom=params['nom']
          this.rechercheRepresantant.prenom=params['prenom']*/
          if (params['nom'] !== undefined) {
            this.critereRechercheService.getCritere().nom = params['nom'];
            }
          if (params['prenom'] !== undefined) {this.critereRechercheService.getCritere().prenom = params['prenom'];
        }
          if (params['profil'] !== undefined) {this.critereRechercheService.getCritere().profil = params['profil'];
        }
          this.router.navigate([ this.critereRechercheService.getCritere().profil], { skipLocationChange: true });

    }
  }
  );
  }
  getKeyOptionProfil() {
    return Array.from(Object.keys(this.optionProfils));
  }
  search() {
    this.isErreur = false;
    this.lengthChampsValid = false;
    this.profil = false;
    this.isResultat = false;
    if (this.critereRechercheService.getCritere().profil !== '') {
      if (this.valideNbChamps() >= 2) {
        if (this.valideLengthChamps()) {
          this.router.navigate([this.critereRechercheService.getCritere().profil], {skipLocationChange: true});
          this.critereRechercheService.setIsSearch(true);
          this.isResultat = true;
        }else {
          this.lengthChampsValid = true;
        }
      }else {
        this.isErreur = true;
      }
    }else {
      this.profil = true;
    }
  }
  valideNbChamps() {
    let nbchamp = 0;
    if (this.critereRechercheService.getCritere().nom !== '') {
      nbchamp = nbchamp + 1;
    }
    if (this.critereRechercheService.getCritere().prenom !== '' ) {
      nbchamp = nbchamp + 1;
    }
    if (this.critereRechercheService.getCritere().etablissement !== '') {
      nbchamp = nbchamp + 1;
    }
    if (this.critereRechercheService.getCritere().mail !== '') {
        nbchamp = nbchamp + 1;
    }
    return   nbchamp;
  }
  valideLengthChamps() {
    if (this.critereRechercheService.getCritere().nom !== '' && this.critereRechercheService.getCritere().nom.length < 3) {
      return false;
    }else if (this.critereRechercheService.getCritere().prenom !== '' && this.critereRechercheService.getCritere().prenom.length < 3) {
      return false;
    }else if (this.critereRechercheService.getCritere().etablissement !== '' && this.critereRechercheService.getCritere().etablissement.length < 3) {
        return false;
    }else if (this.critereRechercheService.getCritere().mail !== '' && this.critereRechercheService.getCritere().mail.length < 3) {
        return false;
    }else {
        return true;
    }
  }
  getCritereRechercheService() {
    return this.critereRechercheService;
  }
}
