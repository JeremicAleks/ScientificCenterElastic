import {UserModel} from './user-model';

export class UserDataModel {
  users: UserModel[];
  constructor() {
    this.users = [];
  }
}
