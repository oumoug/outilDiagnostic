import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { CritereRecherche} from '../critereRecherche';
import { SERVER_API_URL } from '../../app.constants';
import { Observable } from 'rxjs/Observable';
import { Eleve } from '../eleve/eleve.model';
import { EleveRecord } from './';
@Injectable()
export class EleveService {
  private resourceUrl =  SERVER_API_URL + 'api/eleves';
  eleveOnglets: Map<string, Eleve>;
  constructor(private http: HttpClient) { }
  search(critere: CritereRecherche): Observable<HttpResponse<EleveRecord>> {
      return this.http.post<EleveRecord> (this.resourceUrl, critere, {observe: 'response'})
      .map((res: HttpResponse<EleveRecord>) => this.convertResponse(res));
  }
  private convertItemFromServer(eleveRecord: EleveRecord): EleveRecord {
      const copy: EleveRecord = Object.assign({}, eleveRecord);
      return copy;
  }
  private convertResponse(res: HttpResponse<EleveRecord>): HttpResponse<EleveRecord> {
    const body: EleveRecord = this.convertItemFromServer(res.body);
    return res.clone({body});
  }
  setEleveOnglet(key: string, eleve: Eleve) {
    this.eleveOnglets[key] = eleve;
  }
  getEleveOnglet(key: string) {
    return this.eleveOnglets[key];
  }
}
