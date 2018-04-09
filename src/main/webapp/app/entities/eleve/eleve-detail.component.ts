import { Component, OnInit } from '@angular/core';
import { CritereRechercheService, RechercheDetail } from '../critereRecherche';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { Eleve } from '.';
@Component({
  selector: 'jhi-eleve.detail',
  templateUrl: './eleve-detail.component.html',
  styles: []
})
export class EleveDetailComponent implements OnInit {
  subscription: Subscription;
  rechercheDetail: RechercheDetail;
  eleve: Eleve;
  siDetail: string;
  constructor(private activatedRoute: ActivatedRoute,
    private router: Router,
    private critereRechercheService: CritereRechercheService) { }
  ngOnInit() {
   this.subscription = this.activatedRoute.queryParams.subscribe((params) => {
      if (params['siDetail'] !== undefined) {
        this.siDetail = params['siDetail'];
      }
    });
  }
  previousState() {
    if (this.critereRechercheService.getCritere().profil === 'Élève') {
      this.critereRechercheService.getCritere().profil = 'eleve';
    }
    this.router.navigate([this.critereRechercheService.getCritere().profil], {skipLocationChange: true });
  }
}
