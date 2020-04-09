export class AddMagazineUsersModel {
  id: number;
  reviewersIds: number[];
  editorsIds: number[];

  constructor() {
    this.id = null;
    this.reviewersIds = [];
    this.editorsIds = [];
  }
}
