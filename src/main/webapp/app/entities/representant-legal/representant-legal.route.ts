import { Routes } from '@angular/router';
import {RepresentantLegalComponent } from  "./representant-legal.component"
import {RepresentantLegalDetailComponent} from "./representant-legal-detail.component"
 

export const representantLegalRoute: Routes = [
    {
        path: 'representantLegal',
        component: RepresentantLegalComponent ,
       
        data: {},
    },
    {
        path: 'representantLegalDetail',
        component: RepresentantLegalDetailComponent ,
       
        data: {},
    }
]