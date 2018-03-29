import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import {CritereRecherche} from '../critereRecherche'
import { SERVER_API_URL } from '../../app.constants';
import { Observable } from 'rxjs/Observable';
import {Personnel} from '../personnels/personnels.model'
import {PersonnelRecord} from '.'
import {createRequestOption } from '../../shared';

@Injectable()
export class PersonnelService {
  private resourceUrl =  SERVER_API_URL + 'api/personnels';
  personnel:Personnel
  detail:Boolean
  constructor(private http: HttpClient) {
    this.detail=false
   }
  
  search(critere:CritereRecherche):Observable<HttpResponse<PersonnelRecord>>{
    const copy = this.convert(critere);
    return this.http.post<PersonnelRecord>(this.resourceUrl,copy,{ observe: 'response' })
     .map((res:HttpResponse<PersonnelRecord>) => this.convertResponse(res))
  }
  setDetail(detail:Boolean){
    this.detail=detail
  }
  getDetail(){
    return this.detail
  }
  setPersonnel(personnel:Personnel){
    this.personnel=personnel;

  }
  getPersonnel(){
    return this.personnel
  }
  private convert(critere:CritereRecherche): CritereRecherche {
    const copy: CritereRecherche = Object.assign({}, critere);
    return copy;
  }
  private convertItemFromServer(personnelRecord: PersonnelRecord): PersonnelRecord {
    const copy: PersonnelRecord = Object.assign({},personnelRecord);
    return copy;
}
private convertResponse(res:HttpResponse<PersonnelRecord>):HttpResponse<PersonnelRecord> {
  const body: PersonnelRecord = this.convertItemFromServer(res.body);
  return res.clone({body});
}
  /*private convertArrayResponse(res: HttpResponse<PersonnelRecord>): HttpResponse<Personnel[]> {
    const jsonResponse: Personnel[] = res.body;
    const body: Personnel[] = [];
    for (let i = 0; i < jsonResponse.length; i++) {
        body.push(this.convertItemFromServer(jsonResponse[i]));
    }
    return res.clone({body});
  }*/
}
