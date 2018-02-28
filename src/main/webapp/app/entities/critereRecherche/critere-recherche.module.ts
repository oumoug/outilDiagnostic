import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {OutilDiagnosticSharedModule} from "../../shared"
import { CritereRechercheComponent} from "./"

@NgModule({
  imports: [
    CommonModule,
    OutilDiagnosticSharedModule
    
  ],
  declarations: [
    CritereRechercheComponent,
    
  ],
  entryComponents: [
    CritereRechercheComponent,
    
  ]
})
export class CritereRechercheModule { }
