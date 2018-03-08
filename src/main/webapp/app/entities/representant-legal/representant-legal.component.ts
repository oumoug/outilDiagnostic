import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import {CritereRecherche} from '../critereRecherche/'
import {RepresentantLegal} from "./representant-legal.model"
import {RepresentantLegalService} from "./representant-legal.service"
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import {JhiAlertService } from 'ng-jhipster';
@Component({
  selector: 'jhi-representant-legal',
  templateUrl: './representant-legal.component.html',
  styles: []
})
export class RepresentantLegalComponent implements OnInit {
  subscription:Subscription  
  critereRecherche:CritereRecherche
  ongletActive:string
  representantLegals:RepresentantLegal[]
  constructor(private router: ActivatedRoute,private representantLegalService:RepresentantLegalService,private jhiAlertService:JhiAlertService) { 
    this.critereRecherche={nom:"",prenom:"",mail:"",etablissement:"",profil:""}
    this.ongletActive="resume";
    this.representantLegals=[]
  }

  ngOnInit() {
    this.subscription=this.router.queryParams.subscribe((params) => {
      this.critereRecherche.nom=params['nom'],
      this.critereRecherche.prenom=params['prenom'],
      this.critereRecherche.mail=params['mail'],
      this.critereRecherche.etablissement=params['etablissement'],
      this.critereRecherche.profil=params['profil']
      if(params['ongletActive']!=undefined){this.ongletActive=params['ongletActive']}
    });
   this.representantLegalService.search(this.critereRecherche).subscribe(
      (res: HttpResponse<RepresentantLegal[]>) => this.setRepresentantLegals(res.body),
      (res: HttpErrorResponse) => this.onError(res.message));
  }

  setRepresentantLegals(data){
    for (let i = 0; i < data.length; i++) {
      this.representantLegals.push(data[i]);
    }
  }
  private onError(error) {
    this.jhiAlertService.error(error.message, null, null);
  }


}
