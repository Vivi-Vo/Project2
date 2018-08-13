import { Routes } from '@angular/router';
import { HomeComponent } from '../components/home/home.component';
import { TestsComponent } from '../components/tests/tests.component';

export const routes: Routes = [
    {
        path: '',
        redirectTo: 'app-home',
        pathMatch: 'full'
    },
    {
        path: 'app-home',
        component: HomeComponent
    },
    {
        path: 'app-tests',
        component: TestsComponent
    }
];


