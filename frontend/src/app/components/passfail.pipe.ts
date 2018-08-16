import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'passfail'
})
export class PassfailPipe implements PipeTransform {

  transform(value: number): any {
    if (value === 0) {
        return 'Failed';
    } else {
        return 'Passed';
    }
  }

}
