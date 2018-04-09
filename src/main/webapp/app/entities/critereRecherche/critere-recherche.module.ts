import { NgModule } from '@angular/core';
import { OutilDiagnosticSharedModule } from '../../shared';
import { CritereRechercheComponent, CritereRechercheService } from './';
@NgModule({
  imports: [
    OutilDiagnosticSharedModule
  ],
  declarations: [
    CritereRechercheComponent,
  ],
  providers: [
    CritereRechercheService
  ],
  exports: [ CritereRechercheComponent ],
})
export class CritereRechercheModule { }
