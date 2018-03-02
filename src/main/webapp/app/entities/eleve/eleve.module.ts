import { NgModule } from '@angular/core';
import {RouterModule} from '@angular/router';
import {EleveComponent, EleveDetailComponent,eleveRoute,EleveService} from "./"
import {CritereRechercheModule } from "../critereRecherche/critere-recherche.module"
import {OutilDiagnosticSharedModule} from "../../shared"

const ENTITY_STATES = [
  ...eleveRoute
  
];

@NgModule({
  imports: [
    OutilDiagnosticSharedModule,
    RouterModule.forChild(ENTITY_STATES),
    CritereRechercheModule 
   
  
    
  ],
  providers: [
    EleveService
  ],
  declarations: [EleveDetailComponent,EleveComponent]
})
export class EleveModule { }
