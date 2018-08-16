import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
    name: 'stacktrace'
})
export class StacktracePipe implements PipeTransform {

    transform(str: string): string {
        return str.replace(/\sat\s/g, '\n at ');
    }

}
