export class ResultDataModel {
  text: string;
  title: string;
  keywords: string;
  location: string;
  articleAbstract: string;
  author: string;
  scientificArea: string;
  idArticle: string;
  magazineType: string;
  magazineTitle: string;
  status: string;
  highlight: string;

  constructor() {
    this.text = '';
    this.title = '';
    this.keywords = '';
    this.location = '';
    this.articleAbstract = '';
    this.author = '';
    this.scientificArea = '';
    this.idArticle = '';
    this.magazineType = '';
    this.magazineTitle = '';
    this.highlight = '';
    this.status = '';
  }
}
