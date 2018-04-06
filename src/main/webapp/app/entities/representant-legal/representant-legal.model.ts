import {Enfant} from './enfant.model'
export interface Responsable{
        systemeInf: string;
        responsableResume: Map<String,String[]>  ;
        responsableDetaille: Map<String,String[]>;
        enfants:Enfant[];
    
    

}