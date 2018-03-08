import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import{CritereRecherche} from "../critereRecherche"
import { SERVER_API_URL } from '../../app.constants';
import { Observable } from 'rxjs/Observable';
import{RepresentantLegal} from "./representant-legal.model"
import {createRequestOption } from '../../shared';
@Injectable()
export class RepresentantLegalService {
  private resourceUrl =  SERVER_API_URL + 'api/representantLegals';
  constructor(private http: HttpClient) { }
  
  search(critere:CritereRecherche):Observable<HttpResponse<RepresentantLegal[]>>{
    const copy = this.convert(critere);
    if(critere.profil==="representantLegal"){
      const options = createRequestOption(critere);
     return this.http.post<RepresentantLegal[]>(this.resourceUrl,copy,{ observe: 'response' })
     .map((res:HttpResponse<RepresentantLegal[]>) => this.convertArrayResponse(res));
    }
  }
 
  private convert(critere:CritereRecherche): CritereRecherche {
    const copy: CritereRecherche = Object.assign({}, critere);
    return copy;
  }
  private convertItemFromServer(representantLegal: RepresentantLegal): RepresentantLegal {
    const copy:RepresentantLegal = Object.assign({}, representantLegal);
    return copy;
  }
  private convertArrayResponse(res: HttpResponse<RepresentantLegal[]>): HttpResponse<RepresentantLegal[]> {
    const jsonResponse: RepresentantLegal[] = res.body;
    const body: RepresentantLegal[] = [];
    for (let i = 0; i < jsonResponse.length; i++) {
        body.push(this.convertItemFromServer(jsonResponse[i]));
    }
    return res.clone({body});
  }

}
