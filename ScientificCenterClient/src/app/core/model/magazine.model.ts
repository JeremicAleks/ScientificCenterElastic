import {UserModel} from './user-model';
import {ScientificAreaModel} from './scientificArea.model';

export class MagazineModel {
  magazineId: number;
  name: string;
  iSSN: string;
  magazineType: string;
  leadEditor: UserModel;
  editors: UserModel[];
  reviewers: UserModel[];
  scientificAreas: ScientificAreaModel[];
  price: number;
  activeStatus: boolean;
  needEdit: boolean;

  constructor() {
    this.magazineId = null;
    this.name = '';
    this.iSSN = '';
    this.magazineType = '';
    this.leadEditor = new UserModel();
    this.editors = [];
    this.reviewers = [];
    this.scientificAreas = [];
    this.price = null;
    this.activeStatus = false;
    this.needEdit = false;
  }
}
