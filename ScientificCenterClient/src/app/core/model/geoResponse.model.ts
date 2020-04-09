import {UserDataModel} from './userData-model';
import {ResultDataUserModel} from './resultDataUser.model';

export class GeoResponseModel {
  userListDTO: UserDataModel;
  resultDataUsers: ResultDataUserModel[];
  constructor() {
    this.userListDTO = new UserDataModel();
    this.resultDataUsers = [];
  }
}
