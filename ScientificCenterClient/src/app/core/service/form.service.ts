import { Injectable } from '@angular/core';
import {FormModel} from '../model/form.model';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';

const FORM = 'FORM';

@Injectable({
  providedIn: 'root'
})
export class FormService {

  formModel: FormModel = new FormModel();

  constructor(private http: HttpClient) { }

  postTask(model, taskId): Observable<any> {
    return this.http.post(environment.url + 'api/obradaTeksta/' + taskId, model);
  }

  getFormTask(taskId): Observable<any> {
    return this.http.get(environment.url + 'api/obradaTeksta/taskForm/' + taskId);
  }


  getForm(): FormModel {
    this.formModel = new FormModel();
    if (window.localStorage[FORM]) {
      this.formModel = JSON.parse(window.localStorage[FORM]);
    }
    return this.formModel;
  }
  saveForm(model: FormModel) {
    window.localStorage.removeItem(FORM);
    window.localStorage.setItem(FORM, JSON.stringify(model));
  }
  destroyForm() {
    window.localStorage.removeItem(FORM);
  }

}
