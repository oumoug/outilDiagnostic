import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import{CritereRecherche} from "./CritereRecherche.model"
import { SERVER_API_URL } from '../../app.constants';
import { Observable } from 'rxjs/Observable';
import{Eleve} from "../eleve/eleve.model"
import{Personnel} from "../personnels/personnels.model"
import { createRequestOption } from '../../shared';

@Injectable()
export class CritereRechercheService {
  private resourceUrl =  SERVER_API_URL + 'api/critereRecherche';
  constructor(private http: HttpClient) { }
  
}
