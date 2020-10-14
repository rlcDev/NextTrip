package com.feasy.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.feasy.domain.Trip;
import com.feasy.repository.TripRepository;
import com.feasy.repository.UserRepository;
import com.feasy.security.SecurityUtils;
import com.feasy.service.dto.TripDTO;
import com.feasy.service.mapper.TripTripDTOMapper;
import com.feasy.service.mapper.TripTripDTOMapperImpl;

/**
 * Service class to manage trips
 */
@Service
public class TripService {

  private final Logger log = LoggerFactory.getLogger(TripService.class);

  private final TripRepository tripRepository;

  private final TripTripDTOMapper tripDTOMapper;

  private final UserRepository userRepository;

  public TripService(TripRepository tripRepository, UserRepository userRepository) {
    this.tripRepository = tripRepository;
    this.userRepository = userRepository;
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
    String userId = getCurrentUserId();
    trip.setUserId(userId);
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
    String currentUserId = getCurrentUserId();
    return convert(tripRepository.findAllByUserId(currentUserId));
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

  /**
   * Get current user id
   *
   * @return user id
   */
  private String getCurrentUserId() {
    log.debug("Get current user id");
    final String[] userId = new String[1];
    SecurityUtils.getCurrentUserLogin()
        .flatMap(userRepository::findOneByLogin)
        .ifPresent(user -> userId[0] = user.getId());

    return userId[0];
  }

}
