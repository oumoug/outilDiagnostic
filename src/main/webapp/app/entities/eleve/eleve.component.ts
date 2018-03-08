import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import {CritereRecherche} from '../critereRecherche/'
import {EleveService} from "./eleve.service"
import {Eleve} from "./eleve.model"
import {JhiAlertService } from 'ng-jhipster';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
@Component({
  selector: 'jhi-eleve',
  templateUrl: './eleve.component.html',
  styles: []
})
export class EleveComponent implements OnInit {
  subscription:Subscription  
  critereRecherche:CritereRecherche
  ongletActive:string
  eleves:Eleve[]
  constructor(private router: ActivatedRoute,private eleveService:EleveService,private jhiAlertService:JhiAlertService ) {
    this.critereRecherche={nom:"",prenom:"",mail:"",etablissement:"",profil:""}
    this.ongletActive="resume"
    this.eleves=[]
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
    this.eleveService.search(this.critereRecherche).subscribe(
      (res: HttpResponse<Eleve[]>) => this.setEleves(res.body),
      (res: HttpErrorResponse) => this.onError(res.message));
  }
  setEleves(data){
    for (let i = 0; i < data.length; i++) {
      this.eleves.push(data[i]);
    }

  }
  private onError(error) {
    this.jhiAlertService.error(error.message, null, null);
  }

}
