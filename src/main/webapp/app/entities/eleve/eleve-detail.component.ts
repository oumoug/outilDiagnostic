import { Component, OnInit } from '@angular/core';
import {CritereRecherche} from '../critereRecherche'
@Component({
  selector: 'jhi-eleve.detail',
  templateUrl: './eleve-detail.component.html',
  styles: []
})
export class EleveDetailComponent implements OnInit {
  critereRecherche:CritereRecherche;
  constructor() { }

  ngOnInit() {
  }

}
