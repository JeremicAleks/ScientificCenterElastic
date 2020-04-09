import { Component, OnInit } from '@angular/core';
import {UserModel} from '../../core/model/user-model';
import {FormModel} from '../../core/model/form.model';
import {MagazineListModel} from '../../core/model/magazineList.model';
import {MagazineModel} from '../../core/model/magazine.model';
import {ArticleListModel} from '../../core/model/articleList.model';
import {Router} from '@angular/router';
import {ToastrService} from 'ngx-toastr';
import {MagazineService} from '../../core/service/magazine.service';
import {AuthenticationService} from '../../core/service/authentication.service';
import {UserService} from '../../core/service/user.service';
import {ArticleService} from '../../core/service/article.service';
import * as fileSaver from 'file-saver';
import {ArticleModel} from '../../core/model/article.model';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  user: UserModel = new UserModel();
  form: FormModel = new FormModel();
  magazineData: MagazineListModel = new MagazineListModel();
  magazine: MagazineModel = new MagazineModel();
  articlesUnactive: ArticleListModel = new ArticleListModel();

  constructor(private router: Router, private toastr: ToastrService, private magazineService: MagazineService,
              private authService: AuthenticationService, private userService: UserService, private articleService: ArticleService) { }

  ngOnInit() {
    this.getUser();
    this.getMagaziness();
    if (this.authService.isLeadEditor()) {
      this.getUnactiveArticle();
    }

  }

  getMagaziness() {
    this.magazineService.getMagazines().subscribe(
      data => {
        this.magazineData = data;
      }, error => {
        this.toastr.error('Neuspesno ucitavanje naucnih casopisa');
      }
    );
  }

  getUnactiveArticle() {
    this.articleService.getAllAritcleForEditor(this.authService.getUsernameFromToken()).subscribe(
      data => {
        this.articlesUnactive = data;
      }, error => {
        this.toastr.error('Neuspelo ucitavanje radova za glavnog urednika');
      }
    );
  }

  getUser() {
    this.userService.getUserByUsername(this.authService.getUsernameFromToken()).subscribe(
      data => {
        this.user = data;
      }, error => {
        this.toastr.error('Neuspesno ucitavanje korisnika');
      }
    );
  }

  addMagazine() {
    this.router.navigate(['/editor/addMagazine']);
  }

  addArticle(magazine: MagazineModel) {
    this.magazineService.saveMagazineForAdd(magazine);
    window.location.replace('/author/addArticle');
  }

  preuzmiPDF(article: ArticleModel) {
    this.articleService.downloadPDF(Number(article.id)).subscribe(
      data => {
        const blob: any = new Blob([data], { type: 'application/pdf' });
        fileSaver.saveAs(blob, article.title + '.pdf');
      }
    );
  }

  ChooseReviewer(article: ArticleModel) {
    this.articleService.saveArticleinStorage(article);
    this.router.navigate(['/search/reviewers']);
  }

  activateArticle(article: ArticleModel) {
    article.active = true;
    this.articleService.activateArticle(article).subscribe(
      () => {
        this.toastr.success('Rad uspesno aktiviran');
      }
    );
  }
}
