import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable, Subject } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { Trip } from '../../shared/objects/trip.objectmodel';
import { map } from 'rxjs/operators';

@Injectable({ providedIn: 'root' })
export class TripService {
  public onNewTrip: Subject<boolean>;

  constructor(private http: HttpClient) {
    this.onNewTrip = new Subject<boolean>();
  }

  /**
   * Post a new trip
   * @param trip
   * @returns Observable
   */
  createTrip(trip: Trip): Observable<Trip> {
    return this.http
      .post(SERVER_API_URL + 'api/trips', trip)
      .pipe(
        map(response => (response as Trip))
      );
  }

  /**
   * Retrieve all trips
   * @returns Observable
   */
  retrieveTrips(): Promise<Trip[]> {
    return this.http
      .get(SERVER_API_URL + 'api/trips')
      .pipe(
        map(response => response as Trip[]))
      .toPromise();
  }

  /**
   * Convert obj to trip
   * @param obj
   * @returns trip
   */
  convert(obj: any): Trip {
    return new Trip(obj);
  }
}
