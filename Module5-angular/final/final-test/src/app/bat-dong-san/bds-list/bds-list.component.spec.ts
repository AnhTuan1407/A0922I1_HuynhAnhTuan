import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BdsListComponent } from './bds-list.component';

describe('BdsListComponent', () => {
  let component: BdsListComponent;
  let fixture: ComponentFixture<BdsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BdsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BdsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
