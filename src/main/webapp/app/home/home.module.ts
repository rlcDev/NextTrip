import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSidenavModule } from '@angular/material/sidenav';
import { NextTripSharedModule } from 'app/shared/shared.module';

import { HOME_ROUTE } from './home.route';

import { HomeComponent } from './home.component';
import { LocationFormComponent } from './forms/location-form/location-form.component';
import { TripFormComponent } from './forms/trip-form/trip-form.component';
import { DetailsFormComponent } from './forms/details/details.component';

@NgModule({
  imports: [
    BrowserAnimationsModule,
    NextTripSharedModule,
    MatSidenavModule,
    ReactiveFormsModule,
    RouterModule.forChild([HOME_ROUTE])
  ],
  declarations: [
    HomeComponent,
    LocationFormComponent,
    TripFormComponent,
    DetailsFormComponent
  ]
})
export class NextTripHomeModule { }
