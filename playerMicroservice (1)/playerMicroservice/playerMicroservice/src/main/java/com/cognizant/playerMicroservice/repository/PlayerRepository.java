package com.cognizant.playerMicroservice.repository;

import org.springframework.data.repository.CrudRepository;

import com.cognizant.playerMicroservice.entity.Player;

public interface PlayerRepository extends CrudRepository<Player, Long> {

}
