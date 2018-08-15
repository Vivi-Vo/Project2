import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CucumberTestComponent } from './cucumber-test.component';

describe('CucumberTestComponent', () => {
  let component: CucumberTestComponent;
  let fixture: ComponentFixture<CucumberTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CucumberTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CucumberTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
