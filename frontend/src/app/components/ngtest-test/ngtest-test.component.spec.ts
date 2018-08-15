import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NgtestTestComponent } from './ngtest-test.component';

describe('NgtestTestComponent', () => {
  let component: NgtestTestComponent;
  let fixture: ComponentFixture<NgtestTestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NgtestTestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NgtestTestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
