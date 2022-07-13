package com.cognizant.playerMicroservice.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.cognizant.playerMicroservice.entity.Player;
import com.cognizant.playerMicroservice.repository.PlayerRepository;

@ExtendWith(MockitoExtension.class)
class PlayerServiceImplTest {
	@Mock
	private PlayerRepository playerRepo;

	@Autowired
	@InjectMocks
	private PlayerServiceImpl playerService;

	private Player p1, p2;
	List<Player> playerList;

	@BeforeEach
	public void setUp() {
		playerList = new ArrayList<>();
		p1 = new Player(1,"rahul",35,9090908,"rahul@123","Male","Cricket");
		p2 = new Player(2,"rohit",36,9090909,"rohit@123","Male","Football");
		playerList.add(p1);
		playerList.add(p2);

	}

	@AfterEach
	public void tearDown() {
		p1 = p2 = null;
		playerList = null;
	}

	@Test
	void testGetAllPlayers() {
		Mockito.when(playerRepo.findAll()).thenReturn(playerList);
		List<Player> pl = playerService.getAllPlayers();
		assertEquals(playerList, pl);
	}

	@Test
	void testAddPlayer() {
		Mockito.when(playerRepo.save(any())).thenReturn(p1);
		playerService.addPlayer(p1);
		verify(playerRepo, times(1)).save(any());
	}

	@Test
	void testDeletePlayer() {
		playerService.deletePlayer(p1.getPlayerId());
		verify(playerRepo,times(1)).deleteById(p1.getPlayerId());
	}

}
