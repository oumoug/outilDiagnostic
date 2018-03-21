import { Route } from '@angular/router';

import { HomeComponent } from './';
import {CritereRechercheComponent} from '../entities/critereRecherche/critere-recherche.component'

export const HOME_ROUTE: Route = {
    path: '',
    component: CritereRechercheComponent,
    data: {
        authorities: [],
        pageTitle: 'home.title'
    }
};
