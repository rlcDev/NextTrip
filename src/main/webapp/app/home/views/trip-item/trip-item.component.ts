import { Component, Input } from '@angular/core';
import { Trip } from '../../../shared/objects/trip.objectmodel';

@Component({
  selector: 'jhi-trip-item',
  templateUrl: './trip-item.component.html',
})
export class TripItemComponent {
  @Input() trip!: Trip;
  constructor() { }
}
