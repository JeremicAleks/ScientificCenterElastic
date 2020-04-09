import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddMagazineComponent} from './add-magazine/add-magazine.component';
import {AddMagazineUsersComponent} from './add-magazine-users/add-magazine-users.component';

const routes: Routes = [
  {
    path: 'addMagazine',
    component: AddMagazineComponent
  },
  {
    path: 'addMagazineUsers',
    component: AddMagazineUsersComponent
  }
];


@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class EditorManagementRoutingModule { }
