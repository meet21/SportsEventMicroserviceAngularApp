package com.cognizant.playerMicroservice.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

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
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.playerMicroservice.entity.Player;
import com.cognizant.playerMicroservice.service.PlayerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class PlayerControllerTest {
	@Mock
	private PlayerService playerService;
	private Player p;
	private List<Player> pList;

	@InjectMocks
	private PlayerController pController;
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {

		p = new Player(1, "rahul", 35, 9090908, "rahul@123", "Male", "Cricket");
		mockMvc = MockMvcBuilders.standaloneSetup(pController).build();
	}

	@AfterEach
	void tearDown() throws Exception {
		p = null;
	}

	@Test
	void testGetAllPlayers() throws Exception {
		Mockito.when(playerService.getAllPlayers()).thenReturn(pList);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/players").contentType(MediaType.APPLICATION_JSON).content(asJsonString(p)))
				.andDo(MockMvcResultHandlers.print());
		Mockito.verify(playerService).getAllPlayers();
		Mockito.verify(playerService, times(1)).getAllPlayers();
	}

	@Test
	void testAddPlayer() throws Exception {
		Mockito.when(playerService.addPlayer(any())).thenReturn(p);
		mockMvc.perform(post("/players").contentType(MediaType.APPLICATION_JSON).content(asJsonString(p)));
		Mockito.verify(playerService, times(1)).addPlayer(any());
	}

	@Test
	void testDeletePlayer() throws Exception {
		playerService.deletePlayer(p.getPlayerId());
		verify(playerService, times(1)).deletePlayer(p.getPlayerId());
		mockMvc.perform(delete("/players/1").contentType(MediaType.APPLICATION_JSON).content(asJsonString(p)))
				.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
