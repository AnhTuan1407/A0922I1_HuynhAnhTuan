import { TestBed } from '@angular/core/testing';

import { BdsService } from './bds.service';

describe('BdsService', () => {
  let service: BdsService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(BdsService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
