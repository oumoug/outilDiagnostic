import { Component, OnInit} from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import {CritereRechercheService} from '../critereRecherche/';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import {CritereRechercheModule } from '../critereRecherche/critere-recherche.module'
import {JhiAlertService } from 'ng-jhipster'
import {Personnel} from './personnels.model'
import {PersonnelService} from './personnel.service'
import {PersonnelRecord} from './personnelRecord.model'

@Component({
  selector: 'jhi-personnels',
  templateUrl: './personnels.component.html',
  styles: []
})
export class PersonnelsComponent implements OnInit {
  subscription:Subscription  
  personnels:Personnel[]
  personnelRecord:PersonnelRecord
 
  
  constructor(
    private personnelService:PersonnelService,
    private jhiAlertService:JhiAlertService,
    private critereRechercheService:CritereRechercheService ) {
    this.personnels=[]
    this.personnelRecord={menus:[],personnels:[]}
   }

  ngOnInit() {
   // this.critereRechercheService.loadProfil(this.critereRechercheService.getCritere().profil)
    this.personnelService.search(this.critereRechercheService.getCritere()).subscribe(
      (res: HttpResponse<PersonnelRecord>) => this.setPersonnelRecord(res.body),
      (res: HttpErrorResponse) => this.onError(res.message));
  }
  setPersonnelRecord(data){
   this.personnelRecord.menus=data.menus;
   this.personnelRecord.personnels=data.personnels
  }
  private onError(error) {
    this.jhiAlertService.error(error.message, null, null);
  }
  ongletActif(onglet:string){
    this.personnelService.setDetail(false);
    this.critereRechercheService.setOngletActive(onglet);
   }
   afficheDetail(personnel:Personnel){
    this.personnelService.setPersonnel(personnel)
   
  }
  getCritereRechercheService(){
    return this.critereRechercheService

  }
  getPersonnelService(){
    return this.personnelService
  }
  getkeys(myMap:Map<string,string[]>){

   return Array.from(Object.keys(myMap));
  }
  getPersonnelSystemeInf(systemInf:string){
    for( let personnnel of this.personnelRecord.personnels){
      if(personnnel.systemeInf===systemInf){
        return personnnel

      }

    }
  }

}
