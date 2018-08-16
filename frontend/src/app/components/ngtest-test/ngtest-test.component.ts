import { Component, OnInit } from '@angular/core';
import { BatchResult } from '../batch-result';
import { TestService } from '../services/test-service.service';

@Component({
    selector: 'app-ngtest-test',
    templateUrl: './ngtest-test.component.html',
    styles: [`.table-danger {background: darkred;}`]
})
export class NgtestTestComponent implements OnInit {

    loaded = false;
    btnText = 'Show';
    testResults: BatchResult;
    constructor(private testService: TestService) {}

    ngOnInit() {
        if (this.testService.batchResults) {
            this.testResults = this.testService.batchResults;
            this.loaded = true;
            console.log(this.testResults);
        }
    }

    toggleStackTrace(index): void {
        this.btnText = this.btnText === 'Show' ? 'Hide' : 'Show';
        this.testResults.tests[index].showStackTrace = !this.testResults.tests[index].showStackTrace;
    }
}
