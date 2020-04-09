import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {ActivateReviewerModel} from '../model/activateReviewer.model';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getAllUsers(): Observable<any> {
    return this.http.get(environment.url + 'api/user');
  }

  getUser(id: number): Observable<any> {
    return this.http.get(environment.url + 'api/user/' + id);
  }

  getUserByUsername(username: string): Observable<any>{
    return this.http.get(environment.url + 'api/user/username/' + username);
  }

  getUsersByRole(role: string): Observable<any> {
    return this.http.get(environment.url + 'api/user/role/' + role);
  }
  getUserByRoleAndScientificArea(role: string, naucnaOblast: string): Observable<any> {
    return this.http.get(environment.url + 'api/user/role/'.concat(role).concat('/').concat(naucnaOblast));
  }

  activateRecenzent(data: ActivateReviewerModel): Observable<any> {
    return this.http.put(environment.url + 'api/user/activateRecenzent', data);
  }
}
