import {UserDataModel} from './userData-model';
import {ResultDataModel} from './resultData.model';

export class MoreLikeThisModel {
  reviewers: UserDataModel;
  bookTitle: string[];
  resultData: ResultDataModel[];
  constructor() {
    this.bookTitle = [];
    this.reviewers = new UserDataModel();
    this.resultData = [];
  }
}
