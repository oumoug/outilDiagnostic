import { Component, OnInit } from '@angular/core';
/*import { ActivatedRoute,Router } from '@angular/router';*/
import { Subscription } from 'rxjs/Subscription';
import { CritereRechercheService } from '../critereRecherche/';
import { ResponsableRecord, Responsable } from '.';
import { RepresentantLegalService } from './representant-legal.service';
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
import { JhiAlertService } from 'ng-jhipster';
import { Enfant } from '.';
@Component({
  selector: 'jhi-representant-legal',
  templateUrl: './representant-legal.component.html',
  styles: []
})
export class RepresentantLegalComponent implements OnInit {
  subscription: Subscription;
  profil: string;
  responsableRecord: ResponsableRecord;
  hover: Boolean;
  constructor(
    /*private router:Router ,*/
    private representantLegalService: RepresentantLegalService,
    private jhiAlertService: JhiAlertService,
    private critereRechercheService: CritereRechercheService,
    /*private activatedRoute: ActivatedRoute*/) {
      this. responsableRecord = {menus: [], responsables: []};
  }
  ngOnInit() {
   this.representantLegalService.search(this.critereRechercheService.getCritere()).subscribe(
      (res: HttpResponse<ResponsableRecord>) => this.setResponsableRecord(res.body),
      (res: HttpErrorResponse) => this.onError(res.message));
      this. critereRechercheService.ongletActive = 'Résumé';
      this.hover = true;
      this.representantLegalService.responsableOnglets = this.initResponsableOnglets(this.responsableRecord.menus);
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
            this.router.navigate([ this.critereRechercheService.getCritere().profil],{skipLocationChange: true });
       }
     }
      )*/
  }
  ongletActif(onglet: string) {
    this.critereRechercheService.setOngletActive(onglet);
  }
  setResponsableRecord(data) {
    this.responsableRecord.menus = data.menus;
    this.responsableRecord.responsables = data.responsables;
  }
  getEnfantSystemInf(menu: string, responsable: Responsable) {
    const enfants = [];
    for (const enfant of responsable.enfants) {
      if (enfant.systemInf === menu) {
        enfants.push(enfant);
      }
    }
    return  enfants;
  }
  searchEnfant(enfant: Enfant) {
  }
  private onError(error) {
    this.jhiAlertService.error(error.message, null, null);
  }
  afficheDetail(responsable: Responsable, menu: string) {
    if (responsable === this.representantLegalService.getResponsableOnglet(menu)) {
      this.representantLegalService.setResponsableOnglet(menu, null);
      this.hover = true;
    }else {
      this.representantLegalService.setResponsableOnglet(menu, responsable);
      this.hover = false;
     }
  }
  initResponsableOnglets(menus: string[]) {
    const responsableOnglets = new Map();
    for (const menu of menus){
      responsableOnglets.set(menu, null);
    }
    return  responsableOnglets;
  }
  getCritereRechercheService() {
    return this.critereRechercheService;
  }
  getkeys(myMap: Map<string, string[]>) {
    return Array.from(Object.keys(myMap));
   }
   getResponsableSystemeInf(systemInf: string) {
     for ( const responsable of this.responsableRecord.responsables) {
       if (responsable.systemeInf === systemInf) {
         return  responsable;
       }
     }
   }
   getRepresentantLegalService() {
     return this.representantLegalService;
   }
}
