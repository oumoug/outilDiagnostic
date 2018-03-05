import { Component, OnInit} from '@angular/core';
import {CritereRecherche} from './CritereRecherche.model'
import { JhiEventManager, JhiAlertService } from 'ng-jhipster';
import { Router,ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';



@Component({
  selector: 'jhi-critere-recherche',
  templateUrl: './critere-recherche.component.html',
  styles: []
})
export class CritereRechercheComponent implements OnInit {
  critereRecherche :CritereRecherche
  subscription:Subscription
  optionProfils:string[]
  isResultat:Boolean
  isSearch:Boolean
  isErreur:Boolean
  lengthChampsValid:Boolean
  isUppercase:Boolean
  containSpecialCaractere:Boolean
  profil:Boolean
  menu:String
  menuActive:string
  constructor(private jhiAlertService: JhiAlertService,private router:Router,private activatedRoute:ActivatedRoute) { 
    this.optionProfils=[]
    this.isResultat=false;
    this.isSearch=false;
    this.isErreur=false;
    this.lengthChampsValid=false;
    this.isUppercase=false;
    this. containSpecialCaractere=false;
    this.profil=false;
    this.menu="";
    this.menuActive="resume"
    this.critereRecherche={nom:"",prenom:"",mail:"",etablissement:"",profil:""}
  }
  menuActif(menu:String,composant:string){
    this.router.navigate([composant],{ queryParams:{'menuActive':menu} , skipLocationChange: true });


  }

  ngOnInit() {
    this.subscription=this.activatedRoute.queryParams.subscribe((params) => {
      if(params!=undefined){
      
        if(params['nom']!=undefined){
          this.critereRecherche.nom=params['nom']
        }
        if(params['prenom']!=undefined){
          this.critereRecherche.prenom=params['prenom']
        }
        if(params['mail']!=undefined){
          this.critereRecherche.mail=params['mail']
        }
        if(params['etablissement']!=undefined){
          this.critereRecherche.etablissement=params['etablissement']
        }
        if(params['profil']!=undefined ){
          this.menu=params['profil'];
          this.loadProfil(params['profil']);
        }
        if(params['menuActive']!=undefined){
          this.menuActive=params['menuActive']
        }
      }
     
    });
  
    this.initOptionProfil();
  }
  initOptionProfil(){
    this.optionProfils.push("Personnels");
    this.optionProfils.push("Élève");
    this.optionProfils.push("Représentants légaux");
    

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
  saveProfil(profil:string){
   
    if(profil==="Personnels"){
      this.critereRecherche.profil="personnel";
     
      this.router.navigate([this.critereRecherche.profil],{ queryParams:this.critereRecherche , skipLocationChange: true });
      
    }else if(profil==="Élève"){
      this.critereRecherche.profil="eleve";
      this.router.navigate([this.critereRecherche.profil],{ queryParams:this.critereRecherche , skipLocationChange: true});
    }else if(profil==="Représentants légaux"){
      this.critereRecherche.profil="representantLegal";
      this.router.navigate([this.critereRecherche.profil],{ queryParams:this.critereRecherche , skipLocationChange: true });
    }

  }
  search(){
    this.isErreur=false;
    this.lengthChampsValid=false;
    this.isUppercase=false
    this. containSpecialCaractere=false;
    this.profil=false;
    this.isResultat=false;
    if(this.critereRecherche.profil!==""){
      if(this.valideNbChamps()>=2){
        if(this.valideLengthChamps()){
          if(this.valideLowercase()){
            this.saveProfil(this.critereRecherche.profil);
            this.isResultat=true;
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
  if(this.critereRecherche.nom !=="" &&  ! this.valideLowercaseString(this.critereRecherche.nom)){
    return false
  }else if(this.critereRecherche.prenom !== "" && ! this.valideLowercaseString(this.critereRecherche.prenom)){
    return false
  }else if(this.critereRecherche.etablissement !== "" && ! this.valideLowercaseString(this.critereRecherche.etablissement)) {
      return false
  }else if(this.critereRecherche.mail !== "" && ! this.valideLowercaseString(this.critereRecherche.mail)){
      return false
  }else{
       return true
  }
}
  valideLengthChamps(){
    if(this.critereRecherche.nom !=="" && this.critereRecherche.nom.length<3){
      return false
    }else if(this.critereRecherche.prenom !== "" && this.critereRecherche.prenom.length<3){
      return false
    }else if(this.critereRecherche.etablissement !=="" && this.critereRecherche.etablissement.length<3) {
        return false
    }else if(this.critereRecherche.mail !=="" && this.critereRecherche.mail.length<3){
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
    if(this.critereRecherche.nom !=="" && ! this.valideCaractereSpecialString(this.critereRecherche.nom)){
      return false
    }else if(this.critereRecherche.prenom !== "" && ! this.valideCaractereSpecialString(this.critereRecherche.prenom)){
      return false
    }else if(this.critereRecherche.etablissement !=="" && ! this.valideCaractereSpecialString(this.critereRecherche.etablissement)) {
        return false
    }else{
        return true
    }

  }
  private onError(error:string) {
    this.jhiAlertService.error(error, null, null);
  }

}
