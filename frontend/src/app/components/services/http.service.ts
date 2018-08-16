import { Injectable } from '@angular/core';
import { Http, Response } from '@angular/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable()
export class HttpService {
    constructor(private http: Http) {}

    sendTestData(data: any, url: string): Observable<any> {
        return this.http.put(url, data);
    }

    getTestData(url: string): Observable<any> {
        return this.http.get(url).pipe(map((response: Response) => {
            return response.json();
        }));
    }
}
