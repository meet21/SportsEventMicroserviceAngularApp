package com.cognizant.sportsEventMicroservice.controller;

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

import com.cognizant.sportsEventMicroservice.entity.Event;
import com.cognizant.sportsEventMicroservice.entity.Sports;
import com.cognizant.sportsEventMicroservice.service.SportsEventService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class SportsEventControllerTest {
	@Mock
	private SportsEventService sportsEventService;
	private Sports s;
	private List<Sports> sList;
	private Event e;
	private List<Event> eList;

	@InjectMocks
	private SportsEventController sportsEventController;
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		s = new Sports(1001, 14, "Baseball", "Outdoor");
		e = new Event(1, "20/07/2022", "CARROM_EURO_CUP", 3, "Carrom");
		mockMvc = MockMvcBuilders.standaloneSetup(sportsEventController).build();
	}

	@AfterEach
	void tearDown() throws Exception {
		s = null;
		e = null;
	}

	@Test
	void testGetAllSports() throws Exception {
		Mockito.when(sportsEventService.getAllSports()).thenReturn(sList);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/sports").contentType(MediaType.APPLICATION_JSON).content(asJsonString(s)))
				.andDo(MockMvcResultHandlers.print());
		Mockito.verify(sportsEventService).getAllSports();
		Mockito.verify(sportsEventService, times(1)).getAllSports();
	}

	@Test
	void testGetSportsByName() throws Exception {
		Mockito.when(sportsEventService.getSportsByName("Baseball")).thenReturn(sList);
		mockMvc.perform(MockMvcRequestBuilders.get("/sports/Baseball").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(s))).andDo(MockMvcResultHandlers.print());
		Mockito.verify(sportsEventService).getSportsByName("Baseball");
		Mockito.verify(sportsEventService, times(1)).getSportsByName("Baseball");
	}

	@Test
	void testGetAllEvents() throws Exception {
		Mockito.when(sportsEventService.getAllEvents()).thenReturn(eList);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/events").contentType(MediaType.APPLICATION_JSON).content(asJsonString(e)))
				.andDo(MockMvcResultHandlers.print());
		Mockito.verify(sportsEventService).getAllEvents();
		Mockito.verify(sportsEventService, times(1)).getAllEvents();
	}

	@Test
	void testAddEvent() throws Exception {
		Mockito.when(sportsEventService.addEvent(any())).thenReturn(e);
		mockMvc.perform(post("/events").contentType(MediaType.APPLICATION_JSON).content(asJsonString(e)));
		Mockito.verify(sportsEventService, times(1)).addEvent(any());
	}

	@Test
	void testGetEventsByName() throws Exception {
		Mockito.when(sportsEventService.getEventsByName("IPL")).thenReturn(eList);
		mockMvc.perform(MockMvcRequestBuilders.get("/events/IPL").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(s))).andDo(MockMvcResultHandlers.print());
		Mockito.verify(sportsEventService).getEventsByName("IPL");
		Mockito.verify(sportsEventService, times(1)).getEventsByName("IPL");
	}

	@Test
	void testDeleteEvent() throws Exception {
		sportsEventService.deleteEvent(e.getEventId());
		verify(sportsEventService, times(1)).deleteEvent(e.getEventId());
		mockMvc.perform(delete("/events/1").contentType(MediaType.APPLICATION_JSON).content(asJsonString(e)))
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
