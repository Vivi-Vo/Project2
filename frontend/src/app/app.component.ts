import { Component } from '@angular/core';
import { TestService } from './components/services/test-service.service';
import { ThemeService } from './components/services/theme.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styles: [`div { width: 100%; height: 100vh;}`],
    providers: [TestService]
})
export class AppComponent {

    constructor(private themeService: ThemeService) {}
}
