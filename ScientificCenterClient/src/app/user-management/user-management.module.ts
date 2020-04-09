import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ProfileComponent } from './profile/profile.component';
import {UserManagementRoutingModule} from './user-management-routing.module';
import {FormsModule} from '@angular/forms';



@NgModule({
  declarations: [ProfileComponent],
  imports: [
    CommonModule,
    UserManagementRoutingModule,
    FormsModule
  ]
})
export class UserManagementModule { }
