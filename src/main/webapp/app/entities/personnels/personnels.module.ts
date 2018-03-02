import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';
import { PersonnelsDetailComponent,PersonnelsComponent, personnelsRoute } from './';
import {CritereRechercheModule } from "../critereRecherche/critere-recherche.module"
import {OutilDiagnosticSharedModule} from "../../shared"

const ENTITY_STATES = [
  ...personnelsRoute
  
];

@NgModule({
  imports: [
    OutilDiagnosticSharedModule,
    RouterModule.forChild(ENTITY_STATES),
    CritereRechercheModule 
  ],
  declarations: [PersonnelsDetailComponent,PersonnelsComponent]
})
export class PersonnelsModule { }
