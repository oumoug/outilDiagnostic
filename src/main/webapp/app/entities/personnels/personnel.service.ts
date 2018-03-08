import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import{CritereRecherche} from "../critereRecherche"
import { SERVER_API_URL } from '../../app.constants';
import { Observable } from 'rxjs/Observable';
import{Personnel} from "../personnels/personnels.model"
import {createRequestOption } from '../../shared';

@Injectable()
export class PersonnelService {
  private resourceUrl =  SERVER_API_URL + 'api/personnels';
  constructor(private http: HttpClient) { }
  
  search(critere:CritereRecherche):Observable<HttpResponse<Personnel[]>>{
    const copy = this.convert(critere);
    if(critere.profil==="personnel"){
      const options = createRequestOption(critere);
     return this.http.post<Personnel[]>(this.resourceUrl,copy,{ observe: 'response' })
     .map((res:HttpResponse<Personnel[]>) => this.convertArrayResponse(res));
    }
  }
 
  private convert(critere:CritereRecherche): CritereRecherche {
    const copy: CritereRecherche = Object.assign({}, critere);
    return copy;
  }
  private convertItemFromServer(personnel: Personnel): Personnel {
    const copy:Personnel = Object.assign({}, personnel);
    return copy;
  }
  private convertArrayResponse(res: HttpResponse<Personnel[]>): HttpResponse<Personnel[]> {
    const jsonResponse: Personnel[] = res.body;
    const body: Personnel[] = [];
    for (let i = 0; i < jsonResponse.length; i++) {
        body.push(this.convertItemFromServer(jsonResponse[i]));
    }
    return res.clone({body});
  }
}
