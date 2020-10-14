package com.feasy.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.feasy.domain.Trip;

/**
 * Spring Data MongoDB repository for the {@link Trip} entity.
 */
@Repository
public interface TripRepository extends MongoRepository<Trip, String> {
  List<Trip> findAllByUserId(String userId);
}
