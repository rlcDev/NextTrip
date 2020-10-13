package com.feasy.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.feasy.domain.Trip;
import com.feasy.repository.TripRepository;
import com.feasy.service.TripService;
import com.feasy.service.dto.TripDTO;
import io.github.jhipster.web.util.HeaderUtil;

/**
 * REST controller for managing trips
 */
@RestController
@RequestMapping("/api")
public class TripResource {

  private final Logger log = LoggerFactory.getLogger(TripResource.class);

  @Value("${jhipster.clientApp.name}")
  private String applicationName;

  private final TripRepository tripRepository;

  private final TripService tripService;

  public TripResource(TripService tripService, TripRepository tripRepository) {
    this.tripRepository = tripRepository;
    this.tripService = tripService;
  }

  @PostMapping("/trips")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<Trip> createTrip(@Valid @RequestBody TripDTO tripDTO) throws URISyntaxException {
    log.debug("REST request to save a trip : {}", tripDTO);
    Trip newTrip = tripService.createTrip(tripDTO);
    return ResponseEntity.created(new URI("api/trips"))
        .headers(HeaderUtil.createAlert(applicationName, "trip created", ""))
        .body(newTrip);
  }

  /**
   * {@code GET /trips}: get all trips
   *
   * @return the {@link ResponseEntity} with status {@code 200} and with body all trips
   */
  @GetMapping("/trips")
  @PreAuthorize("isAuthenticated()")
  public ResponseEntity<List<TripDTO>> getAllTrips() {
    log.debug("REST request to get all trips");
    final List<TripDTO> trips = tripService.getAllTrips();
    return new ResponseEntity<List<TripDTO>>(trips, HttpStatus.OK);
  }

}
