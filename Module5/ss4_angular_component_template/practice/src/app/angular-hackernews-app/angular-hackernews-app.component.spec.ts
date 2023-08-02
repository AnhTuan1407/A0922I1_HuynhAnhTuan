import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AngularHackernewsAppComponent } from './angular-hackernews-app.component';

describe('AngularHackernewsAppComponent', () => {
  let component: AngularHackernewsAppComponent;
  let fixture: ComponentFixture<AngularHackernewsAppComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AngularHackernewsAppComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AngularHackernewsAppComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
