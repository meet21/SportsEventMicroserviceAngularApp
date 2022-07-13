package com.cognizant.sportsEventMicroservice.service;

import java.util.List;

import com.cognizant.sportsEventMicroservice.entity.Event;
import com.cognizant.sportsEventMicroservice.entity.Sports;

public interface SportsEventService {
	public List<Sports> getAllSports();

	public List<Sports> getSportsByName(String sportsName);

	public Event addEvent(Event event);

	public List<Event> getAllEvents();

	public List<Event> getEventsByName(String eventName);

	public void deleteEvent(long eventId);

}
