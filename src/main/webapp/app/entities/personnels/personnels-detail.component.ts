import { Component, OnInit } from '@angular/core';
import { PersonnelService } from './personnel.service';
import { CritereRechercheService } from '../critereRecherche';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
@Component({
  selector: 'jhi-personnels-detail',
  templateUrl: './personnels-detail.component.html',
  styles: []
})
export class PersonnelsDetailComponent implements OnInit {
  subscription: Subscription;
  siDetail: string;
  constructor(private critereRechercheService: CritereRechercheService,
              private personnelService: PersonnelService,
              private router: Router,
              private activatedRoute: ActivatedRoute
) { }
  ngOnInit() {
    this.subscription = this.activatedRoute.queryParams.subscribe((params) => {
      if (params['siDetail'] !== undefined) {
        this.siDetail = params['siDetail'];
      }
    });
  }
  previousState() {
    if (this.critereRechercheService.getCritere().profil === 'Personnels') {
      this.critereRechercheService.getCritere().profil = 'personnel';
    }
    this.router.navigate([this.critereRechercheService.getCritere().profil], {skipLocationChange: true });
  }
  getPersonnelService() {
    return this.personnelService;
  }
}
