import { Injectable } from '@angular/core';

// I should have named this YuviService
@Injectable({
    providedIn: 'root'
})
export class ThemeService {

    private _theme = 'dark';
    public get theme() {
        return this._theme;
    }
    public set theme(value: string) {
        this._theme = value.toLowerCase();
    }
    constructor() {}
}
