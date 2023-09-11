import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BdsCreateComponent } from './bds-create.component';

describe('BdsCreateComponent', () => {
  let component: BdsCreateComponent;
  let fixture: ComponentFixture<BdsCreateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BdsCreateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BdsCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
