import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

import { SERVER_API_URL } from 'app/app.constants';
import { Trip } from '../../shared/objects/trip.objectmodel';
import { AuthServerProvider } from '../auth/auth-jwt.service';


@Injectable({ providedIn: 'root' })
export class TripService {
  constructor(private http: HttpClient, private authServerProvider: AuthServerProvider) { }

  /**
   *
   * @param trip
   */
  createTrip(trip: Trip): Observable<void> {
    return this.http
      .post<string>(SERVER_API_URL + 'api/createTrip', { trip: trip, token: this.authServerProvider.getToken() })
      .pipe(
        map( response =>
          (this.createTripSuccess(response)
        )
      )
    );
  }

  /**
   *
   */
  retrieveTrips(): Observable<void> {
    return this.http
      .post<Trip[]>(SERVER_API_URL + 'api/retrieveTrips', { token: this.authServerProvider.getToken() })
      .pipe(
        map( response =>
          (this.retrieveTripsSuccess(response)
        )
      )
    );
  }

  /**
   *
   * @param obj
   */
  convert(obj: any): Trip {
    return new Trip(obj);
  }

  /**
   * Success trip call success handler
   * @param response
   */
  private createTripSuccess(response: string): void {
  }

  /**
   * Retrieve trips success handler
   */
  private retrieveTripsSuccess(response: Trip[]): void {
    return null;
  }
}
