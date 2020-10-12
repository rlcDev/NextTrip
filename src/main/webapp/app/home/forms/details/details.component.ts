import { Component, Input } from '@angular/core';
import { FormGroup } from '@angular/forms';

@Component({
  selector: 'jhi-details-form',
  templateUrl: './details.component.html',
})
export class DetailsFormComponent {
  @Input() transports!: string[];
  @Input() parentForm!: FormGroup;

  constructor() {}

}
