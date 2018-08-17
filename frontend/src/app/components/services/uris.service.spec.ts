import { TestBed, inject } from '@angular/core/testing';

import { URIService } from './uris.service';

describe('URIService', () => {
    beforeEach(() => {
        TestBed.configureTestingModule({
            providers: [URIService]
        });
    });

    it('should be created', inject([URIService], (service: URIService) => {
        expect(service).toBeTruthy();
    }));

    it('should create a proper route', inject([URIService], (service: URIService) => {
        expect(service.getBatchUri(3)).toBe('/api/project2/batch/3/tests');
    }));
});
