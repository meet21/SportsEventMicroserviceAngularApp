package com.cognizant.participationMicroservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.participationMicroservice.entity.Participant;

public interface ParticipationRepository extends CrudRepository<Participant, Long> {

}
