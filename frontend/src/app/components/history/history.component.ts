import { Component, OnInit } from '@angular/core';
import { TestService } from '../services/test-service.service';
import { HttpService } from '../services/http.service';
import { URIService } from '../services/uris.service';
import { BatchResult, BatchID } from '../batch-result';
import { Response } from '@angular/http';
import { TestMethod } from '../test-method';

@Component({
    selector: 'app-history',
    templateUrl: './history.component.html',
    styleUrls: ['./history.component.css']
})
export class HistoryComponent implements OnInit {

    loading = true;
    batches: BatchID[] = [];
    tests: TestMethod[] = [];
    constructor(
        private testService: TestService,
        private httpService: HttpService,
        private uri: URIService
    ) {}

    /**
     * Loads all the batches run in history
     */
    loadHistoricalData() {
        const uri = this.uri.getURIRoute('batches');
        this.httpService.fetchTestData(uri).subscribe(
            (response) => {
                this.batches = this.batches.concat(response);
                this.loading = false;
            },
            (error) => console.error(error)
        );
    }

    ngOnInit() {
        this.loadHistoricalData();
    }

}
