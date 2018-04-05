import { Routes } from '@angular/router';
import {EleveComponent } from './eleve.component'
import {EleveDetailComponent } from './eleve-detail.component'
import {CritereRechercheComponent} from '../critereRecherche/critere-recherche.component'
import {RepresentantLegalComponent } from  '../representant-legal'

export const eleveRoute: Routes = [
    {
        path: 'eleve',
        component: EleveComponent,
       
        data: {},
    },
    
];
