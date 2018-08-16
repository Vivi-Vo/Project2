import { Component, OnInit } from '@angular/core';
import { BatchResult } from '../batch-result';
import { TestService } from '../services/test-service.service';

@Component({
    selector: 'app-ngtest-test',
    templateUrl: './ngtest-test.component.html',
    styleUrls: ['./ngtest-test.component.css']
})
export class NgtestTestComponent implements OnInit {

    btnText = 'Show';
    testResults: BatchResult;
    constructor(private testService: TestService) {}

    ngOnInit() {
        if (this.testService.batchResults) {
            this.testResults = this.testService.batchResults;
            console.log(this.testResults);
        }
    }

    toggleStackTrace(index): void {
        this.btnText = this.btnText === 'Show' ? 'Hide' : 'Show';
        this.testResults.testMethods[index].showStackTrace = !this.testResults.testMethods[index].showStackTrace;
    }
}
