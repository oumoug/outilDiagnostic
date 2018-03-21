import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import {CritereRechercheService} from '../critereRecherche/'
import {RepresentantLegal} from './representant-legal.model'
import {RepresentantLegalService} from './representant-legal.service'
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import {JhiAlertService } from 'ng-jhipster';
import {Enfant} from '.'
@Component({
  selector: 'jhi-representant-legal',
  templateUrl: './representant-legal.component.html',
  styles: []
})
export class RepresentantLegalComponent implements OnInit {
  subscription:Subscription  
  
  representantLegals:RepresentantLegal[]
  constructor(
    private router:Router ,
    private representantLegalService:RepresentantLegalService,
    private jhiAlertService:JhiAlertService,
    private critereRechercheService:CritereRechercheService ) { 
    this.representantLegals=[]
  }

  ngOnInit() {
    this.critereRechercheService.loadProfil(  this.critereRechercheService.getCritere().profil)
   this.representantLegalService.search(this.critereRechercheService.getCritere()).subscribe(
      (res: HttpResponse<RepresentantLegal[]>) => this.setRepresentantLegals(res.body),
      (res: HttpErrorResponse) => this.onError(res.message));
      
  }
  ongletActif(onglet:string){
    this.critereRechercheService.setOngletActive(onglet);
   }

  setRepresentantLegals(data){
    for (let i = 0; i < data.length; i++) {
      this.representantLegals.push(data[i]);
    }
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
  afficheDetail(representantLegal:RepresentantLegal,siDetail:string){
    this.representantLegalService.setRepresentantLegal(representantLegal)
    this.router.navigate(['representantLegalDetail'],{ queryParams:{'siDetail':siDetail} , skipLocationChange: true });
  }
  getCritereRechercheService(){
    return this.critereRechercheService

  }
  

}
