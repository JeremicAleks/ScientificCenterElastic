export class FormFieldModel {
  id: string;
  label: string;
  type: object[];
  typeName: string;
  values: string[];
  value: string;
  readonly: boolean;
  enumValues: string[];
  constructor() {
    this.id = '';
    this.label = '';
    this.typeName = '';
    this.values = [];
    this.type = [];
    this.value = '';
    this.readonly = false;
    this.enumValues = [];
  }
}
