import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class ColorService {

    constructor() {}

    selectColor(value: any): string {
        value = parseInt(value, 10);
        switch (value) {
            case 1:
                return 'green';
            case 2:
                return 'darkblue';
            default:
                return 'darkred';
        }
    }
}
