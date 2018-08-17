import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class URIService {

    private readonly apiRoute = '/api/project2/';
    public readonly ANGULAR_DEFAULT = 'http://localhost:4200/home';
    public URIs = {
        batch: this.apiRoute + 'batch/',
        batches: this.apiRoute + 'batches/',
        run: '/run',
        runLocal: 'http://localhost:3001/run'
    };
    constructor() {}

    getBatchUri(id: number): string {
        return `${this.URIs.batch}${id}/tests`;
    }
}
