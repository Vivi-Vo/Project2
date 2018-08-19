import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { PassfailPipe } from '../../passfail.pipe';
import { CamelToTitlePipe } from '../../camel-to-title.pipe';
import { DatesPipe } from '../../dates.pipe';
import { StacktraceDirective } from '../../stacktrace.directive';
import { BatchComponent } from './batch.component';
import { ColorService } from '../../services/color.service';
import { URIService } from '../../services/uris.service';
import { HttpService } from '../../services/http.service';
import { TestService } from '../../services/test-service.service';
import { Http } from '@angular/http';

describe('BatchComponent', () => {
    let component: BatchComponent;
    let fixture: ComponentFixture < BatchComponent > ;

    beforeEach(async (() => {
        TestBed.configureTestingModule({
                declarations: [
                    BatchComponent,
                    PassfailPipe,
                    DatesPipe,
                    CamelToTitlePipe,
                    StacktraceDirective,
                ],
                providers: [
                    Http,
                    ColorService,
                    URIService,
                    HttpService,
                    TestService
                ]
            })
            .compileComponents();
    }));

    beforeEach(() => {
        fixture = TestBed.createComponent(BatchComponent);
        component = fixture.componentInstance;
        fixture.detectChanges();
    });

    it('should create', () => {
        expect(component).toBeTruthy();
    });
});
