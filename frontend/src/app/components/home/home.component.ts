import { Component, OnInit, EventEmitter, Output } from '@angular/core';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    @Output() testInit = new EventEmitter<any>();

    testURL: string;
    invalidURL: boolean;
    private urlRegex: RegExp = new RegExp(/[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)/);

    constructor() {}

    ngOnInit() {}

    onSubmitURL() {
        this.invalidURL = this.testURL.match(this.urlRegex) == null;
        this.testInit.emit(this.testURL);
        console.log(this.testURL);    // TODO: run tests
    }

}
