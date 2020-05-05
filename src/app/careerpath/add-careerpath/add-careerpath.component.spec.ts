import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddCareerpathComponent } from './add-careerpath.component';

describe('AddCareerpathComponent', () => {
  let component: AddCareerpathComponent;
  let fixture: ComponentFixture<AddCareerpathComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddCareerpathComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddCareerpathComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
