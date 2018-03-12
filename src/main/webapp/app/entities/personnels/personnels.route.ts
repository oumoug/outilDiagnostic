import { Routes } from '@angular/router';
import {PersonnelsDetailComponent} from  "./personnels-detail.component"
import {PersonnelsComponent} from "./personnels.component"

 

export const personnelsRoute: Routes = [
    {
        path: 'personnel',
        component: PersonnelsComponent,
       
        data: {},
    },
    {

        path: 'personnelDetail',
        component: PersonnelsDetailComponent,
       
        data: {},

    }
]