import { Component, OnInit } from '@angular/core';
import { TestService } from '../services/test-service.service';
import { TestResult } from '../test-result';

@Component({
    selector: 'app-ngtest-test',
    templateUrl: './ngtest-test.component.html',
    styleUrls: ['./ngtest-test.component.css']
})
export class NgtestTestComponent implements OnInit {

    testResults: TestResult;
    constructor(private testService: TestService) {}

    ngOnInit() {
        this.testResults = this.testService.testNGResults;
    }

}
