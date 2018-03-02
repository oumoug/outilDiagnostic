import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {OutilDiagnosticSharedModule} from "../../shared"
import { CritereRechercheComponent,CritereRechercheService} from "./"
@NgModule({
  imports: [
    CommonModule,
    OutilDiagnosticSharedModule
    
  ],
  declarations: [
    CritereRechercheComponent,
    
  ],
  providers:[
    CritereRechercheService

  ],
  exports:[ CritereRechercheComponent ],
})
export class CritereRechercheModule { }
