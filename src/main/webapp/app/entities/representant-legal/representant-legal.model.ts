import {Enfant} from "./enfant.model"
export interface RepresentantLegal{
    nomSiecle:string
    prenomSiecle:string
    etablissementSiecle:string
    identifiantEnfantSiecle:Enfant[]
    dateSortieSiecle:string
    nomAaf:string
    prenomAaf:string
    identifiantAaf:string
    etablissementAaf:string
    nomAten:string
    prenomAten:string
    identifiantAten:string
    mailAten:string
    etatcompteAten:string
    lastConAten:string
    identifiantEnfantAten:Enfant[]
    nomToutatice:string
    prenomToutatice:string
    identifiantToutatice:string
    mailToutatice:string
    etatCompteToutatice:string
    lastConToutatice:string
    identifiantEnfantToutatice:Enfant[]
    nomEduconnect:string
    prenomEduconnect:string
    identifiantEduconnect:string
    mailEduconnect:string
    etatCompteEduconnect:string
    lastConEduconnect:string
    identifiantEnfantEduconnect:Enfant[]

}