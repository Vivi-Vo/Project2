// MODULES
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

// ROUTES
import { routes } from './routes/routes';

// COMPONENTS
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { TestsComponent } from './components/tests/tests.component';
import { TestNGTestComponent } from './components/testng-test/testng-test.component';
import { HistoryComponent } from './components/history/history.component';
import { BatchComponent } from './components/history/batch/batch.component';

// SERVICES
import { HttpService } from './components/services/http.service';
import { TestService } from './components/services/test-service.service';
import { URIService } from './components/services/uris.service';
import { ColorService } from './components/services/color.service';

import { DatesPipe } from './components/dates.pipe';
import { PassfailPipe } from './components/passfail.pipe';
import { CamelToTitlePipe } from './components/camel-to-title.pipe';

import { StacktraceDirective } from './components/stacktrace.directive';

@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        HomeComponent,
        TestsComponent,
        TestNGTestComponent,
        DatesPipe,
        PassfailPipe,
        CamelToTitlePipe,
        HistoryComponent,
        BatchComponent,
        StacktraceDirective,
    ],
    imports: [
        BrowserModule,
        FormsModule,
        RouterModule.forRoot(routes),
        HttpModule
    ],
    providers: [
        HttpService,
        TestService,
        URIService,
        ColorService
    ],
    bootstrap: [AppComponent]
})
export class AppModule {}
