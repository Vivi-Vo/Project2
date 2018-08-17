import { Component, OnInit } from '@angular/core';
import { BatchResult } from '../batch-result';
import { TestService } from '../services/test-service.service';
import { HttpService } from '../services/http.service';
import { URIService } from '../services/uris.service';
import { Response } from '@angular/http';


@Component({
    selector: 'app-testng-test',
    templateUrl: './testng-test.component.html',
    styles: [
        `a { color: #eee; }`,
        `a:hover { color: #aaa; }`
    ]
})
export class TestNGTestComponent implements OnInit {

    loaded = false;
    btnText = 'Show';
    testResults: BatchResult;
    constructor(
        private testService: TestService,
        private httpService: HttpService,
        private uri: URIService
    ) {}

    /**
     * Upon creation, check TestResult service
     * if it exists, display the table, else get the most recent test
     */
    ngOnInit() {
        if (this.testService.batchResults) {
            this.testResults = this.testService.batchResults;
            this.loaded = true;
        } else {
            this.getMostRecentTest();
        }
    }

    /**
     * Toggles the visibility of a stack trace
     * @param index number
     */
    toggleStackTrace(index: number): void {
        this.btnText = this.btnText === 'Show' ? 'Hide' : 'Show';
        this.testResults.tests[index].showStackTrace = !this.testResults.tests[index].showStackTrace;
    }

    getMostRecentTest() {
        this.httpService.getTestData(this.uri.URIs.batches).subscribe(
            (response: Response) => {
                const batchId = response.json();
                this.httpService.getTestData(this.uri.getBatchUri(batchId.BatchId)).subscribe();
            },
            (error) => {
                console.error(error);
            }
        );
    }

    /**
     * Sends data to the server
     */
    sendToServer(testResults: BatchResult) {
        this.httpService.sendTestData(testResults, 'url endpoint').subscribe(
            (response: Response) => console.log(response),
            (error) => console.error(error)
        );
    }
}
