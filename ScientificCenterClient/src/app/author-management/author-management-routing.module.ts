import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddArticleComponent} from './add-article/add-article.component';

const routes: Routes = [
  {
    path: 'addArticle',
    component: AddArticleComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AuthorManagementRoutingModule { }
