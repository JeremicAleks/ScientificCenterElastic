import { Component, OnInit } from '@angular/core';
import {RegistrationModel} from '../../core/model/registration.model';
import {ScientificAreaListModel} from '../../core/model/scientificAreaList.model';
import {ToastrService} from 'ngx-toastr';
import {ScientificAreaService} from '../../core/service/scientific-area.service';
import {AuthenticationService} from '../../core/service/authentication.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  registrationData: RegistrationModel = new RegistrationModel() ;
  scientificAreaData: ScientificAreaListModel = new ScientificAreaListModel();

  constructor(private toastr: ToastrService, private scientificAreaService: ScientificAreaService,
              private authService: AuthenticationService) { }
  ngOnInit() {
    this.getAllScientificAreas();
  }

  onRegistration(registrationData: RegistrationModel) {
    this.authService.registration(registrationData).subscribe(
      data => {
        if (data !== null) {
          this.toastr.success('Registration is successfully finish,check your email.');
        } else { this.toastr.error('Username or email is already exists'); }
      }, () => {
        this.toastr.error('Registration is unsuccessfully');
      }
    );
  }
  getAllScientificAreas() {
    this.scientificAreaService.getAllScientificAreas().subscribe(
      data => {
        this.scientificAreaData = data;
      }, () => {
        this.toastr.error('Error during loading scientific areas!');
      }
    );
  }
}
