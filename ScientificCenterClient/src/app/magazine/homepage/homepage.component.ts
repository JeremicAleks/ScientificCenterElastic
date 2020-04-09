import { Component, OnInit } from '@angular/core';
import {ScientificAreaListModel} from '../../core/model/scientificAreaList.model';
import {MagazineListModel} from '../../core/model/magazineList.model';
import {OrderItemModel} from '../../core/model/orderItem.model';
import {ToastrService} from 'ngx-toastr';
import {ScientificAreaService} from '../../core/service/scientific-area.service';
import {MagazineService} from '../../core/service/magazine.service';
import {AuthenticationService} from '../../core/service/authentication.service';
import {MagazineModel} from '../../core/model/magazine.model';
import {OrderService} from '../../core/service/order.service';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  scientifiAreaData: ScientificAreaListModel = new ScientificAreaListModel();
  magazineData: MagazineListModel = new MagazineListModel();
  activeAddToCart: number[] = [];
  orderItems: OrderItemModel[] = [];

  constructor(private toastr: ToastrService, private scientificAreaService: ScientificAreaService, private magazineService: MagazineService,
              private authService: AuthenticationService, private orderService: OrderService) { }

  ngOnInit() {
    this.getScientificAreas();
    this.getMagazines();
  }

  getMagazines() {
    this.magazineService.getMagazines().subscribe(
      data => {
        this.magazineData = data;
        for (const magazine of data.magazines) {
          this.activeAddToCart.push(magazine.magazineId);
        }
        this.getMagazinesInCart();
      }, error => {
        this.toastr.error('Ucitavanje naucnih casopisa nije uspelo');
      }
    );
  }

  getScientificAreas() {
    this.scientificAreaService.getAllScientificAreas().subscribe(
      data => {
        console.log(data);
        this.scientifiAreaData = data;
      }, error => {
        this.toastr.error('Ucitavanje naucnih oblasti nije uspelo');
      }
    );
  }

  buyMagazine(magazine: MagazineModel) {
    this.toastr.success('Casopis je uspesno kupljen');
  }

  onAddToCart(magazine: MagazineModel) {
    if (!this.authService.isUser()) {
      this.toastr.warning('You must login first. :)');
      return;
    }
    const orderItem: OrderItemModel = new OrderItemModel();
    for (const activeCart of this.activeAddToCart) {
      if (activeCart === magazine.magazineId) {
        this.activeAddToCart.splice(
          this.activeAddToCart.indexOf(magazine.magazineId),
          1
        );
      }
    }
    orderItem.magazine = magazine;
    orderItem.amount = magazine.price;
    this.orderItems.push(orderItem);
    this.orderService.saveOrderItems(this.orderItems);
    this.toastr.success('Magazine added to cart');
  }
  getMagazinesInCart() {
    this.orderItems = this.orderService.getOrderItems();
    if (this.orderItems === null) {
      this.orderItems = [];
    } else {
      for (const orderItem of this.orderItems) {
        if (this.activeAddToCart.includes(orderItem.magazine.magazineId)) {
          this.activeAddToCart.splice(this.activeAddToCart.indexOf(orderItem.magazine.magazineId), 1);
        }
      }
    }
  }
}
