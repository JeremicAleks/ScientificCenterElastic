import {GeoPointModel} from './geoPoint.model';

export class ResultDataUserModel {
  username: string;
  firstname: string;
  surname: string;
  locationName: string;
  lokacija: string;
  userId: string;
  userRole: string;
  // tslint:disable-next-line:variable-name
  geo_point: GeoPointModel;

  constructor() {
    this.username = '';
    this.firstname = '';
    this.surname = '';
    this.locationName = '';
    this.lokacija = '';
    this.userId = '';
    this.userRole = '';
    this.geo_point = new GeoPointModel();;
  }
}
