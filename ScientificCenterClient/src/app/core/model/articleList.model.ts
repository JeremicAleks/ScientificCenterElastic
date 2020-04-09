import {ArticleModel} from './article.model';

export class ArticleListModel {
  articleDTOS: ArticleModel[];
  constructor(){
    this.articleDTOS = [];
  }
}
