import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCareerpathComponent } from './list-careerpath.component';

describe('ListCareerpathComponent', () => {
  let component: ListCareerpathComponent;
  let fixture: ComponentFixture<ListCareerpathComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListCareerpathComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCareerpathComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
