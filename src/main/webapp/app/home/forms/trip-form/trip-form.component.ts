import { Component, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { TRANSPORTS } from '../../../shared/constants/form.constant';
import { MatSidenav } from '@angular/material/sidenav';
import { TripService } from '../../../core/trip/trip.service';

@Component({
  selector: 'jhi-trip-form',
  templateUrl: './trip-form.component.html',
})
export class TripFormComponent {
  @Input() sideNavParent!: MatSidenav;
  transports = TRANSPORTS;

  tripForm: FormGroup = this.fb.group({
    departurePlace: ['', Validators.required],
    departureDate: ['', Validators.required],
    departureTime: ['', Validators.required],
    departureZone: ['', Validators.required],
    arrivalPlace: ['', Validators.required],
    arrivalDate: ['', Validators.required],
    arrivalTime: ['', Validators.required],
    arrivalZone: ['', Validators.required],
    cabinCategory: [''],
    marketingFlightId: [''],
    operatorFlightId: [''],
    marketingAirline: [''],
    operatingAirline: [''],
    transportation: [this.transports[0]],
    bookingClass: [''],
    cabinClass: ['', Validators.required]
  })

  constructor(private fb: FormBuilder, private tripService: TripService) {}

  /**
   * Create a trip on submit
   */
  submit(): void {
    this.tripForm.markAsDirty();
    if (this.tripForm.valid) {
      const TRIP = this.tripService.convert(this.tripForm.value);
      this.tripService.createTrip(TRIP).subscribe(() => {
        this.handleSuccessfulCreation();
      });
    }
  }

  /**
   * Handle successful
   * TODO error case
   * proper alert
   * @param obj
   */
  private handleSuccessfulCreation(): void {
    this.sideNavParent.toggle();
    alert('OK')
  }
}
