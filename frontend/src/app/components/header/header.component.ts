import { Component, OnInit } from '@angular/core';
import { ThemeService} from '../services/theme.service';

@Component({
    selector: 'app-header',
    templateUrl: './header.component.html',
    styleUrls: []
})
export class HeaderComponent implements OnInit {
    private homeTitle = 'Revature Testing Suite';
    pageTitle = this.homeTitle;
    page = 'home';
    theme = 'Dark';

    constructor(private themeService: ThemeService) {}

    ngOnInit() {}

    /**
     * Switches between page or home to apply appropriate CSS
     * @param page string
     */
    switchPage(page: string) {
        switch (page) {
            case 'home':
                this.page = 'home';
                break;
            case 'tests':
                this.page = 'tests';
                break;
            case 'history':
                this.page = 'history';
        }
    }

    toggleTheme(): void {
        this.theme = this.theme === 'Dark' ? 'Light' : 'Dark';
        this.themeService.theme = this.theme.trim();
    }
}
