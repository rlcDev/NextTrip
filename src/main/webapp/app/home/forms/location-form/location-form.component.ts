import { Component, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'jhi-location-form',
  templateUrl: './location-form.component.html',
})
export class LocationFormComponent {
  @Input() location!: string;
  @Input() parentForm!: FormGroup;

  constructor() {
  }
}
