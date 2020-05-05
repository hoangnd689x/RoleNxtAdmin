import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCareerpathComponent } from './edit-careerpath.component';

describe('EditCareerpathComponent', () => {
  let component: EditCareerpathComponent;
  let fixture: ComponentFixture<EditCareerpathComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditCareerpathComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditCareerpathComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
