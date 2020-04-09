import { Component, OnInit } from '@angular/core';
import {ScientificAreaListModel} from '../../core/model/scientificAreaList.model';
import {ArticleListModel} from '../../core/model/articleList.model';
import {ArticleModel} from '../../core/model/article.model';
import {OrderItemModel} from '../../core/model/orderItem.model';
import {SearchModel} from '../../core/model/search.model';
import {ResultDataModel} from '../../core/model/resultData.model';
import {BooleanQueryModel} from '../../core/model/booleanQuery.model';
import {AdvQueryModel} from '../../core/model/advQuery.model';
import {BoolQueryModel} from '../../core/model/boolQuery.model';
import {ToastrService} from 'ngx-toastr';
import {ScientificAreaService} from '../../core/service/scientific-area.service';
import {MagazineService} from '../../core/service/magazine.service';
import {AuthenticationService} from '../../core/service/authentication.service';
import {OrderService} from '../../core/service/order.service';
import {ArticleService} from '../../core/service/article.service';
import {SearchService} from '../../core/service/search.service';
import * as fileSaver from 'file-saver';
import {NgForm} from '@angular/forms';
import {BoolQueryField} from '../../core/model/boolQueryField';
import {ScientificAreaModel} from '../../core/model/scientificArea.model';

@Component({
  selector: 'app-search-page',
  templateUrl: './search-page.component.html',
  styleUrls: ['./search-page.component.css']
})
export class SearchPageComponent implements OnInit {

  scientificAreaData: ScientificAreaListModel = new ScientificAreaListModel();
  articleData: ArticleListModel = new ArticleListModel();
  article: ArticleModel = new ArticleModel();
  // activeAddToCart: number[] = [];
  orderItems: OrderItemModel[] = [];
  searchData: SearchModel = new SearchModel();
  resultData: ResultDataModel[] = [];
  articleId: number;
  booleaQueryData: BooleanQueryModel = new BooleanQueryModel();
  advQuery: AdvQueryModel = new AdvQueryModel();
  boolQuery: BoolQueryModel = new BoolQueryModel();
  scientificAreaSearch: SearchModel = new SearchModel();

  constructor(private toastr: ToastrService, private scientificAreaService: ScientificAreaService, private magazineService: MagazineService,
              // tslint:disable-next-line:max-line-length
              private authService: AuthenticationService, private orderService: OrderService, private articleService: ArticleService, private searchService: SearchService) { }

  ngOnInit() {
    this.getScientifiAreas();
  }
  // getNaucneRadove() {
  //   this.naucniRadService.getAllRadove().subscribe(
  //     data => {
  //       this.naucniRadData = data;
  //     }, error => {
  //       this.toastr.error('Ucitavanje naucnih radova nije uspelo');
  //     }
  //   );
  // }

  getScientifiAreas() {
    this.scientificAreaService.getAllScientificAreas().subscribe(
      data => {
        this.scientificAreaData = data;
      }, error => {
        this.toastr.error('Ucitavanje naucnih oblasti nije uspelo');
      }
    );
  }

  onAddToCart(article: ResultDataModel) {
    // this.toastr.success("UNDER CONSTURCTION");
    // if (!this.authService.isUser()) {
    //   this.toastr.warning('You must login first. :)');
    //   return;
    // }
    this.articleId = Number(article.idArticle);
    this.articleService.getArticle(this.articleId).subscribe(
      data => {
        this.article = data;
        const orderItem: OrderItemModel = new OrderItemModel();
        // for (const activeCart of this.activeAddToCart) {
        //   if (activeCart === casopis.casopisId) {
        //     this.activeAddToCart.splice(
        //       this.activeAddToCart.indexOf(casopis.casopisId),
        //       1
        //     );
        //   }
        // }
        orderItem.article = this.article;
        orderItem.magazine = this.article.magazine;
        orderItem.amount = this.article.magazine.price;
        this.orderItems.push(orderItem);
        this.orderService.saveOrderItems(this.orderItems);
        this.toastr.success('Magazine added to cart');
      }
    );
  }


  search(searchData: SearchModel) {
    this.searchService.searchTerm(searchData).subscribe(
      data => {
        this.resultData = data;
        console.log(this.resultData);
      }
    );
  }

  downloadPDF(rad: ResultDataModel) {
    this.articleService.downloadPDF(Number(rad.idArticle)).subscribe(
      data => {
        const blob: any = new Blob([data], { type: 'application/pdf' });
        fileSaver.saveAs(blob, rad.title + '.pdf');
      }
    );
  }


  booleanQuery(value: any, f: NgForm, booleanData: BooleanQueryModel) {
    for (const property in value) {
      if (value[property] !== '') {
        const fieldBool: BoolQueryField = new BoolQueryField();
        fieldBool.field = property;
        fieldBool.value = value[property];
        this.boolQuery.fieldsAndValue.push(fieldBool);
      }
    }
    this.boolQuery.operation = booleanData.operator;
    this.searchService.searchBoolean(this.boolQuery).subscribe(
      data => {
        this.resultData = data;
        this.boolQuery = new BoolQueryModel();
      }
    );

  }

  searchScientificAreas(area: ScientificAreaModel) {
    this.scientificAreaSearch.value = area.name;
    this.scientificAreaSearch.field = 'scientificArea';
    this.searchService.searchTerm(this.scientificAreaSearch).subscribe(
      data => {
        this.resultData = data;
      }
    );

  }

}
