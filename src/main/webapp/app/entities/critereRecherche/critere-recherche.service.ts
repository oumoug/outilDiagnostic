import { Injectable } from '@angular/core';
import { CritereRecherche } from './CritereRecherche.model';
import { LibelleTableau } from '.';
@Injectable()
export class CritereRechercheService {
  critereRecherche: CritereRecherche;
  ongletActive: string;
  isSearch: Boolean;
  libelleTableauxPersonnel: LibelleTableau[];
  constructor() {
    this.critereRecherche = {nom: '', prenom: '', mail : '', etablissement: '', profil: ''};
    this.ongletActive = 'Résumé';
    this.isSearch = false;
    this.libelleTableauxPersonnel = [];
  }
  getIsSearch() {
    return this.isSearch;
  }
  setIsSearch(val: Boolean) {
    this.isSearch = val;
  }
  /*loadJson() {
    this.http.get('/personnel.json',{responseType: 'json' }).subscribe(
      data=>data['personnel'].map(
        personnel=> this.libelleTableauxPersonnel.push({
          nomSi:personnel.systemeInf,
          libelleTableauResume:personnel.resume,
          libelleTAbleauDetail:personnel.detaille
        })
      )
    );
  }*/
  getOngletActive() {
    return this.ongletActive;
  }
  setOngletActive(onglet: string) {
    this.ongletActive = onglet;
  }
  getCritere() {
    return  this.critereRecherche;
  }
  setCritere(critere: CritereRecherche) {
    this.critereRecherche = critere;
  }
}
