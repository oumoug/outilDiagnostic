import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import {CritereRecherche,RechercheDetail} from "../critereRecherche"
import { SERVER_API_URL } from '../../app.constants';
import { Observable } from 'rxjs/Observable';
import {Eleve} from '../eleve/eleve.model'
import {EleveRecord} from './'


import { createRequestOption } from '../../shared';

@Injectable()
export class EleveService {
  private resourceUrl =  SERVER_API_URL + 'api/eleves';
  eleveOnglets:Map<string,Eleve>
  constructor(private http: HttpClient) { }

  search(critere:CritereRecherche):Observable<HttpResponse<EleveRecord>> {
    const copy = this.convert(critere);
      return this.http.post<EleveRecord>(this.resourceUrl,critere,{ observe: 'response' }) 
      .map((res:HttpResponse<EleveRecord>) => this.convertResponse(res));
  }
  private convertDetail(rechercheDetail:RechercheDetail){
    const copy: RechercheDetail = Object.assign({}, rechercheDetail);
    return copy;
  }
  private convert(critere:CritereRecherche): CritereRecherche {
      const copy: CritereRecherche = Object.assign({}, critere);
      return copy;
  }
  private convertItemFromServer(eleveRecord:EleveRecord):EleveRecord{
      const copy: EleveRecord = Object.assign({}, eleveRecord);
      return copy;
  }
  private convertResponse(res:HttpResponse<EleveRecord>):HttpResponse<EleveRecord> {
    const body: EleveRecord= this.convertItemFromServer(res.body);
    return res.clone({body});
  }
  setEleveOnglet(key:string,eleve:Eleve){
    this.eleveOnglets[key]=eleve
  }
  getEleveOnglet(key:string){
    return this.eleveOnglets[key];
  }
 
}
