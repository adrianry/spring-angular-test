import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs/Observable';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl);
  }


  public getUser(id: number): Observable<User> {
        const url = `${this.usersUrl}/${id}`;
        return this.http.get<User>(url).pipe(
        tap(_ => console.log(`fetched user id=${id}`))
      );
    }

  public save(user: User) {
    return this.http.post<User>(this.usersUrl, user);
  }

  public update(user: User) {
      return this.http.post<User>(this.usersUrl+"/edit", user);
  }

}
