export class AddMagazineDataModel {
  name: string;
  iSSN: string;
  magazineType: string;
  leadEditorUsername: string;
  scientificAreaIds: number[];
  price: number;
  activeStatus: boolean;
  constructor() {
    this.name = '';
    this.iSSN = '';
    this.magazineType = '';
    this.leadEditorUsername = '';
    this.scientificAreaIds = [];
    this.price = null;
    this.activeStatus = false;
  }
}
