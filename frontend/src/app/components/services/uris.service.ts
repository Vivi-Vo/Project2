import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class URIService {

    private readonly apiRoute = '/api/project2/';
    private readonly _ANGULAR_DEFAULT = 'http://localhost:4200';
    public readonly URIs = {
        batch: this.apiRoute + 'batch',
        batches: this.apiRoute + 'batches',
        run: '/run',
        batchLocal: '',
        batchesLocal: 'http://localhost:3000/batches',
        runLocal: 'http://localhost:3000/run'
    };
    constructor() {}

    getBatchUri(id: number): string {
        if (window.location.href === this._ANGULAR_DEFAULT + window.location.pathname) {
            return 'http://localhost:3000/run';
        }
        return `${this.URIs.batch}/${id}/tests`;
    }

    getURIRoute(uri: string): string {
        if (!this.URIs.hasOwnProperty(uri)) {
            throw new Error(`Invalid URI: must only be 'batch', 'batches', 'run' `);
        }
        if (window.location.href === this._ANGULAR_DEFAULT + window.location.pathname) {
            return this.URIs[uri + 'Local'];
        } else {
            return this.URIs[uri];
        }
    }
}
