import { Component, OnInit, Input } from '@angular/core';
import { TestMethod } from '../../test-method';
import { BatchResult, BatchID } from '../../batch-result';
import { HttpService } from '../../services/http.service';
import { URIService } from '../../services/uris.service';
import { ColorService } from '../../services/color.service';

@Component({
    selector: 'app-batch',
    templateUrl: './batch.component.html',
    styles: [`.btn-dark { background: #222 }`]
})
export class BatchComponent implements OnInit {

    @Input() batch: BatchID;

    showDetails = false;
    batchId: number;
    tests: TestMethod[] = [];
    selectColor: Function;
    showHide = 'Show';

    constructor(
        private httpService: HttpService,
        private uri: URIService,
        private color: ColorService
    ) {}

    ngOnInit() {
        this.batchId = this.batch.batchID;
        this.selectColor = this.color.selectColor;
    }

    toggleDetails() {
        this.showDetails = !this.showDetails;
        if (this.showDetails) {
            this.showHide = 'Hide';
        } else {
            this.showHide = 'Show';
        }
        if (this.showDetails === true && (!this.tests || this.tests.length === 0)) {
            this.httpService.fetchTestData(this.uri.getBatchUri(this.batchId)).subscribe(
                (response) => {
                    this.tests = this.tests.concat(response);
                },
                (error) => console.log(error)
            );
        }
    }

    toggleStackTrace(index: number) {
        this.tests[index].showStackTrace = !this.tests[index].showStackTrace;
    }
}
