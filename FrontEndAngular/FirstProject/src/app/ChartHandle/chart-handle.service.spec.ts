import { TestBed } from '@angular/core/testing';

import { ChartHandleService } from './chart-handle.service';

describe('ChartHandleService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ChartHandleService = TestBed.get(ChartHandleService);
    expect(service).toBeTruthy();
  });
});
