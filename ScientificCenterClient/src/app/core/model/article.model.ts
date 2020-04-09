import {ScientificAreaModel} from './scientificArea.model';
import {MagazineModel} from './magazine.model';
import {UserModel} from './user-model';

export class ArticleModel {
  id: number;
  title: string;
  keywords: string;
  articleAbstract: string;
  fileLocation: string;
  scientificArea: ScientificAreaModel;
  magazine: MagazineModel;
  author: UserModel;
  active: boolean;
  reviewers: UserModel[];

  constructor(){
    this.id = null;
    this.title = '';
    this.keywords = '';
    this.articleAbstract = '';
    this.fileLocation = '';
    this.scientificArea = new ScientificAreaModel();
    this.magazine = new MagazineModel();
    this.author = new UserModel();
    this.active = false;
    this.reviewers = [];
  }


}
