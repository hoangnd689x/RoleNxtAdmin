import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditDeptDomainComponent } from './edit-dept-domain.component';

describe('EditDeptDomainComponent', () => {
  let component: EditDeptDomainComponent;
  let fixture: ComponentFixture<EditDeptDomainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditDeptDomainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditDeptDomainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
