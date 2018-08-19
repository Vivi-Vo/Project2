import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class URIService {

    private readonly apiRoute = '/api/project2/';
    private readonly _ANGULAR_DEFAULT = 'http://localhost:4200';
    private readonly URIs = {
        batch: this.apiRoute + 'batch',
        batches: this.apiRoute + 'batches',
        run: '/run',
        batchLocal: 'http://ec2-18-206-188-225.compute-1.amazonaws.com/api/project2/batch',
        batchesLocal: 'http://localhost:3000/batches',
        runLocal: 'http://localhost:3000/run'
    };

    constructor() {}

    /**
     * Constructs a URI to grab the tests for a particular batch
     * or, if served on _ANGULAR_DEFAULT, grabs test data from a local server
     * @param id the batch we need to get the tests for
     */
    getBatchUri(id: number): string {
        if (window.location.href === this._ANGULAR_DEFAULT + window.location.pathname) {
            return 'http://localhost:3000/run';
        }
        return `${this.URIs.batch}/${id}/tests`;
    }

    /**
     * Determines if the app is being served on _ANGULAR_DEFAULT and if so,
     * connects to local development servers.
     * If the app is being served on the EC2 instance, it'll use relative paths
     * @param uri string: must only be 'batch', 'batches', 'run'
     */
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
