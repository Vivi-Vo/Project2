import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { routes } from './routes/routes';

import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { TestsComponent } from './components/tests/tests.component';
import { TestComponent } from './components/test/test.component';
import { NgtestTestComponent } from './components/ngtest-test/ngtest-test.component';

import { StacktracePipe } from './components/stacktrace.pipe';
import { DatesPipe } from './components/dates.pipe';

import { HttpService } from './components/services/http.service';
import { TestService } from './components/services/test-service.service';

@NgModule({
    declarations: [
        AppComponent,
        HeaderComponent,
        HomeComponent,
        TestsComponent,
        TestComponent,
        NgtestTestComponent,
        StacktracePipe,
        DatesPipe,
    ],
    imports: [
        BrowserModule,
        FormsModule,
        RouterModule.forRoot(routes),
        HttpModule
    ],
    providers: [HttpService, TestService],
    bootstrap: [AppComponent]
})
export class AppModule {}
