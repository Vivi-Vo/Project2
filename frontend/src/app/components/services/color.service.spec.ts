import { TestBed, inject } from '@angular/core/testing';

import { ColorService } from './color.service';
describe('ColorService', () => {
    beforeEach(() => {
        TestBed.configureTestingModule({
            providers: [ColorService]
        });
    });

    it('should be created', inject([ColorService], (service: ColorService) => {
        expect(service).toBeTruthy();
    }));

    it('should pick green on 1', inject([ColorService], (service: ColorService) => {
        expect(service.selectColor(1)).toBe('green');
    }));

    it('should pick yellow on 2', inject([ColorService], (service: ColorService) => {
        expect(service.selectColor(2)).toBe('darkblue');
    }));

    it('should pick red on 0', inject([ColorService], (service: ColorService) => {
        expect(service.selectColor(0)).toBe('darkred');
    }));
});
