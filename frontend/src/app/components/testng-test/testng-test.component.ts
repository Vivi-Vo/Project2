import { Component, OnInit } from '@angular/core';
import { BatchResult } from '../batch-result';
import { TestService } from '../services/test-service.service';
import { HttpService } from '../services/http.service';
import { URIService } from '../services/uris.service';
import { Response } from '@angular/http';
import { ColorService } from '../services/color.service';
import { ThemeService} from '../services/theme.service';


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
    selectColor: Function;

    constructor(
        private testService: TestService,
        private httpService: HttpService,
        private uri: URIService,
        private color: ColorService,
        private themeService: ThemeService,
    ) {}

    /**
     * Upon creation, check TestResult service
     * if it exists, display the table, else get the most recent test
     */
    ngOnInit() {
        this.selectColor = this.color.selectColor;
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
        this.testResults.tests[index].showStackTrace = !this.testResults.tests[index].showStackTrace;
    }

    toggleBtnText(index: number): string {
        return this.testResults.tests[index].showStackTrace === true ?
            'Hide' : 'Show';
    }

    getMostRecentTest() {
        const uri = this.uri.getURIRoute('batch');
        this.httpService.fetchTestData(uri).subscribe(
            (response) => {
                const batchId = response;
                console.log(batchId);
                this.httpService.fetchTestData(this.uri.getBatchUri(batchId.batchId)).subscribe(
                    (testResponse: any) => {
                        this.testResults = testResponse;
                        this.loaded = true;
                    },
                    (error) => console.error(error)
                );
            },
            (error) => {
                console.error(error);
            }
        );
    }

    // tslint:disable-next-line:use-life-cycle-interface
    ngOnDestroy(): void {
        this.testService.batchResults = this.testResults;
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
