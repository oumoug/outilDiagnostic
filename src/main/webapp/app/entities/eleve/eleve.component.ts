import { Component, OnInit } from '@angular/core';
import { ActivatedRoute,Router} from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import {CritereRecherche,CritereRechercheService} from '../critereRecherche/'
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
  eleves:Eleve[]
  constructor(private router: Router,private eleveService:EleveService,
    private jhiAlertService:JhiAlertService,
    private activatedRoute:ActivatedRoute,private critereRechercheService:CritereRechercheService ) {
    this.eleves=[]
   }

  ngOnInit() {
    this.critereRechercheService.loadProfil(  this.critereRechercheService.getCritere().profil)
    this.eleveService.search(this.critereRechercheService.getCritere()).subscribe(
      (res: HttpResponse<Eleve[]>) => this.setEleves(res.body),
      (res: HttpErrorResponse) => this.onError(res.message));
  }
  setEleves(data){
    for (let i = 0; i < data.length; i++) {
      this.eleves.push(data[i]);
    }

  }
  afficheDetail(eleve:Eleve,siDetail:string){
    this.eleveService.setEleve(eleve);
    this.router.navigate(["eleveDetail"],{ queryParams:{'siDetail':siDetail} , skipLocationChange: true });
  }
  ongletActif(onglet:string){
    this.critereRechercheService.setOngletActive(onglet);
   }
  private onError(error) {
    this.jhiAlertService.error(error.message, null, null);
  }

}
