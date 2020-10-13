export class Trip {
    departurePlace:  string;
    departureDate:  string;
    departureTime:  string;
    departureZone:  string;

    arrivalPlace:  string;
    arrivalDate:  string;
    arrivalTime:  string;
    arrivalZone:  string;

    cabinClass:  string

    cabinCategory?: string;
    marketingFlightId?:  string;
    operatorFlightId?:  string;
    marketingAirline?:  string;
    operatingAirline?:  string;
    transportation?:  string;
    bookingClass?:  string;

    constructor(obj: any) {
      this.departurePlace = obj.departurePlace;
      this.departureDate =  obj.departureDate;
      this.departureTime =  obj.departureTime;
      this.departureZone = obj.departureZone;
      this.arrivalPlace = obj.arrivalPlace;
      this.arrivalDate = obj.arrivalDate;
      this.arrivalTime = obj.arrivalTime;
      this.arrivalZone = obj.arrivalZone;
      this.cabinClass = obj.cabinClass;

      this.cabinCategory = obj?.cabinCategory;
      this.marketingFlightId =  obj?.marketingFlightId;
      this.operatorFlightId = obj?.operatorFlightId;
      this.marketingAirline =  obj?.marketingAirline;
      this.operatingAirline =  obj?.operatingAirline;
      this.transportation = obj?.transportation;
      this.bookingClass = obj?.bookingClass;
    }
}
