import { Component, OnInit } from '@angular/core';
import {AddMagazineUsersModel} from '../../core/model/addMagazineUsers.model';
import {MagazineModel} from '../../core/model/magazine.model';
import {UserDataModel} from '../../core/model/userData-model';
import {ToastrService} from 'ngx-toastr';
import {ScientificAreaService} from '../../core/service/scientific-area.service';
import {MagazineService} from '../../core/service/magazine.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-magazine-users',
  templateUrl: './add-magazine-users.component.html',
  styleUrls: ['./add-magazine-users.component.css']
})
export class AddMagazineUsersComponent implements OnInit {

  addMagazineUsers: AddMagazineUsersModel = new AddMagazineUsersModel();
  magazine: MagazineModel = new MagazineModel();
  reviewer: UserDataModel = new UserDataModel();
  editors: UserDataModel = new UserDataModel();

  // tslint:disable-next-line:max-line-length
  constructor(private toastr: ToastrService, private scientificAreaService: ScientificAreaService, private magazineService: MagazineService, private router: Router) { }

  ngOnInit() {
    this.getAllReviewers();
    this.getAllEditors();
  }


  getAllEditors() {
    this.magazine = this.magazineService.getMagazineForAdd();
    this.scientificAreaService.getUserForScientificAreas(this.magazine.magazineId, 'EDITOR').subscribe(
      data => {
        this.editors = data;
      }, () => {
        this.toastr.error('Neuspesno ucitavanje urednika');
      }
    );
  }

  getAllReviewers() {
    this.magazine = this.magazineService.getMagazineForAdd();
    this.scientificAreaService.getUserForScientificAreas(this.magazine.magazineId, 'REVIEWER').subscribe(
      data => {
        this.reviewer = data;
      }, error => {
        this.toastr.error('Neuspesno ucitavanje urednika');
      }
    );
  }

  addMagazine(addMagazineUsers: AddMagazineUsersModel) {
    addMagazineUsers.id = this.magazineService.getMagazineForAdd().magazineId;
    if (addMagazineUsers.reviewersIds.length < 2) {
      this.toastr.error('Morate izabrati najmanje 2 recenzenata');
    } else {
      this.magazineService.addMagazineUsers(addMagazineUsers).subscribe(
        data => {
          this.toastr.success('Casopis usepsno dodat');
          this.router.navigate(['/']);
        }, error => {
          this.toastr.error('Nije moguce dodati casopis');
        }
      );
    }
  }
}
