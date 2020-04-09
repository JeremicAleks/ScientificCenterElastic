import { Component, OnInit } from '@angular/core';
import {ScientificAreaListModel} from '../../core/model/scientificAreaList.model';
import {ArticleListModel} from '../../core/model/articleList.model';
import {ArticleService} from '../../core/service/article.service';
import {ToastrService} from 'ngx-toastr';
import {ScientificAreaService} from '../../core/service/scientific-area.service';
import {MagazineService} from '../../core/service/magazine.service';
import {AuthenticationService} from '../../core/service/authentication.service';
import {ArticleModel} from '../../core/model/article.model';

@Component({
  selector: 'app-article-page',
  templateUrl: './article-page.component.html',
  styleUrls: ['./article-page.component.css']
})
export class ArticlePageComponent implements OnInit {

  scientifiAreaData: ScientificAreaListModel = new ScientificAreaListModel();
  articleData: ArticleListModel = new ArticleListModel();

  constructor(private articleService: ArticleService, private toastr: ToastrService, private scientificAreaService: ScientificAreaService,
              private magazineService: MagazineService, private authService: AuthenticationService) { }

  ngOnInit() {
    this.getScientificAreas();
    this.getArticles();
  }

  getArticles() {
    this.articleService.getAllArticles().subscribe(
      data => {
        this.articleData = data;
      }, error => {
        this.toastr.error('Articles does not exists');
      }
    );
  }

  getScientificAreas() {
    this.scientificAreaService.getAllScientificAreas().subscribe(
      data => {
        console.log(data);
        this.scientifiAreaData = data;
      }, error => {
        this.toastr.error('Scientific areas does not exists');
      }
    );
  }

  buyCasopis(article: ArticleModel) {
    this.toastr.success('Article is successfully bought');
  }

  onAddToCart(article: ArticleModel) {
    this.toastr.success('Article is added to cart');
  }


}
