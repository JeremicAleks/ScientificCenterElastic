import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddArticleComponent } from './add-article/add-article.component';
import {AuthorManagementRoutingModule} from './author-management-routing.module';
import {FormsModule} from '@angular/forms';
import {MatSelectModule} from '@angular/material';



@NgModule({
  declarations: [AddArticleComponent],
  imports: [
    CommonModule,
    AuthorManagementRoutingModule,
    FormsModule,
    MatSelectModule
  ]
})
export class AuthorManagementModule { }
