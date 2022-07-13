package com.cognizant.sportsEventMicroservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.sportsEventMicroservice.entity.Event;
import com.cognizant.sportsEventMicroservice.entity.Sports;
import com.cognizant.sportsEventMicroservice.repository.EventRepository;
import com.cognizant.sportsEventMicroservice.repository.SportsRepository;

@Service
public class SportsEventServiceImpl implements SportsEventService {

	@Autowired
	private EventRepository eventRepo;
	@Autowired
	private SportsRepository sportsRepo;

	@Override
	public List<Sports> getAllSports() {
		return (List<Sports>) this.sportsRepo.findAll();
	}

	@Override
	public List<Sports> getSportsByName(String sportsName) {
		List<Sports> list = (List<Sports>) this.sportsRepo.findAll();
		List<Sports> temp = new ArrayList<>();
		for (Sports s : list) {
			if (s.getSportsName().equals(sportsName)) {
				temp.add(s);
			}
		}
		return temp;
	}

	@Override
	public Event addEvent(Event event) {
		return this.eventRepo.save(event);
	}

	@Override
	public List<Event> getAllEvents() {
		System.out.println("dusra");
		return (List<Event>) this.eventRepo.findAll();
	}

	@Override
	public List<Event> getEventsByName(String eventName) {
		List<Event> list = (List<Event>) this.eventRepo.findAll();
		List<Event> temp = new ArrayList<>();
		for (Event s : list) {
			if (s.getEventName().equals(eventName)) {
				temp.add(s);
			}
		}
		return temp;
	}

	@Override
	public void deleteEvent(long eventId) {
		this.eventRepo.deleteById(eventId);
	}
}