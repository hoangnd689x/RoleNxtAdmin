import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EditCompetencyComponent } from './edit-competency.component';

describe('EditCompetencyComponent', () => {
  let component: EditCompetencyComponent;
  let fixture: ComponentFixture<EditCompetencyComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EditCompetencyComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EditCompetencyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
