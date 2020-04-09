import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ScientificAreaService {

  constructor(private http: HttpClient) { }

  public getAllScientificAreas(): Observable<any> {
    return this.http.get(environment.url + 'api/scientificArea');
  }

  getUserForScientificAreas(id: number, role: string): Observable<any> {
    return this.http.get(environment.url + 'api/scientificArea/' + id + '/' + role);
  }
}
