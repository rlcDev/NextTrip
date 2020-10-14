package com.feasy.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.feasy.domain.Trip;
import com.feasy.repository.TripRepository;
import com.feasy.service.dto.TripDTO;
import com.feasy.service.mapper.TripTripDTOMapper;
import com.feasy.service.mapper.TripTripDTOMapperImpl;
import com.feasy.web.rest.vm.LoginVM;

/**
 * Service class to manage trips
 */
@Service
public class TripService {

  private final Logger log = LoggerFactory.getLogger(TripService.class);

  private final TripRepository tripRepository;

  private final TripTripDTOMapper tripDTOMapper;

  public TripService(TripRepository tripRepository) {
    this.tripRepository = tripRepository;
    this.tripDTOMapper = new TripTripDTOMapperImpl();
  }

  /**
   * Create a trip
   *
   * @return trip
   */
  public Trip createTrip(TripDTO tripDTO) {
    log.debug("Convert and insert trip" + tripDTO);
    Trip trip = tripDTOMapper.tripDTOToTrip(tripDTO);
    tripRepository.insert(trip);
    return trip;
  }

  /**
   * Retrieve trips
   *
   * @return trips
   */
  public List<TripDTO> getAllTrips() {
    log.debug("getAllTrips: retrieving all trips");
    return convert(tripRepository.findAll());
  }

  /**
   * Convert {@link List<Trip>} to {@link List<TripDTO>}
   *
   * @param trips
   * @return List of TripDTO
   */
  private List<TripDTO> convert(List<Trip> trips) {
    log.debug("Convert trips" + trips);
    List<TripDTO> tripDTOList = new ArrayList<TripDTO>();
    for (Trip trip : trips) {
      tripDTOList.add(tripDTOMapper.tripToTripDTO(trip));
    }
    return tripDTOList;
  }

}
