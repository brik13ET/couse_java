import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from '../environments/environment';
import { AppCookieServiceService } from './app-cookie.service';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(
    private http: HttpClient,
    private cookie: AppCookieServiceService
  ) {
  }

  login  (username: String, password: String): Observable<String>
  {
    return this.http.post<String>(
      `${environment.apiUrl}/user/login`,
      { "username": username, "password": password}
    );
  }

  isLoggedIn(): boolean
  {
    return this.cookie.get('JSESSIONID') == null;
  }

  logout ()
  {

  }

  getAll ()
  {

  }
}
