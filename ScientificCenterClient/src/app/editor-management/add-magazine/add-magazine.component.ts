import { Component, OnInit } from '@angular/core';
import {ScientificAreaListModel} from '../../core/model/scientificAreaList.model';
import {AddMagazineDataModel} from '../../core/model/addMagazineData.model';
import {MagazineModel} from '../../core/model/magazine.model';
import {AuthenticationService} from '../../core/service/authentication.service';
import {ScientificAreaService} from '../../core/service/scientific-area.service';
import {ToastrService} from 'ngx-toastr';
import {MagazineService} from '../../core/service/magazine.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-magazine',
  templateUrl: './add-magazine.component.html',
  styleUrls: ['./add-magazine.component.css']
})
export class AddMagazineComponent implements OnInit {

  scientifAreaData: ScientificAreaListModel = new ScientificAreaListModel();
  addMagazineData: AddMagazineDataModel = new AddMagazineDataModel();
  magazineData: MagazineModel = new MagazineModel();

  constructor(private authService: AuthenticationService, private scientificAreaService: ScientificAreaService,
              private toastr: ToastrService, private magazineService: MagazineService, private router: Router ) { }

  ngOnInit() {
    this.getAllScientificAreas();
  }

  getAllScientificAreas() {
    this.scientificAreaService.getAllScientificAreas().subscribe(
      data => {
        this.scientifAreaData = data;
      }, () => {
        this.toastr.error('Unsuccessfully load');
      }
    );
  }

  addData(data: AddMagazineDataModel) {
    data.leadEditorUsername = this.authService.getUsernameFromToken();
    this.magazineService.addMagaizneData(data).subscribe(
      res => {
        this.magazineData = res;
        this.magazineService.saveMagazineForAdd(this.magazineData);
        this.router.navigate(['editor/addMagazineUsers']);
      }, () => {
        this.toastr.error('Neuspesno dodavanje casopisa');
      }
    );
  }

}
