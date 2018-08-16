import { Injectable } from '@angular/core';
import { Http, Response, Headers } from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class HttpService {
    constructor(private http: Http) {}

    sendTestData(data: any, url: string): Observable<any> {
        return this.http.put(url, data);
    }

    getTestData(url: string): Observable<any> {
        const headers = new Headers({
            mode: 'cors'
        });
        return this.http.post(url, headers).pipe(map((response: Response) => {
            return response.json();
        }));
    }
}
