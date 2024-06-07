import { TestBed } from '@angular/core/testing';

import { ListWorkersService } from './list-workers.service';

describe('ListWorkersService', () => {
  let service: ListWorkersService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListWorkersService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
