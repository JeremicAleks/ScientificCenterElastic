import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddMagazineUsersComponent } from './add-magazine-users.component';

describe('AddMagazineUsersComponent', () => {
  let component: AddMagazineUsersComponent;
  let fixture: ComponentFixture<AddMagazineUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddMagazineUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddMagazineUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
