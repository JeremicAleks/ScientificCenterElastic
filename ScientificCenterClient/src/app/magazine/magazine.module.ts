import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MagazineRoutingModule} from './magazine-routing.module';
import { HomepageComponent } from './homepage/homepage.component';
import { OrderCartComponent } from './order-cart/order-cart.component';



@NgModule({
  declarations: [HomepageComponent, OrderCartComponent],
  imports: [
    CommonModule,
    MagazineRoutingModule
  ]
})
export class MagazineModule { }
