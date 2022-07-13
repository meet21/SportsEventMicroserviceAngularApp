package com.cognizant.sportsEventMicroservice.service;

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

import com.cognizant.sportsEventMicroservice.entity.Event;
import com.cognizant.sportsEventMicroservice.entity.Sports;
import com.cognizant.sportsEventMicroservice.repository.EventRepository;
import com.cognizant.sportsEventMicroservice.repository.SportsRepository;

@ExtendWith(MockitoExtension.class)
class SportsEventServiceImplTest {
	@Mock
	private EventRepository eventRepo;
	@Mock
	private SportsRepository sportsRepo;

	@Autowired
	@InjectMocks
	private SportsEventServiceImpl sportsEventService;
	private Sports sports1;
	private Sports sports2;
	private Event event1;
	private Event event2;
	List<Sports> sportsList;
	List<Event> eventsList;

	@BeforeEach
	public void setUp() {
		// For sports
		sportsList = new ArrayList<>();
		sports1 = new Sports(1001, 14, "Baseball", "Outdoor");
		sports2 = new Sports(1002, 22, "Hockey", "Outdoor");
		sportsList.add(sports1);
		sportsList.add(sports2);

		// For events
		eventsList = new ArrayList<>();
		event1 = new Event(1, "20/07/2022", "CARROM_EURO_CUP", 3, "Carrom");
		event2 = new Event(2, "25/07/2022", "IPL", 1, "Cricket");
		eventsList.add(event1);
		eventsList.add(event2);
	}

	@AfterEach
	public void tearDown() {
		// For sports
		sports1 = sports2 = null;
		sportsList = null;

		// For events
		event1 = event2 = null;
		eventsList = null;
	}

	@Test
	void testGetAllSports() {
		Mockito.when(sportsRepo.findAll()).thenReturn(sportsList);
		List<Sports> sportsList1 = sportsEventService.getAllSports();
		assertEquals(sportsList, sportsList1);
	}

	@Test
	void testAddEvent() {
		Mockito.when(eventRepo.save(any())).thenReturn(event1);
		sportsEventService.addEvent(event1);
		verify(eventRepo, times(1)).save(any());
	}

	@Test
	void testGetAllEvents() {
		Mockito.when(eventRepo.findAll()).thenReturn(eventsList);
		List<Event> eventsList1 = sportsEventService.getAllEvents();
		assertEquals(eventsList, eventsList1);
	}


	@Test
	void testDeleteEvent() {
		sportsEventService.deleteEvent(event1.getEventId());
		verify(eventRepo,times(1)).deleteById(event1.getEventId());
	}

}
