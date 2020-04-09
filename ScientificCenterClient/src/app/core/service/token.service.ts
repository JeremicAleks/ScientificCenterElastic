import { Injectable } from '@angular/core';

const TOKEN = 'token';

@Injectable({
  providedIn: 'root'
})
export class TokenService {

  constructor() { }

  getToken(): string {
    return window.localStorage[TOKEN];
  }

  saveToken(token: string) {
    window.localStorage[TOKEN] = token;
  }

  destroyToken() {
    window.localStorage.removeItem(TOKEN);
  }

}
