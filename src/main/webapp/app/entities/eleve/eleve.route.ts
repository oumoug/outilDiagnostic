import { Routes } from '@angular/router';
import {EleveComponent } from './eleve.component'
import {EleveDetailComponent } from './eleve-detail.component'
import {CritereRechercheComponent} from '../critereRecherche/critere-recherche.component'

export const eleveRoute: Routes = [
    {
        path: 'eleve',
        component: EleveComponent,
       
        data: {},
    },
    {
        path: 'eleveDetail',
        component: EleveDetailComponent,
        data: {
           
        },
    }
];
