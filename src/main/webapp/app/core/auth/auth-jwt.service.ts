import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { LocalStorageService, SessionStorageService } from 'ngx-webstorage';

import { SERVER_API_URL } from 'app/app.constants';
import { Login } from 'app/core/login/login.model';
import { Trip } from '../../shared/objects/trip.objectmodel';

type JwtToken = {
  id_token: string;
};

@Injectable({ providedIn: 'root' })
export class AuthServerProvider {
  constructor(private http: HttpClient, private $localStorage: LocalStorageService, private $sessionStorage: SessionStorageService) {}

  getToken(): string {
    return this.$localStorage.retrieve('authenticationToken') || this.$sessionStorage.retrieve('authenticationToken') || '';
  }

  login(credentials: Login): Observable<void> {
    return this.http
      .post<JwtToken>(SERVER_API_URL + 'api/authenticate', credentials)
      .pipe(map(response => this.authenticateSuccess(response, credentials.rememberMe)));
  }

  /**
   *
   * @param trip
   */
  createTrip(trip: Trip): Observable<void> {
    return this.http
      .post<string>(SERVER_API_URL + 'api/createTrip', { trip: trip, token: this.getAuthenticationToken()})
      .pipe(map(response => this.createTripSuccess(response)));
  }

  logout(): Observable<void> {
    return new Observable(observer => {
      this.$localStorage.clear('authenticationToken');
      this.$sessionStorage.clear('authenticationToken');
      observer.complete();
    });
  }

  private authenticateSuccess(response: JwtToken, rememberMe: boolean): void {
    const jwt = response.id_token;
    if (rememberMe) {
      this.$localStorage.store('authenticationToken', jwt);
    } else {
      this.$sessionStorage.store('authenticationToken', jwt);
    }
  }

  /**
   * Success trip call handler
   * @param response
   */
  private createTripSuccess(response: string): void {

  }

  /**
   * Get Authentication token
   * @returns Authentication token
   */
  private getAuthenticationToken(): string {
    return this.$localStorage.retrieve('authenticationToken');
  }
}
