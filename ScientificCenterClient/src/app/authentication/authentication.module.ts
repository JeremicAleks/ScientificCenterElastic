import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { LoginComponent } from './login/login.component';
import { RegistrationComponent } from './registration/registration.component';
import {AuthenticationRoutingModule} from './authentication-routing.module';
import {FormsModule} from '@angular/forms';
import {MatCheckboxModule, MatSelectModule} from '@angular/material';



@NgModule({
  declarations: [LoginComponent, RegistrationComponent],
  imports: [
    CommonModule,
    AuthenticationRoutingModule,
    FormsModule,
    MatSelectModule,
    MatCheckboxModule
  ]
})
export class AuthenticationModule { }
