import { Pipe, PipeTransform } from '@angular/core';
import { format } from 'date-fns';

@Pipe({
    name: 'dates'
})
export class DatesPipe implements PipeTransform {

    transform(date: Date): string {
        return format(date, 'MMM D YYYY, hh:mm:ss');
    }

}
