import { Component, OnInit } from '@angular/core';
import {OrderMagazineModel} from '../../core/model/orderMagazine.model';
import {OrderItemModel} from '../../core/model/orderItem.model';
import {ToastrService} from 'ngx-toastr';
import {OrderService} from '../../core/service/order.service';

@Component({
  selector: 'app-order-cart',
  templateUrl: './order-cart.component.html',
  styleUrls: ['./order-cart.component.css']
})
export class OrderCartComponent implements OnInit {

// bookData: BookInfo = new BookInfo();
  orderItems: OrderItemModel[] = [];
  order: OrderMagazineModel = new OrderMagazineModel();
  // orderList: OrderList = new OrderList();
  message: string;
  succesOrder: boolean;
  errorOrder: boolean;


  constructor(private toastr: ToastrService, private orderService: OrderService) { }

  ngOnInit() {
    this.getOrderItems();
  }

  minusQuantity(ord: OrderItemModel) {
    if (ord.quantity > 1) {
      ord.quantity -= 1;
      ord.amount = ord.quantity * ord.magazine.price;
      this.order.total -= ord.magazine.price;
      this.orderService.saveOrderItems(this.orderItems);
    }
  }

  plusQuantity(ord: OrderItemModel) {
    ord.quantity += 1;
    ord.amount = ord.quantity * ord.magazine.price;
    this.order.total += ord.magazine.price;
    this.orderService.saveOrderItems(this.orderItems);
  }


  deleteOrder(i: number) {
    this.orderItems.splice(i, 1);
    this.getTotal();
    this.toastr.success('Order item is removed from cart');
    this.orderService.saveOrderItems(this.orderItems);
  }

  getTotal() {
    this.order.total = 0;
    for (const i of this.orderItems) {
      this.order.total += i.amount;
    }
  }

  deleteAllItems() {
    this.orderItems = [];
    this.order.total = 0;
    this.toastr.success('The cart is empty');
    this.orderService.saveOrderItems(this.orderItems);
  }

  getOrderItems() {
    this.orderItems = this.orderService.getOrderItems();
    this.getTotal();
  }

  makePurchase() {
    this.toastr.success('Uspesno je placeno');
    // let selectedOrderList: OrderList = new OrderList();
    // for(let ord of this.orderItems) {
    //   let addOrder: AddOrder = new AddOrder();
    //   addOrder.amount = ord.quantity;
    //   addOrder.bookId = ord.book.bookId;
    //   selectedOrderList.orders.push(addOrder);
    // }
    // selectedOrderList.total = Math.round(this.order.total * 100) / 100;
    //
    // this.orderService.orderBook(selectedOrderList).subscribe(
    //   response => {
    //     this.message = "Purchase has been successfuly completed!\nID of this order: #"+ response.orderId;
    //     this.orderItems = new Array();
    //     this.order.total = 0;
    //     this.orderService.saveOrderItems(this.orderItems);
    //     this.succesOrder = true;
    //     this.errorOrder = false;
    //   },
    //   error => {
    //     this.message = "You have selected more books than it's possible!\n" + error.error.message;
    //     this.succesOrder = false;
    //     this.errorOrder = true;
    //   }
    // );
  }

}
