import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { TestService } from '../services/test-service.service';
import { Router } from '@angular/router';

@Component({
    selector: 'app-home',
    templateUrl: './home.component.html',
    styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
    @Output() testInit = new EventEmitter<any>();

    testURL: string;
    invalidURL: boolean;

    constructor(public testService: TestService, private router: Router) {}

    ngOnInit() {}


    // tslint:disable-next-line:use-life-cycle-interface
    ngOnDestroy(): void {
    }

}
