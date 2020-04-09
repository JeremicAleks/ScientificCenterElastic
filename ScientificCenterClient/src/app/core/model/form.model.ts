import {FormFieldModel} from './formField.model';

export class FormModel {
  taskId: string;
  processInstanceId: string;
  formFields: FormFieldModel[];
  constructor() {
    this.taskId = '';
    this.processInstanceId = '';
    this.formFields = [];
  }
}
