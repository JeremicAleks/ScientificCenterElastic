import { Injectable } from '@angular/core';
import {OrderItemModel} from '../model/orderItem.model';


const ORDER_ITEMS = 'orderItems';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

  public orderItems: OrderItemModel[];
  constructor() { }

  public saveOrderItems(orderItems: OrderItemModel[]) {
    window.sessionStorage.removeItem(ORDER_ITEMS);
    window.sessionStorage.setItem(ORDER_ITEMS, JSON.stringify(orderItems));
  }

  public getOrderItems(): OrderItemModel[] {
    this.orderItems = [];
    if (sessionStorage.getItem(ORDER_ITEMS)) {
      this.orderItems = JSON.parse(sessionStorage.getItem(ORDER_ITEMS));
    }
    return this.orderItems;
  }
}
