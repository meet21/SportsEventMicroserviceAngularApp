package com.cognizant.sportsEventMicroservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.sportsEventMicroservice.entity.Event;

public interface EventRepository extends CrudRepository<Event, Long> {
}
