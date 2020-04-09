import { Injectable } from '@angular/core';
import {ArticleModel} from '../model/article.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Observable} from 'rxjs';
import {environment} from '../../../environments/environment';
import {AddReviewersModel} from '../model/addReviewers.model';
import {AddArticleModel} from '../model/addArticle.model';

const ARTICLESTORAGE = 'articleStorage';

@Injectable({
  providedIn: 'root'
})
export class ArticleService {

  article: ArticleModel = new ArticleModel();

  constructor(private http: HttpClient) { }

  getAllArticles(): Observable<any> {
    return this.http.get(environment.url + 'api/article');
  }

  getAllAritcleForEditor(username: string): Observable<any> {
    return this.http.get(environment.url + 'api/article/inactiveArticle/' + username);
  }

  saveArticle(data: AddArticleModel): Observable<any> {
    return this.http.post(environment.url + 'api/article', data);
  }

  addReviewersArticle(data: AddReviewersModel, idArticle: number): Observable<any> {
    return this.http.post(environment.url + 'api/article/addReviewers/' + idArticle, data);
  }
  activateArticle(data: ArticleModel): Observable<any> {
    return this.http.put(environment.url + 'api/article/activateArticle', data);
  }

  uploadFilePdf(formData: FormData, idArticle: number): Observable<any> {
    return this.http.post(environment.url + 'api/article/' + idArticle, formData);
  }

  getArticle(idArticle: number): Observable<any> {
    return this.http.get(environment.url + 'api/article/' + idArticle);
  }

  downloadPDF(idArticle: number): Observable<any> {
    const httpHeaders  = new HttpHeaders()
      .set('Accept', 'application/pdf')
      .set('Content-type', 'application/pdf');
    return this.http.get(environment.url + 'api/article/pdf/' + idArticle , {headers: httpHeaders, responseType: 'blob'});
  }

  getArticleFromStorage(): ArticleModel {
    this.article = new ArticleModel();
    if (window.localStorage[ARTICLESTORAGE]) {
      this.article = JSON.parse(window.localStorage[ARTICLESTORAGE]);
    }
    return this.article;
  }
  saveArticleinStorage(model: ArticleModel) {
    window.localStorage.removeItem(ARTICLESTORAGE);
    window.localStorage.setItem(ARTICLESTORAGE, JSON.stringify(model));
  }
  destroyArticleFromStorage() {
    window.localStorage.removeItem(ARTICLESTORAGE);
  }
}
