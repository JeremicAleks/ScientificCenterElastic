import { Component, OnInit } from '@angular/core';
import {OrderService} from '../../core/service/order.service';
import {TokenService} from '../../core/service/token.service';
import {AuthenticationService} from '../../core/service/authentication.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private router: Router, private authService: AuthenticationService, private tokenService: TokenService, private orderService: OrderService) { }

  ngOnInit() {
  }

  onLogout() {
    this.tokenService.destroyToken();
    this.router.navigate(['']);
  }

}
