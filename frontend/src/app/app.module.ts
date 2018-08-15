import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms';

import { routes } from './routes/routes';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './components/home/home.component';
import { TestsComponent } from './components/tests/tests.component';
import { TestComponent } from './components/test/test.component';
import { CucumberTestComponent } from './components/cucumber-test/cucumber-test.component';
import { NgtestTestComponent } from './components/ngtest-test/ngtest-test.component';
import { StacktracePipe } from './components/stacktrace.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    TestsComponent,
    TestComponent,
    CucumberTestComponent,
    NgtestTestComponent,
    StacktracePipe,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
