package com.cognizant.playerMicroservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.playerMicroservice.entity.Player;
import com.cognizant.playerMicroservice.repository.PlayerRepository;

@Service
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayerRepository playerRepo;

	@Override
	public List<Player> getAllPlayers() {
		return (List<Player>) this.playerRepo.findAll();
	}

	@Override
	public Player addPlayer(Player player) {
		return this.playerRepo.save(player);
	}

	@Override
	public void deletePlayer(long playerId) {
		this.playerRepo.deleteById(playerId);
	}

}
