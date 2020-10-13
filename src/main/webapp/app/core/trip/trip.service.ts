import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { SERVER_API_URL } from 'app/app.constants';
import { Trip } from '../../shared/objects/trip.objectmodel';

@Injectable({ providedIn: 'root' })
export class TripService {

  constructor(private http: HttpClient) { }

  /**
   * Post a new trip
   * @param trip
   * @returns Observable
   */
  createTrip(trip: Trip): Observable<{}> {
    return this.http.post(SERVER_API_URL + 'api/trips', trip);
  }

  /**
   * Retrieve all trips
   * @returns Observable
   */
  retrieveTrips(): Observable<{}> {
    return this.http.get(SERVER_API_URL + 'api/trips');
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
