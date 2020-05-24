import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListDeptDomainComponent } from './list-dept-domain.component';

describe('ListDeptDomainComponent', () => {
  let component: ListDeptDomainComponent;
  let fixture: ComponentFixture<ListDeptDomainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListDeptDomainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListDeptDomainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
