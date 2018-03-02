import { NgModule } from '@angular/core';
import { RepresentantLegalDetailComponent,RepresentantLegalComponent,representantLegalRoute} from './';
import {OutilDiagnosticSharedModule} from "../../shared"
import {RouterModule} from '@angular/router';
import {CritereRechercheModule } from "../critereRecherche/critere-recherche.module"
const ENTITY_STATES = [
  ...representantLegalRoute
  
];



@NgModule({
  imports: [
    OutilDiagnosticSharedModule,
    RouterModule.forChild(ENTITY_STATES),
    CritereRechercheModule 
  ],
  declarations: [RepresentantLegalDetailComponent,RepresentantLegalComponent]
})
export class RepresantantLegalModule { }
