import { Routes } from '@angular/router';
import { CritereRechercheComponent } from '../entities/critereRecherche/critere-recherche.component';
export const HOME_ROUTE: Routes = [
   {
        path: '',
        component: CritereRechercheComponent,
        data: {
            authorities: [],
            pageTitle: 'home.title'
        }
    }
];
