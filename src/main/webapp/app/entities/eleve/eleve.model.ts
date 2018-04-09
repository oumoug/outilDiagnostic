import { Parent } from '.';
export interface Eleve {
    systemeInf: string;
    eleveResume: Map<String, String[]>;
    eleveDetaille: Map<String, String[]>;
    representant: Parent[];
}
