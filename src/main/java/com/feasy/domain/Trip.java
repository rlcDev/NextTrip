package com.feasy.domain;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

/**
 * A trip
 */
@org.springframework.data.mongodb.core.mapping.Document(collection = "jhi_trip")
public class Trip extends AbstractAuditingEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  @NotNull
  @NotBlank
  @Size(max = 50)
  private String departurePlace;

  @NotNull
  @NotBlank
  @Size(max = 50)
  private String departureDate;

  @NotNull
  @NotBlank
  @Size(max = 50)
  private String departureTime;

  @NotNull
  @NotBlank
  @Size(max = 50)
  private String departureZone;

  @NotNull
  @NotBlank
  @Size(max = 50)
  private String arrivalPlace;

  @NotNull
  @NotBlank
  @Size(max = 50)
  private String arrivalDate;

  @NotNull
  @NotBlank
  @Size(max = 50)
  private String arrivalTime;

  @NotNull
  @NotBlank
  @Size(max = 50)
  private String arrivalZone;

  @NotNull
  @NotBlank
  @Size(max = 50)
  private String cabinClass;

  private String cabinCategory;

  private String marketingFlightId;

  private String operatorFlightId;

  private String marketingAirline;

  private String operatingAirline;

  private String transportation;

  private String bookingClass;

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

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof com.feasy.domain.Trip)) {
      return false;
    }
    return id != null && id.equals(((com.feasy.domain.Trip) o).id);
  }

  @Override
  public int hashCode() {
    return 31;
  }

  @Override public String toString() {
    return "Trip{" +
        ", departurePlace='" + departurePlace + '\'' +
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
