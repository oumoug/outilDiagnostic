import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import{CritereRecherche} from "./CritereRecherche.model"
import { SERVER_API_URL } from '../../app.constants';
import { Observable } from 'rxjs/Observable';
import{Eleve} from "../eleve/eleve.model"
import{Personnel} from "../personnels/personnels.model"
import { createRequestOption } from '../../shared';

@Injectable()
export class CritereRechercheService {
  critereRecherche:CritereRecherche
  ongletActive:string

  constructor() { 
    this.critereRecherche={nom:"",prenom:"",mail:"",etablissement:"",profil:""}
    this.ongletActive="resume"
    
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
  loadProfil(profil:string){
    if(profil==="personnel"){
      this.critereRecherche.profil="Personnels";
    }else if(profil=== "eleve"){
      this.critereRecherche.profil="Élève";
    }else if(profil==="representantLegal"){
      this.critereRecherche.profil="Représentants légaux";
    }


  }
  
}
