package com.feasy.service.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * A DTO representing the trip concept
 */
public class TripDTO {

  @NotBlank
  @Size(min = 1, max = 50)
  private String departurePlace;

  @NotBlank
  @Size(min = 1, max = 50)
  private String departureDate;

  @NotBlank
  @Size(min = 1, max = 50)
  private String departureTime;

  @NotBlank
  @Size(min = 1, max = 50)
  private String departureZone;

  @NotBlank
  @Size(min = 1, max = 50)
  private String arrivalPlace;

  @NotBlank
  @Size(min = 1, max = 50)
  private String arrivalDate;

  @NotBlank
  @Size(min = 1, max = 50)
  private String arrivalTime;

  @NotBlank
  @Size(min = 1, max = 50)
  private String arrivalZone;

  @NotBlank
  @Size(min = 1, max = 50)
  private String cabinClass;

  private String cabinCategory;

  private String marketingFlightId;

  private String operatorFlightId;

  private String marketingAirline;

  private String operatingAirline;

  private String transportation;

  private String bookingClass;

  public TripDTO() {
    // empty
  }

  public String getDeparturePlace() {
    return departurePlace;
  }

  public void setDeparturePlace(String departurePlace) {
    this.departurePlace = departurePlace;
  }

  public String getDepartureDate() {
    return departureDate;
  }

  public void setDepartureDate(String departureDate) {
    this.departureDate = departureDate;
  }

  public String getDepartureTime() {
    return departureTime;
  }

  public void setDepartureTime(String departureTime) {
    this.departureTime = departureTime;
  }

  public String getDepartureZone() {
    return departureZone;
  }

  public void setDepartureZone(String departureZone) {
    this.departureZone = departureZone;
  }

  public String getArrivalPlace() {
    return arrivalPlace;
  }

  public void setArrivalPlace(String arrivalPlace) {
    this.arrivalPlace = arrivalPlace;
  }

  public String getArrivalDate() {
    return arrivalDate;
  }

  public void setArrivalDate(String arrivalDate) {
    this.arrivalDate = arrivalDate;
  }

  public String getArrivalTime() {
    return arrivalTime;
  }

  public void setArrivalTime(String arrivalTime) {
    this.arrivalTime = arrivalTime;
  }

  public String getArrivalZone() {
    return arrivalZone;
  }

  public void setArrivalZone(String arrivalZone) {
    this.arrivalZone = arrivalZone;
  }

  public String getCabinClass() {
    return cabinClass;
  }

  public void setCabinClass(String cabinClass) {
    this.cabinClass = cabinClass;
  }

  public String getCabinCategory() {
    return cabinCategory;
  }

  public void setCabinCategory(String cabinCategory) {
    this.cabinCategory = cabinCategory;
  }

  public String getMarketingFlightId() {
    return marketingFlightId;
  }

  public void setMarketingFlightId(String marketingFlightId) {
    this.marketingFlightId = marketingFlightId;
  }

  public String getOperatorFlightId() {
    return operatorFlightId;
  }

  public void setOperatorFlightId(String operatorFlightId) {
    this.operatorFlightId = operatorFlightId;
  }

  public String getMarketingAirline() {
    return marketingAirline;
  }

  public void setMarketingAirline(String marketingAirline) {
    this.marketingAirline = marketingAirline;
  }

  public String getOperatingAirline() {
    return operatingAirline;
  }

  public void setOperatingAirline(String operatingAirline) {
    this.operatingAirline = operatingAirline;
  }

  public String getTransportation() {
    return transportation;
  }

  public void setTransportation(String transportation) {
    this.transportation = transportation;
  }

  public String getBookingClass() {
    return bookingClass;
  }

  public void setBookingClass(String bookingClass) {
    this.bookingClass = bookingClass;
  }

  @Override public String toString() {
    return "TripDTO{" +
        "departurePlace='" + departurePlace + '\'' +
        ", departureDate='" + departureDate + '\'' +
        ", departureTime='" + departureTime + '\'' +
        ", departureZone='" + departureZone + '\'' +
        ", arrivalPlace='" + arrivalPlace + '\'' +
        ", arrivalDate='" + arrivalDate + '\'' +
        ", arrivalTime='" + arrivalTime + '\'' +
        ", arrivalZone='" + arrivalZone + '\'' +
        ", cabinClass='" + cabinClass + '\'' +
        ", cabinCategory='" + cabinCategory + '\'' +
        ", marketingFlightId='" + marketingFlightId + '\'' +
        ", operatorFlightId='" + operatorFlightId + '\'' +
        ", marketingAirline='" + marketingAirline + '\'' +
        ", operatingAirline='" + operatingAirline + '\'' +
        ", transportation='" + transportation + '\'' +
        ", bookingClass='" + bookingClass + '\'' +
        '}';
  }

}
