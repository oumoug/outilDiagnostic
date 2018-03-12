import { Component, OnInit} from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import {CritereRechercheService} from '../critereRecherche/';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import {CritereRechercheModule } from "../critereRecherche/critere-recherche.module"
import {JhiAlertService } from 'ng-jhipster';
import{Personnel} from "./personnels.model"
import {PersonnelService} from "./personnel.service"
@Component({
  selector: 'jhi-personnels',
  templateUrl: './personnels.component.html',
  styles: []
})
export class PersonnelsComponent implements OnInit {
  subscription:Subscription  
  personnels:Personnel[]
  
  constructor(private activatedRoute: ActivatedRoute,
    private personnelService:PersonnelService,
    private jhiAlertService:JhiAlertService,
    private critereRechercheService:CritereRechercheService ,
    private router:Router ) {
    this.personnels=[]
   }

  ngOnInit() {
    this.critereRechercheService.loadProfil(  this.critereRechercheService.getCritere().profil)
    this.personnelService.search(this.critereRechercheService.getCritere()).subscribe(
      (res: HttpResponse<Personnel[]>) => this.setPersonnels(res.body),
      (res: HttpErrorResponse) => this.onError(res.message));
  }
  setPersonnels(data){
    for (let i = 0; i < data.length; i++) {
      this.personnels.push(data[i]);
    }
  }
  private onError(error) {
    this.jhiAlertService.error(error.message, null, null);
  }
  ongletActif(onglet:string){
    this.critereRechercheService.setOngletActive(onglet);
   }
   afficheDetail(personnel:Personnel,siDetail:string){
    this.personnelService.setPersonnel(personnel)
    this.router.navigate(["personnelDetail"],{ queryParams:{'siDetail':siDetail} , skipLocationChange: true });
  }

}
