import {BoolQueryField} from './boolQueryField';

export class BoolQueryModel {
  fieldsAndValue: BoolQueryField[];
  operation: string;
  constructor() {
    this.fieldsAndValue = [];
    this.operation = '';
  }
}
