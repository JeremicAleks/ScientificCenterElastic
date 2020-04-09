export class BooleanQueryModel {
  magazineTitle: string;
  title: string;
  author: string;
  keywords: string;
  text: string;
  scientificAreas: string;
  operator: string;

  constructor() {
    this.magazineTitle = '';
    this.title = '';
    this.author = '';
    this.keywords = '';
    this.text = '';
    this.scientificAreas = '';
    this.operator = '';
  }
}
