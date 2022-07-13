 package com.cognizant.sportsEventMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.sportsEventMicroservice.entity.Event;
import com.cognizant.sportsEventMicroservice.entity.Sports;
import com.cognizant.sportsEventMicroservice.service.SportsEventService;

import io.swagger.annotations.ApiOperation;

@RestController
public class SportsEventController {
	@Autowired
	private SportsEventService ses;

	@GetMapping("/sports")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Find available sports",notes="Returns a list of all available sports")
	public List<Sports> getAllSports() {
		return this.ses.getAllSports();
	}

	@GetMapping("/sports/{sportsName}")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Find sports by name",notes="Returns a list of all sports filtered by sports Name")
	public List<Sports> getSportsByName(@PathVariable String sportsName) {
		return this.ses.getSportsByName(sportsName);
	}

	@GetMapping("/events")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Find available events",notes="Returns a list of all available Events")
	public List<Event> getAllEvents() {
		return this.ses.getAllEvents();
	}

	@PostMapping("/events")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Add event",notes="API for adding any new Event")
	public Event addEvent(@RequestBody Event event) {
		return this.ses.addEvent(event);
	}

	@GetMapping("/events/{eventName}")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Find events by Name",notes="Returns a list of all events filtered by Event Name")
	public List<Event> getEventsByName(@PathVariable String eventName) {
		return this.ses.getEventsByName(eventName);
	}

	@DeleteMapping("/events/{eventId}")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Delete event by Id",notes="API for deleting any Event by its Id")
	public void deleteEvent(@PathVariable String eventId) {
		this.ses.deleteEvent(Integer.parseInt(eventId));
	}

}
