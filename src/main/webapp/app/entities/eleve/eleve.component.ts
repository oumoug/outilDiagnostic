import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Subscription } from 'rxjs/Subscription';
import {CritereRecherche} from '../critereRecherche/'
@Component({
  selector: 'jhi-eleve',
  templateUrl: './eleve.component.html',
  styles: []
})
export class EleveComponent implements OnInit {
  subscription:Subscription  
  critereRecherche:CritereRecherche
  constructor(private router: ActivatedRoute) {
    this.critereRecherche={nom:"",prenom:"",mail:"",etablissement:"",profil:""}
   }

  ngOnInit() {
    this.subscription=this.router.queryParams.subscribe((params) => {
      this.critereRecherche.nom=params['nom'],
      this.critereRecherche.prenom=params['prenom'],
      this.critereRecherche.mail=params['mail'],
      this.critereRecherche.etablissement=params['etablissement'],
      this.critereRecherche.profil=params['profil']
    });
  }

}
