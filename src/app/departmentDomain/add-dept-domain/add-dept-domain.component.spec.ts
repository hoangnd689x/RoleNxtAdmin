import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AddDeptDomainComponent } from './add-dept-domain.component';

describe('AddDeptDomainComponent', () => {
  let component: AddDeptDomainComponent;
  let fixture: ComponentFixture<AddDeptDomainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AddDeptDomainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AddDeptDomainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
