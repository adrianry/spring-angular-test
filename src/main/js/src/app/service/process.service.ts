import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { catchError, map, tap } from 'rxjs/operators';
import { Process } from '../model/process';

@Injectable()
export class ProcessService {

  private processUrl: string;

  constructor(private http: HttpClient) {
    this.processUrl = 'http://localhost:8080/process';
  }

  public getProcess(id: number): Observable<Process> {
        const url = `${this.processUrl}/${id}`;
        return this.http.get<Process>(url).pipe(
        tap(_ => console.log(`fetched process id=${id}`))
      );
    }

     public listAll(): Observable<Process[]> {
           return this.http.get<Process[]>(this.processUrl).pipe(
           tap(_ => console.log(`fetched all processes`))
         );
      }


  public startProcess(): Observable<Process> {
    return this.http.post<Process>(this.processUrl, "test1");
  }

}
