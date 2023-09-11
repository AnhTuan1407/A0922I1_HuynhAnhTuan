import { TestBed } from '@angular/core/testing';

import { TinhTrangService } from './tinh-trang.service';

describe('TinhTrangService', () => {
  let service: TinhTrangService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TinhTrangService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
