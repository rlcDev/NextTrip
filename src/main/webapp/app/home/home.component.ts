import { Component, OnInit, OnDestroy } from '@angular/core';
import { LoginModalService } from '../core/login/login-modal.service';
import { Subscription } from 'rxjs';
import { AccountService } from '../core/auth/account.service';
import { Account } from 'app/core/user/account.model';
import { TripService } from '../core/trip/trip.service';
import { Trip } from '../shared/objects/trip.objectmodel';

@Component({
  selector: 'jhi-home',
  templateUrl: './home.component.html',
  styleUrls: ['home.scss']
})
export class HomeComponent implements OnInit, OnDestroy {
  account: Account | null = null;
  authSubscription?: Subscription;
  retrieveSubscription?: Subscription;
  newTripSubscription?: Subscription;
  trips: Trip[] = [];
  showSideNav = false;

  constructor(private accountService: AccountService, private loginModalService: LoginModalService,
    private tripService: TripService) { }

  ngOnInit(): void {
    this.authSubscription = this.accountService.getAuthenticationState()
      .subscribe(account =>
        (this.account = account
      )
    );
    this.retrieveSubscription = this.tripService.retrieveTrips()
      .subscribe(_trips =>
      (this.trips = _trips as Trip[])
    );
  }

  ngOnDestroy(): void {
    if (this.authSubscription) {
      this.authSubscription.unsubscribe();
    }
    if (this.retrieveSubscription) {
      this.retrieveSubscription.unsubscribe();
    }
    if (this.newTripSubscription) {
      this.newTripSubscription.unsubscribe();
    }
  }

  isAuthenticated(): boolean {
    return this.accountService.isAuthenticated();
  }

  login(): void {
    this.loginModalService.open();
  }
}

