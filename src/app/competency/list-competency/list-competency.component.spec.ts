import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListCompetencyComponent } from './list-competency.component';

describe('ListCompetencyComponent', () => {
  let component: ListCompetencyComponent;
  let fixture: ComponentFixture<ListCompetencyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListCompetencyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListCompetencyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
