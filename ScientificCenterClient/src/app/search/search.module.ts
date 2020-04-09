import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SearchPageComponent } from './search-page/search-page.component';
import { SearchReviewersComponent } from './search-reviewers/search-reviewers.component';
import { NoSanitizePipe } from './no-sanitize.pipe';
import {SearchRoutingModule} from './search-routing.module';
import {MatSelectModule, MatTabsModule} from '@angular/material';
import {FormsModule} from '@angular/forms';



@NgModule({
  declarations: [SearchPageComponent, SearchReviewersComponent, NoSanitizePipe],
  imports: [
    CommonModule,
    SearchRoutingModule,
    MatTabsModule,
    MatSelectModule,
    FormsModule
  ]
})
export class SearchModule { }
