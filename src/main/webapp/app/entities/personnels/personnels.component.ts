import { Component, OnInit} from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import {CritereRecherche} from '../critereRecherche/'
import {CritereRechercheModule } from "../critereRecherche/critere-recherche.module"
@Component({
  selector: 'jhi-personnels',
  templateUrl: './personnels.component.html',
  styles: []
})
export class PersonnelsComponent implements OnInit {
  subscription:Subscription  
  critereRecherche:CritereRecherche
  
  constructor(private activatedRoute: ActivatedRoute ) {
    this.critereRecherche={nom:"",prenom:"",mail:"",etablissement:"",profil:""}
   }

  ngOnInit() {
      this.subscription=this.activatedRoute.queryParams.subscribe((params) => {
      this.critereRecherche.nom=params['nom'],
      this.critereRecherche.prenom=params['prenom'],
      this.critereRecherche.mail=params['mail'],
      this.critereRecherche.etablissement=params['etablissement'],
      this.critereRecherche.profil=params['profil']
    });
  }

}
