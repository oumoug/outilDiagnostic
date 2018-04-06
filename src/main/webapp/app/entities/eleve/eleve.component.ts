import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router} from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import {CritereRecherche,CritereRechercheService} from '../critereRecherche/'
import {EleveService} from './eleve.service'
import {EleveRecord} from './eleveRecord.model'
import {Eleve} from './eleve.model'
import {JhiAlertService } from 'ng-jhipster';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import {Parent} from '.'
@Component({
  selector: 'jhi-eleve',
  templateUrl: './eleve.component.html',
  styles: []
})
export class EleveComponent implements OnInit {
  subscription:Subscription  
  eleveRecord:EleveRecord
  hover:boolean
  constructor(private router: Router,private eleveService:EleveService,
    private jhiAlertService:JhiAlertService,
    private activatedRoute:ActivatedRoute,private critereRechercheService:CritereRechercheService ) {   
      this.eleveRecord={menus:[],eleves:[]}
   }

  ngOnInit() {
    this.eleveService.search(this.critereRechercheService.getCritere()).subscribe(
      (res: HttpResponse<EleveRecord>) => this. setElevelRecord(res.body),
      (res: HttpErrorResponse) => this.onError(res.message));
      this.critereRechercheService.ongletActive='Résumé'
     this.eleveService.eleveOnglets= this.initEleveOnglets(this.eleveRecord.menus);
     this.hover=true
  }
  setElevelRecord(data){
    this.eleveRecord.menus=data.menus;
    this.eleveRecord.eleves=data.eleves
   }
  searchRepresentant(representant:Parent){
   /* this.critereRechercheService.getCritere().profil='representantLegal';
    if(representant.nom!==''){
      this.critereRechercheService.getCritere().nom=representant.nom

    }
    if(representant.prenom!==''){
      this.critereRechercheService.getCritere().prenom=representant.prenom
    }*/
   //this.router.navigate([this.critereRechercheService.getCritere().profil],{skipLocationChange: true });
    //window.open("http://localhost:8080/#/?profil=representantLegal&nom="+representant.prenom+"&prenom="+representant.prenom);
    //window.open("/?profil=representantLegal&nom="+representant.prenom+"&prenom="+representant.prenom);

  }
  getParentSystemInf(menu:string,eleve:Eleve){
    let Parents=[]
    for (let parent of eleve.representant){
      if( parent.systemInf===menu){
        Parents.push(parent)

      }
    }
    return Parents;
  
}
  getEleveService(){
    return this.eleveService
  }
  afficheDetail(eleve:Eleve,menu:string){
    if(eleve===this.eleveService.getEleveOnglet(menu)){
      this.hover=true
      this.eleveService.setEleveOnglet(menu,null)
     }else{
      this.hover=false
      this.eleveService.setEleveOnglet(menu,eleve)
     }
    
  }
  initEleveOnglets(menus:string[]){
    let eleveOnglets=new Map()
    for(let menu of menus){
      eleveOnglets.set(menu,null);
    }
    return  eleveOnglets;

  }
  ongletActif(onglet:string){
    this.critereRechercheService.setOngletActive(onglet);
   }
  private onError(error) {
    this.jhiAlertService.error(error.message, null, null);
  }
  getCritereRechercheService(){
    return this.critereRechercheService;
  }
  getkeys(myMap:Map<string,string[]>){

    return Array.from(Object.keys(myMap));
   }

   getEleveSystemeInf(systemInf:string){
     for( let eleve of this.eleveRecord.eleves){
       if(eleve.systemeInf===systemInf){
         return eleve
 
       }
 
     }
   }

}
