import { Component, OnInit } from '@angular/core';

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
    private homeTitle = 'Revature Testing Suite';
    pageTitle = this.homeTitle;
    page = 'home';

    constructor() {}

    ngOnInit() {}

    switchPage(page: string) {
        switch (page) {
            case 'home':
                this.page = 'home';
                break;
            case 'tests':
                this.page = 'tests';
                break;
        }
    }

}

enum Pages {
    HOME, TESTS
}
