import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SearchPageComponent} from './search-page/search-page.component';
import {SearchReviewersComponent} from './search-reviewers/search-reviewers.component';

const routes: Routes = [
  {
    path: '',
    component: SearchPageComponent
  },
  {
    path: 'reviewers',
    component: SearchReviewersComponent
  }
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class SearchRoutingModule { }
