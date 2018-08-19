import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { PassfailPipe } from '../../passfail.pipe';
import { CamelToTitlePipe } from '../../camel-to-title.pipe';
import { DatesPipe } from '../../dates.pipe';
import { StacktraceDirective } from '../../stacktrace.directive';
import { BatchComponent } from './batch.component';

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
                    StacktraceDirective
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
