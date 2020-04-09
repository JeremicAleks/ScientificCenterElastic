import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ArticlePageComponent } from './article-page/article-page.component';
import {ArticleRoutingModule} from './article-routing.module';



@NgModule({
  declarations: [ArticlePageComponent],
  imports: [
    CommonModule,
    ArticleRoutingModule
  ]
})
export class ArticleModule { }
