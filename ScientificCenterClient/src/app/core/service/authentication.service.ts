import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {RegistrationModel} from '../model/registration.model';
import {JwtHelperService} from '@auth0/angular-jwt';
import {AuthToken} from '../model/authToken.model';

const OAUTH2_TOKEN_ENDPOINT = environment.url + 'oauth/token';
const OAUTH2_CLIENT_ID = 'NaucnaCentrala';
const OAUTH2_CLIENT_SECRET = 'secret';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  public isAuthenticated(): boolean {
    if (localStorage.getItem('token')) {
      return true;
    }
    return false;
  }

  public isUser() {
    const helper = new JwtHelperService();
    const decodedToken = helper.decodeToken(localStorage.getItem('token'));

    if (decodedToken != null) {
      if (decodedToken.authorities[0] === 'USER') {
        return true;
      }
    }
    return false;
  }

  public isAdmin() {
    const helper = new JwtHelperService();
    const decodedToken = helper.decodeToken(localStorage.getItem('token'));

    if (decodedToken != null) {
      if (decodedToken.authorities[0] === 'ADMIN') {
        return true;
      }
    }
    return false;
  }



  public isEditor() {
    const helper = new JwtHelperService();
    const decodedToken = helper.decodeToken(localStorage.getItem('token'));
    if (decodedToken != null) {
      for (const entry of decodedToken.authorities) {
        if (entry === 'EDITOR') {
          return true;
        }
      }
    }
    return false;
  }

  public isLeadEditor() {
    const helper = new JwtHelperService();
    const decodedToken = helper.decodeToken(localStorage.getItem('token'));
    if (decodedToken != null) {
      for (const entry of decodedToken.authorities) {
        if (entry === 'LEADEDITOR') {
          return true;
        }
      }
    }
    return false;
  }
  public isAuthor() {
    const helper = new JwtHelperService();
    const decodedToken = helper.decodeToken(localStorage.getItem('token'));
    if (decodedToken != null) {
      for (const entry of decodedToken.authorities) {
        if (entry === 'AUTHOR') {
          return true;
        }
      }
    }
    return false;
  }
  public isReviewer() {
    const helper = new JwtHelperService();
    const decodedToken = helper.decodeToken(localStorage.getItem('token'));
    if (decodedToken != null) {
      for (const entry of decodedToken.authorities) {
        if (entry === 'REVIEWER') {
          return true;
        }
      }
    }
    return false;
  }


  getAccessToken(username: string, password: string): Observable<AuthToken> {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/x-www-form-urlencoded'
      })
    };
    const body = 'client_id={0}&client_secret={1}&grant_type=password&username={2}&password={3}'
      .replace('{0}', OAUTH2_CLIENT_ID)
      .replace('{1}', OAUTH2_CLIENT_SECRET)
      .replace('{2}', username)
      .replace('{3}', password);

    return this.http.post<AuthToken>(OAUTH2_TOKEN_ENDPOINT, body, httpOptions);
  }

  logout(): Observable<any> {
    return this.http.delete(environment.url + 'oauth/token');
  }

  getUsernameFromToken(): string {
    const helper = new JwtHelperService();
    const decodedToken = helper.decodeToken(localStorage.getItem('token'));

    if (decodedToken != null) {
      return decodedToken.user_name;
    }
    return '';
  }


  public registration(data: RegistrationModel): Observable<any> {
    return this.http.post(environment.url + 'api/user/registration/', data);
  }
}
