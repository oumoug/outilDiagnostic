import { Component, OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import {CritereRecherche} from '../critereRecherche/';
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
  critereRecherche:CritereRecherche
  personnels:Personnel[]
  ongletActive:string
  
  constructor(private activatedRoute: ActivatedRoute,private personnelService:PersonnelService, private jhiAlertService:JhiAlertService ) {
    this.critereRecherche={nom:"",prenom:"",mail:"",etablissement:"",profil:""}
    this.ongletActive="resume";
    this.personnels=[]
   }

  ngOnInit() {
      this.subscription=this.activatedRoute.queryParams.subscribe((params) => {
      this.critereRecherche.nom=params['nom'],
      this.critereRecherche.prenom=params['prenom'],
      this.critereRecherche.mail=params['mail'],
      this.critereRecherche.etablissement=params['etablissement'],
      this.critereRecherche.profil=params['profil']
      if(params['ongletActive']!=undefined){this.ongletActive=params['ongletActive']}
    });
    this.personnelService.search(this.critereRecherche).subscribe(
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

}
