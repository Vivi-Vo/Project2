import { Injectable } from '@angular/core';
import { ThemeService } from './theme.service';

@Injectable({
    providedIn: 'root'
})
export class ColorService {

    constructor(private themeService: ThemeService) {}

    /**
     * Returns a color value to dictate the background color of a test
     * @param value number or string
     * @returns color string
     */
    selectColor(value: any): string {
        value = parseInt(value, 10);
        switch (value) {
            case 1:
                if (this.themeService.theme === 'dark') {
                    return 'green';
                } else {
                    return 'lightgreen';
                }
            case 2:
                if (this.themeService.theme === 'dark') {
                    return 'blue';
                } else {
                    return 'dodgerblue';
                }
            default:
                if (this.themeService.theme === 'dark') {
                    return 'darkred';
                } else {
                    return 'pink';
                }
        }
    }
}
