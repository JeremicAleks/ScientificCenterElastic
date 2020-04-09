export class  AddArticleModel {
  title: string;

  keywords: string;

  articleAbstract: string;

  fileLocation: string;

  scientificAreaId: number;

  magazineId: number;

  authorUsername: string;

  active: boolean;

  constructor() {
    this.title = '';
    this.keywords = '';
    this.articleAbstract = '';
    this.fileLocation = '';
    this.scientificAreaId = null;
    this.magazineId = null;
    this.authorUsername = '';
    this.active = false;
  }
}
