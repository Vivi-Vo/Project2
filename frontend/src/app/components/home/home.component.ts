import { Component, OnInit } from '@angular/core';
import { BatchResult } from '../batch-result';
import { TestService } from '../services/test-service.service';
import { HttpService } from '../services/http.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {

    private testResults: BatchResult;
    loading = false;
    constructor(
        private httpService: HttpService,
        private router: Router,
        private testService: TestService
    ) {}

    ngOnInit() {}
    // POST localhost:3001/run
    onSave() {
        this.httpService.sendTestData(this.testResults, 'https://fake-project-2-db.firebaseio.com/data.json').subscribe(
            (response) => console.log(response),
            (error) => console.log(error)
        );
    }

    onLoad() {
        this.loading = true;
        this.httpService.getTestData('/localhost:3001/run').subscribe(
            (response: BatchResult) => {
                this.testResults = response;
                this.loading = false;
                this.router.navigate(['/tests']);
            },
            (error) => console.log(error)
        );
    }

    // tslint:disable-next-line:use-life-cycle-interface
    ngOnDestroy() {
        this.testService.batchResults = this.testResults;
    }

}
