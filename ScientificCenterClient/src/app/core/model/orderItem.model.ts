import {MagazineModel} from './magazine.model';
import {ArticleModel} from './article.model';

export class OrderItemModel {

  article: ArticleModel;
  magazine: MagazineModel;
  quantity: number;
  amount: number;

  constructor() {
    this.article = new ArticleModel();
    this.magazine = new MagazineModel();
    this.quantity = 1;
    this.amount = 0;
  }

}
