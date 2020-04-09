export class  RegistrationModel {
  firstname: string;
  surname: string;
  city: string;
  country: string;
  title: string;
  email: string;
  username: string;
  password: string;
  reviewerCheck?: boolean;
  active: boolean;
  scientificAreasIds: number[];

  constructor() {
    this.firstname = '';
    this.surname = '' ;
    this.city = '';
    this.country = '';
    this.title = '';
    this.email = '';
    this.username = '';
    this.password = '';
    this.reviewerCheck = false;
    this.active = false;
    this.scientificAreasIds = [];
  }
}
