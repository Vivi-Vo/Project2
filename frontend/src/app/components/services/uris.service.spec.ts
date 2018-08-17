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

    it('should store all proper routes', inject([URIService], (service: URIService) => {
        expect(service.URIs.batch).toBe('/api/project2/batch');
        expect(service.URIs.batches).toBe('/api/project2/batches');
        expect(service.URIs.run).toBe('/run');
        expect(service.URIs.runLocal).toBe('http://localhost:3001/run');
    }));


    it('should store Angular URL constant', inject([URIService], (service: URIService) => {
        expect(service.ANGULAR_DEFAULT).toBe('http://localhost:4200/home');
    }));
});
