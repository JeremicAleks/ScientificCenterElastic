import { Component, OnInit } from '@angular/core';
import {ArticleModel} from '../../core/model/article.model';
import {ScientificAreaListModel} from '../../core/model/scientificAreaList.model';
import {UserDataModel} from '../../core/model/userData-model';
import {AddReviewersModel} from '../../core/model/addReviewers.model';
import {MoreLikeThisModel} from '../../core/model/moreLikeThis.model';
import {GeoSeacrhModel} from '../../core/model/geoSeacrh.model';
import {GeoResponseModel} from '../../core/model/geoResponse.model';
import {AuthenticationService} from '../../core/service/authentication.service';
import {Router} from '@angular/router';
import {SearchService} from '../../core/service/search.service';
import {UserService} from '../../core/service/user.service';
import {ToastrService} from 'ngx-toastr';
import {ScientificAreaService} from '../../core/service/scientific-area.service';
import {ArticleService} from '../../core/service/article.service';

@Component({
  selector: 'app-search-reviewers',
  templateUrl: './search-reviewers.component.html',
  styleUrls: ['./search-reviewers.component.css']
})
export class SearchReviewersComponent implements OnInit {
  article: ArticleModel = new ArticleModel();
  scientifAreaData: ScientificAreaListModel = new ScientificAreaListModel();
  reviewers: UserDataModel = new UserDataModel();
  addReviewersData: AddReviewersModel = new AddReviewersModel();
  moreLikeThisData: MoreLikeThisModel = new MoreLikeThisModel();
  geoSearch: GeoSeacrhModel = new GeoSeacrhModel();
  geoResponseModel: GeoResponseModel = new GeoResponseModel();

  constructor(private authService: AuthenticationService, private scientificAreaService: ScientificAreaService, private toastr: ToastrService,
              private router: Router, private articleService: ArticleService, private userService: UserService,
              private searchService: SearchService) { }

  ngOnInit() {
    this.getAllScientificAreas();
    this.getAllReviewers();
    this.article = this.articleService.getArticleFromStorage();
  }

  getAllScientificAreas() {
    this.scientificAreaService.getAllScientificAreas().subscribe(
      data => {
        this.scientifAreaData = data;
      }, () => {
        this.toastr.error('Neuspesno ucitavanje naucnih oblasti');
      }
    );
  }

  getAllReviewers() {
    this.userService.getUsersByRole('REVIEWER').subscribe(
      data => {
        this.reviewers = data;
      }, () => {
        this.toastr.error('Neuspelo preuzimanje recenzenata');
      }
    );
  }

  izaberi(addReviewersData: AddReviewersModel) {
    this.articleService.addReviewersArticle(addReviewersData, this.article.id).subscribe(
      data => {
        this.toastr.success('Uspesno');
        this.router.navigate(['/user/profile']);
      }
    );
  }

  moreLikeThis() {

    this.searchService.searchMoreLikeThis(this.article).subscribe(
      data => {
        this.moreLikeThisData = data;
        this.reviewers = this.moreLikeThisData.reviewers;
        console.log(data);
        this.toastr.success('Uspesno MoreLikeThis filtriranje');
      }, () => {
        this.toastr.error('Neuspelo MoreLikeThis Filtriranje');
      }
    );
  }

  geoprostorna() {
    this.moreLikeThisData = new MoreLikeThisModel();
    this.geoSearch.userId = this.article.author.userId;
    this.searchService.searchGeo(this.geoSearch).subscribe(
      data => {
        this.geoResponseModel = data;
        this.reviewers = this.geoResponseModel.userListDTO;
        console.log(this.geoResponseModel.resultDataUsers);
        console.log(data);
        this.toastr.success('Filtriranje pomocu geoprostorne pretrage je uspelo');
      }, () => {
        this.toastr.error('Nije uspelo filtriranje GeoProstornom pretragom');
      }
    );
    // this.toastr.warning('UNDER CONSTRUCTION');
  }

  naucnaOblastFilter(addReviewersData: AddReviewersModel) {
    this.moreLikeThisData = new MoreLikeThisModel();
    this.userService.getUserByRoleAndScientificArea('REVIEWER', this.article.scientificArea.name).subscribe(
      data => {
        this.reviewers = data;
        this.toastr.success('Filtriranje po naucnim oblastima uspesno');
      }, () => {
        this.toastr.error('Neuspelo filtriranje po naucnim olbastima');
      }
    );
  }

  ukloniFilter() {
    this.getAllReviewers();
    this.moreLikeThisData = new MoreLikeThisModel();
    this.toastr.success('Filteri uspesno ukljonjeni');
  }
}
