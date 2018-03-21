import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { CritereRechercheModule } from './critereRecherche/critere-recherche.module';
import { EleveComponent } from './eleve/eleve.component';
import { PersonnelsComponent } from './personnels/personnels.component';
import { RepresentantLegalComponent } from './representant-legal/representant-legal.component';
import {EleveModule } from './eleve/eleve.module'
import { PersonnelsModule} from './personnels/personnels.module'
import {RepresantantLegalModule} from './representant-legal/represantant-legal.module'

/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        CritereRechercheModule,
        EleveModule,
        PersonnelsModule,
        RepresantantLegalModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class OutilDiagnosticEntityModule {}
