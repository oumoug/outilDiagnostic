import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import {CritereRecherche} from './CritereRecherche.model'
import { SERVER_API_URL } from '../../app.constants';
import { Observable } from 'rxjs/Observable';
import {Eleve} from '../eleve/eleve.model'
import {Personnel} from '../personnels/personnels.model'
import {createRequestOption } from '../../shared';
import {LibelleTableau} from '.'

@Injectable()
export class CritereRechercheService {
  critereRecherche:CritereRecherche
  ongletActive:string
  isSearch:Boolean
  libelleTableauxPersonnel:LibelleTableau[]

  constructor(private http:HttpClient) { 
    this.critereRecherche={nom:'',prenom:'',mail:'',etablissement:'',profil:''}
    this.ongletActive='Résumé'
    this.isSearch=false;
    this.libelleTableauxPersonnel=[]
    
  }
  getIsSearch(){
    return this.isSearch
  }
  setIsSearch(val:Boolean){
    this.isSearch=val
  }

  loadJson(){
    this.http.get('/personnel.json',{responseType: 'json' }).subscribe(
      data=>data['personnel'].map(
        personnel=> this.libelleTableauxPersonnel.push({
          nomSi:personnel.systemeInf,
          libelleTableauResume:personnel.resume,
          libelleTAbleauDetail:personnel.detaille
        })

      )
    )
  }
  getOngletActive(){
    return this.ongletActive;
  }
  setOngletActive(onglet:string){
    this.ongletActive=onglet;
  }
  getCritere(){
    return  this.critereRecherche
  }
  setCritere(critere:CritereRecherche){
    this.critereRecherche=critere;
  }
  
}
