package com.cognizant.participationMicroservice.controller;

import static org.mockito.Mockito.times;

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
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cognizant.participationMicroservice.entity.Participant;
import com.cognizant.participationMicroservice.service.ParticipationService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
class ParticipationControllerTest {
	@Mock
	private ParticipationService participationService;
	private Participant p;
	private List<Participant> pList;

	@InjectMocks
	private ParticipationController pController;
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		p = new Participant(376, 211, "Rahul", 333, "IPL", 1111, "Cricket", "pending");
		mockMvc = MockMvcBuilders.standaloneSetup(pController).build();
	}

	@AfterEach
	void tearDown() throws Exception {
		p = null;
	}

	@Test
	void testGetAllParticipations() throws Exception {
		Mockito.when(participationService.getAllParticipations()).thenReturn(pList);
		mockMvc.perform(
				MockMvcRequestBuilders.get("/participations").contentType(MediaType.APPLICATION_JSON).content(asJsonString(p)))
				.andDo(MockMvcResultHandlers.print());
		Mockito.verify(participationService).getAllParticipations();
		Mockito.verify(participationService, times(1)).getAllParticipations();
	}

//	@Test
//	void testAddParticipation() throws Exception {
//		Mockito.when(participationService.addParticipation(any())).thenReturn(p);
//		mockMvc.perform(post("/participations").contentType(MediaType.APPLICATION_JSON).content(asJsonString(p)));
//		Mockito.verify(participationService, times(1)).addParticipation(any());
//	}

	
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
