import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import {CritereRechercheService} from '../critereRecherche/'
import {ResponsableRecord, Responsable} from '.'
import {RepresentantLegalService} from './representant-legal.service'
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import {JhiAlertService } from 'ng-jhipster';
import {Enfant} from '.';

@Component({
  selector: 'jhi-representant-legal',
  templateUrl: './representant-legal.component.html',
  styles: []
})
export class RepresentantLegalComponent implements OnInit {
  subscription:Subscription  
  profil:string
  responsableRecord:ResponsableRecord
  constructor(
    private router:Router ,
    private representantLegalService:RepresentantLegalService,
    private jhiAlertService:JhiAlertService,
    private critereRechercheService:CritereRechercheService,private activatedRoute: ActivatedRoute ) { 
      this. responsableRecord={menus:[],responsables:[]}
  }

  ngOnInit() {
   this.representantLegalService.search(this.critereRechercheService.getCritere()).subscribe(
      (res: HttpResponse<ResponsableRecord>) => this.setResponsableRecord(res.body),
      (res: HttpErrorResponse) => this.onError(res.message));
      this. critereRechercheService.ongletActive='Résumé'
      this.representantLegalService.responsableOnglets=this.initResponsableOnglets(this.responsableRecord.menus);
     /* this.subscription=this.activatedRoute.queryParams.subscribe((params) => {
        if(params!==undefined){
            // this.loulou=params['profil']
            this.rechercheRepresantant.profil=params['profil']
             this.rechercheRepresantant.nom=params['nom']
             this.rechercheRepresantant.prenom=params['prenom']
             if(params['nom']!==undefined){
               this.critereRechercheService.getCritere().nom=params['nom']
               }
             if(params['prenom']!==undefined){this.critereRechercheService.getCritere().prenom=params['prenom']}
             if(params['profil']!==undefined){this.critereRechercheService.getCritere().profil=params['profil']}
            // this.router.navigate([ this.critereRechercheService.getCritere().profil],{skipLocationChange: true });
   
       }
     }
      )*/
  }
  ongletActif(onglet:string){
    this.critereRechercheService.setOngletActive(onglet);
   }

  setResponsableRecord(data){
    this.responsableRecord.menus=data.menus
    this.responsableRecord.responsables=data.responsables
  }
  searchEleve(enfant:Enfant){
    this.critereRechercheService.getCritere().profil='eleve';
    if(enfant.nom!==''){
      this.critereRechercheService.getCritere().nom=enfant.nom

    }
    if(enfant.prenom!==''){
      this.critereRechercheService.getCritere().prenom=enfant.prenom
    }
    this.router.navigate([this.critereRechercheService.getCritere().profil],{skipLocationChange: true });

  }
  private onError(error) {
    this.jhiAlertService.error(error.message, null, null);
  }
  afficheDetail(responsable:Responsable,menu:string){
    if(responsable=== this.representantLegalService.getResponsableOnglet(menu)){
      this.representantLegalService.setResponsableOnglet(menu,null)
     }else{
      this.representantLegalService.setResponsableOnglet(menu,responsable)
     }
  
  }
  initResponsableOnglets(menus:string[]){
    let responsableOnglets=new Map()
    for(let menu of menus){
      responsableOnglets.set(menu,null);
    }
    return  responsableOnglets;

  }
  getCritereRechercheService(){
    return this.critereRechercheService

  }
  getkeys(myMap:Map<string,string[]>){

    return Array.from(Object.keys(myMap));
   }
   getResponsableSystemeInf(systemInf:string){
     for( let responsable of this.responsableRecord.responsables){
       if( responsable.systemeInf===systemInf){
         return  responsable
 
       }
 
     }
   }
  
   getRepresentantLegalService(){
     return this.representantLegalService
   }
}
