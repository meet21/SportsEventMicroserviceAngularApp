package com.cognizant.playerMicroservice.service;

import java.util.List;

import com.cognizant.playerMicroservice.entity.Player;

public interface PlayerService {
	public List<Player> getAllPlayers();

	public Player addPlayer(Player player);

	public void deletePlayer(long playerId);
}
