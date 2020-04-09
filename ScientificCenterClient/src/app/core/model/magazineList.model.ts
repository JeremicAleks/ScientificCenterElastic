import {MagazineModel} from './magazine.model';

export class MagazineListModel {
  magazines: MagazineModel[];
  constructor() {
    this.magazines = [];
  }
}
