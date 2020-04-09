import { Component, OnInit } from '@angular/core';
import {Login} from '../../core/model/login.model';
import {ToastrService} from 'ngx-toastr';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../core/service/authentication.service';
import {TokenService} from '../../core/service/token.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  loginData: Login = new Login();

  constructor(private toastr: ToastrService, private router: Router, private authService: AuthenticationService,
              private tokenService: TokenService) { }

  ngOnInit() {
  }

  onLogin(login: Login) {
    this.authService.getAccessToken(login.username, login.password).subscribe(
      data => {
        this.tokenService.saveToken(data.access_token);
        this.router.navigate(['/']);
      }, error => {
        this.toastr.error('Wrong credentials!');
      }
    );
  }

  registrationBtn() {
    this.router.navigate(['/registration']);
  }
}
