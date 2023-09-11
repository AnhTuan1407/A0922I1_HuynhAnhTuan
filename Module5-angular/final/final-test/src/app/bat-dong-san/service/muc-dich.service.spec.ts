import { TestBed } from '@angular/core/testing';

import { MucDichService } from './muc-dich.service';

describe('MucDichService', () => {
  let service: MucDichService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MucDichService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
