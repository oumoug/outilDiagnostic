import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import {CritereRecherche} from '../critereRecherche'
import { SERVER_API_URL } from '../../app.constants';
import { Observable } from 'rxjs/Observable';
import {Responsable} from './representant-legal.model'
import {ResponsableRecord} from './'
import {createRequestOption } from '../../shared';
@Injectable()
export class RepresentantLegalService {
  private resourceUrl =  SERVER_API_URL + 'api/representantLegals';
  responsableRecord:ResponsableRecord
  responsableOnglets:Map<string,Responsable>
  constructor(private http: HttpClient) { }
  
  search(critere:CritereRecherche):Observable<HttpResponse<ResponsableRecord>>{
    const copy = this.convert(critere);
     return this.http.post<ResponsableRecord>(this.resourceUrl,copy,{ observe: 'response' })
     .map((res:HttpResponse<ResponsableRecord>) => this. convertResponse(res));
  }
  
  private convert(critere:CritereRecherche): CritereRecherche {
    const copy: CritereRecherche = Object.assign({}, critere);
    return copy;
  }
  private convertItemFromServer(responsableRecord: ResponsableRecord): ResponsableRecord {
    const copy: ResponsableRecord = Object.assign({},responsableRecord);
    return copy;
  }
  private convertResponse(res:HttpResponse<ResponsableRecord>):HttpResponse<ResponsableRecord> {
    const body: ResponsableRecord = this.convertItemFromServer(res.body);
    return res.clone({body});
  }
  setResponsableOnglet(key:string,responsable:Responsable){
    this.responsableOnglets[key]=responsable
  }
  getResponsableOnglet(key:string){
    return this.responsableOnglets[key];
  }

}
