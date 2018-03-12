import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import{CritereRecherche,RechercheDetail} from "../critereRecherche"
import { SERVER_API_URL } from '../../app.constants';
import { Observable } from 'rxjs/Observable';
import{Eleve} from "../eleve/eleve.model"

import { createRequestOption } from '../../shared';

@Injectable()
export class EleveService {
  private resourceUrl =  SERVER_API_URL + 'api/eleves';
  eleve:Eleve
  constructor(private http: HttpClient) { }

  search(critere:CritereRecherche):Observable<HttpResponse<Eleve[]>> {
    const copy = this.convert(critere);
      return this.http.post<Eleve[]>(this.resourceUrl,critere,{ observe: 'response' }) 
      .map((res:HttpResponse<Eleve[]>) => this.convertArrayResponse(res));
  }

  setEleve(eleve:Eleve){
      this.eleve=eleve

  }
  getEleve(){
      return this.eleve
  }
  /*searchDetail(rechercheDetail:RechercheDetail):Observable<HttpResponse<Eleve>> {
    const copy = this.convert(rechercheDetail);
    return this.http.post<Eleve>(this.resourceUrl,rechercheDetail,{ observe: 'response' }) 
    .map((res:HttpResponse<Eleve>) => this.convertItemFromServer(res);
  }*/
  private convertDetail(rechercheDetail:RechercheDetail){
    const copy: RechercheDetail = Object.assign({}, rechercheDetail);
    return copy;
  }
  private convert(critere:CritereRecherche): CritereRecherche {
      const copy: CritereRecherche = Object.assign({}, critere);
      return copy;
  }
  private convertItemFromServer(eleve: Eleve): Eleve {
      const copy: Eleve = Object.assign({}, eleve);
      return copy;
  }
  private convertArrayResponse(res: HttpResponse<Eleve[]>): HttpResponse<Eleve[]> {
      const jsonResponse: Eleve[] = res.body;
      const body: Eleve[] = [];
      for (let i = 0; i < jsonResponse.length; i++) {
          body.push(this.convertItemFromServer(jsonResponse[i]));
      }
      return res.clone({body});
  }
}
