import { Injectable } from '@angular/core';
import {MagazineModel} from '../model/magazine.model';
import {HttpClient} from '@angular/common/http';
import {AddMagazineDataModel} from '../model/addMagazineData.model';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {AddMagazineUsersModel} from '../model/addMagazineUsers.model';
import {EditMagazineModel} from '../model/editMagazine.model';

const MAGAZINEDATA = 'magazinedata';

@Injectable({
  providedIn: 'root'
})
export class MagazineService {

  magazine: MagazineModel = new MagazineModel();

  constructor(private http: HttpClient) { }

  public addMagaizneData(data: AddMagazineDataModel): Observable<any> {
    return this.http.post(environment.url + 'api/magazine', data);
  }
  public addMagazineUsers(data: AddMagazineUsersModel): Observable<any> {
    return this.http.post(environment.url + 'api/magazine/addUsers', data);
  }
  getMagazines(): Observable<any> {
    return this.http.get(environment.url + 'api/magazine');
  }
  // editMagazine(data: EditMagazineModel): Observable<any> {
  //   return this.http.put(environment.url + 'api/magazine/dopunaCasopisa', data);
  // }
  // getMagazinesOfLeadEditor(username: string): Observable<any> {
  //   return this.http.get(environment.url + 'api/magazine/byLeadEditor/' + username);
  // }

  // updateMagazien(data: MagazineModel): Observable<any> {
  //   return this.http.post(environment.url + 'api/magazine/update', data);
  // }
  // magazineIsOk(data: EditMagazineModel): Observable<any> {
  //   return this.http.put(environment.url + 'api/magazine/ureduCasopis', data);
  // }

  getMagazineForAdd(): MagazineModel {
    this.magazine = new MagazineModel();
    if (window.localStorage[MAGAZINEDATA]) {
      this.magazine = JSON.parse(window.localStorage[MAGAZINEDATA]);
    }
    return this.magazine;
  }
  saveMagazineForAdd(model: MagazineModel) {
    window.localStorage.removeItem(MAGAZINEDATA);
    window.localStorage.setItem(MAGAZINEDATA, JSON.stringify(model));
  }
  destroyMagazineForAdd() {
    window.localStorage.removeItem(MAGAZINEDATA);
  }

}
