import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {SearchModel} from '../model/search.model';
import {Observable} from 'rxjs';
import {BoolQueryModel} from '../model/boolQuery.model';
import {environment} from '../../../environments/environment';
import {ArticleModel} from '../model/article.model';
import {GeoSeacrhModel} from '../model/geoSeacrh.model';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) { }

  searchTerm(data: SearchModel): Observable<any> {
    return this.http.post(environment.url + 'search/term', data);
  }

  searchBoolean(data: BoolQueryModel): Observable<any> {
    return this.http.post(environment.url + 'search/boolean', data);
  }

  searchMoreLikeThis(data: ArticleModel): Observable<any> {
    return this.http.post(environment.url + 'search/moreLikeThis', data);
  }

  searchGeo(data: GeoSeacrhModel): Observable<any> {
    return this.http.post(environment.url + 'search/geoSearch', data);
  }
}
