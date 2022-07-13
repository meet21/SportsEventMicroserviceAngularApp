package com.cognizant.playerMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.playerMicroservice.entity.Player;
import com.cognizant.playerMicroservice.service.PlayerService;

import io.swagger.annotations.ApiOperation;

@RestController
public class PlayerController {
	@Autowired
	private PlayerService ps;

	@GetMapping("/players")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Find all Players",notes="Returns a list of all players")
	public List<Player> getAllPlayers() {
		return this.ps.getAllPlayers();
	}

	@PostMapping("/players")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Add new Player",notes="API to add a new player")
	public Player addPlayer(@RequestBody Player player) {
		return this.ps.addPlayer(player);
	}

	@DeleteMapping("/players/{playerId}")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Delete player by Id",notes="API for deleting any Player by its Id")
	public void deletePlayer(@PathVariable long playerId) {
		this.ps.deletePlayer(playerId);
	}
}
