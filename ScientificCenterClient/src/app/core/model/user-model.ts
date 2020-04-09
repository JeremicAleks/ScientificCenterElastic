import {ScientificAreaModel} from './scientificArea.model';

export class UserModel{
  userId: number;
  firstname: string;
  surname: string;
  city: string;
  country: string;
  title: string;
  email: string;
  username: string;
  password: string;
  recenzentCheck: boolean;
  aktivan: boolean;
  izabraneNaucneOblasti: ScientificAreaModel[];

  constructor() {
    this.userId = null;
    this.firstname = '';
    this.surname = '';
    this.city = '';
    this.country = '';
    this.title = '';
    this.email = '';
    this.username = '';
    this.password = '';
    this.recenzentCheck = false;
    this.aktivan = false;
    this.izabraneNaucneOblasti = [];
  }
}
