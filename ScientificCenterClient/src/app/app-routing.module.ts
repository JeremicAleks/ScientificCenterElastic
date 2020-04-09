import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: './magazine/magazine.module#MagazineModule'
  },
  {
    path: '',
    loadChildren: './authentication/authentication.module#AuthenticationModule'
  },
  {
    path: 'user',
    loadChildren: './user-management/user-management.module#UserManagementModule'
  },
  {
    path: 'editor',
    loadChildren: './editor-management/editor-management.module#EditorManagementModule'
  },
  {
    path: 'author',
    loadChildren: './author-management/author-management.module#AuthorManagementModule'
  },
  {
    path: 'article',
    loadChildren: './article/article.module#ArticleModule'
  },
  {
    path: 'search',
    loadChildren: './search/search.module#SearchModule'
  }
];
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }

