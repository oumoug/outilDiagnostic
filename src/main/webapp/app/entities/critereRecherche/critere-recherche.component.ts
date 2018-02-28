import { Component, OnInit } from '@angular/core';
import {CritereRecherche} from './CritereRecherche.model'
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';
import { Router } from '@angular/router';

@Component({
  selector: 'jhi-critere-recherche',
  templateUrl: './critere-recherche.component.html',
  styles: []
})
export class CritereRechercheComponent implements OnInit {
  critereRecherche :CritereRecherche
  optionProfils:string[]
  isResultat:Boolean
  isSearch:Boolean
  isErreur:Boolean
  lengthChampsValid:Boolean
  isUppercase:Boolean
  containSpecialCaractere:Boolean
  router:Router
  profil:Boolean
  constructor(private jhiAlertService: JhiAlertService,) { 
    this.optionProfils=[];
    this.isResultat=false;
    this.isSearch=false;
    this.isErreur=false;
    this.lengthChampsValid=false;
    this.isUppercase=false;
    this. containSpecialCaractere=false;
    this.profil=false;
    this.critereRecherche={nom:"",prenom:"",mail:"",etablissement:"",profil:""}
  }

  ngOnInit() {
  
    this.initOptionProfil();
  }
  initOptionProfil(){
    this.optionProfils.push("Personnels");
    this.optionProfils.push("Élève");
    this.optionProfils.push("Représentants légaux");
    

  }
  search(){
    this.isErreur=false;
    this.lengthChampsValid=false;
    this.isUppercase=false
    this. containSpecialCaractere=false;
    this.profil=false;
    if(this.critereRecherche.profil!=""){
      if(this.valideNbChamps()>=2){
        if(this.valideLengthChamps()){
          if(this.valideLowercase()){
  
          }else{
              this.isUppercase=true;
          } 
        }else{
          this.lengthChampsValid=true;
  
        }
           
      }else{
        this.isErreur=true;
      }
    }else{
      this.profil=true;
    }
    
  }
  valideNbChamps(){
    let nbchamp=0
    if(this.critereRecherche.nom !=="" ){
      nbchamp=nbchamp+1;
    }
    if( this.critereRecherche.prenom !== "" ){
      nbchamp=nbchamp+1;
    }
    if(this.critereRecherche.etablissement !== ""){
      nbchamp=nbchamp+1;
    }
    if(this.critereRecherche.mail !== ""){
        nbchamp=nbchamp+1;
    }
    return   nbchamp;
}
  valideLowercaseString(valeur:string){
    /*let regExp=/^[a-z]*$/;
    if(valeur.match(regExp)){
      return false;
    }else{
      return true;
    }*/
    for(let i=0;i<valeur.length;i++){
      if(valeur.charCodeAt(i)>=65 && valeur.charCodeAt(i)<=90){
          return false; 
      }
     
    }
    return true;
   
}
valideLowercase(){
  if(this.critereRecherche.nom !="" &&  ! this.valideLowercaseString(this.critereRecherche.nom)){
    return false
  }else if(this.critereRecherche.prenom != "" && ! this.valideLowercaseString(this.critereRecherche.prenom)){
    return false
  }else if(this.critereRecherche.etablissement != "" && ! this.valideLowercaseString(this.critereRecherche.etablissement)) {
      return false
  }else if(this.critereRecherche.mail != "" && ! this.valideLowercaseString(this.critereRecherche.mail)){
      return false
  }else{
       return true
  }
}
  valideLengthChamps(){
    if(this.critereRecherche.nom !="" && this.critereRecherche.nom.length<3){
      return false
    }else if(this.critereRecherche.prenom != "" && this.critereRecherche.prenom.length<3){
      return false
    }else if(this.critereRecherche.etablissement !="" && this.critereRecherche.etablissement.length<3) {
        return false
    }else if(this.critereRecherche.mail !="" && this.critereRecherche.mail.length<3){
        return false
    }else{
        return true
    }
  }
  valideCaractereSpecialString(valeur:string){
    let regExp=/[^a-zA-Z0-9.]/g;
    if(valeur.match(regExp)){
      return false
    }else{
      return true;
    }
  }
  valideCaractereSpecial(){
    if(this.critereRecherche.nom !="" && ! this.valideCaractereSpecialString(this.critereRecherche.nom)){
      return false
    }else if(this.critereRecherche.prenom != "" && ! this.valideCaractereSpecialString(this.critereRecherche.prenom)){
      return false
    }else if(this.critereRecherche.etablissement !="" && ! this.valideCaractereSpecialString(this.critereRecherche.etablissement)) {
        return false
    }else{
        return true
    }

  }
  private onError(error:string) {
    this.jhiAlertService.error(error, null, null);
  }

}
