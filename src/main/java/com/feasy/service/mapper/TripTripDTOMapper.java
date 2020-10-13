package com.feasy.service.mapper;

    import org.mapstruct.Mapper;

    import com.feasy.domain.Trip;
    import com.feasy.service.dto.TripDTO;

/**
 * Mapper Trip - TripDTO
 */
@Mapper
public interface TripTripDTOMapper {

  TripDTO tripToTripDTO(Trip trip);

  Trip tripDTOToTrip(TripDTO tripDTO);

}
