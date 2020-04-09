import { Component, OnInit } from '@angular/core';
import {ArticleModel} from '../../core/model/article.model';
import {MagazineModel} from '../../core/model/magazine.model';
import {ToastrService} from 'ngx-toastr';
import {ArticleService} from '../../core/service/article.service';
import {MagazineService} from '../../core/service/magazine.service';
import {AuthenticationService} from '../../core/service/authentication.service';
import {AddArticleModel} from '../../core/model/addArticle.model';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-article',
  templateUrl: './add-article.component.html',
  styleUrls: ['./add-article.component.css']
})
export class AddArticleComponent implements OnInit {


  addArticleData: AddArticleModel = new AddArticleModel();
  magazine: MagazineModel = new MagazineModel();
  selectedFile: any;
  article: ArticleModel = new ArticleModel();
  constructor(private toastr: ToastrService, private articleService: ArticleService, private magazineService: MagazineService,
              private authService: AuthenticationService, private router: Router) { }

  ngOnInit() {
  this.getMagazine();
  }

  getMagazine() {
    this.magazine = this.magazineService.getMagazineForAdd();
  }

  addArticle(addArticleData: AddArticleModel) {
    addArticleData.magazineId = this.magazine.magazineId;
    addArticleData.authorUsername = this.authService.getUsernameFromToken();
    this.articleService.saveArticle(addArticleData).subscribe(
      data => {
        if (data !== null) {
          this.article = data;
          const formData = new FormData();
          formData.append('file', this.selectedFile, this.selectedFile.name);
          this.articleService.uploadFilePdf(formData, this.article.id).subscribe(
            result => {
              this.toastr.success('Article is successfully added!');
              this.router.navigate(['user/profile']);
            }, () => {
              this.toastr.error('Article is not added!');
            }
          );
        }
      }, error => {
        this.toastr.error('Error on server!');
      }
    );
  }


  onFileSelect(files: FileList) {
    this.selectedFile = files.item(0);
  }
}
