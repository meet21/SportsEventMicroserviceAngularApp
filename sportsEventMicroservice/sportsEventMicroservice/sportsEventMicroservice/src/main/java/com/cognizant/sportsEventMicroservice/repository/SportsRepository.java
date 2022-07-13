package com.cognizant.sportsEventMicroservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.sportsEventMicroservice.entity.Sports;

public interface SportsRepository extends CrudRepository<Sports, Long> {

}
