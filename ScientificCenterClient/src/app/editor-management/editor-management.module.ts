import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { AddMagazineComponent } from './add-magazine/add-magazine.component';
import { AddMagazineUsersComponent } from './add-magazine-users/add-magazine-users.component';
import {EditorManagementRoutingModule} from './editor-management-routing.module';
import {FormsModule} from '@angular/forms';
import {MatSelectModule} from '@angular/material';



@NgModule({
  declarations: [AddMagazineComponent, AddMagazineUsersComponent],
  imports: [
    CommonModule,
    EditorManagementRoutingModule,
    FormsModule,
    MatSelectModule
  ]
})
export class EditorManagementModule { }
