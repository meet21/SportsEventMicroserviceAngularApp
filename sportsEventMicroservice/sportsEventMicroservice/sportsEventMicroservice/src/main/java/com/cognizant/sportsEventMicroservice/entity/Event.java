package com.cognizant.sportsEventMicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eventId;
	private String eventDate;
	private String eventName;
	private int noOfSlots;
	private String sportsName;

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Event(long eventId, String eventDate, String eventName, int noOfSlots, String sportsName) {
		super();
		this.eventId = eventId;
		this.eventDate = eventDate;
		this.eventName = eventName;
		this.noOfSlots = noOfSlots;
		this.sportsName = sportsName;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getEventDate() {
		return eventDate;
	}

	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public int getNoOfSlots() {
		return noOfSlots;
	}

	public void setNoOfSlots(int noOfSlots) {
		this.noOfSlots = noOfSlots;
	}

	public String getSportsName() {
		return sportsName;
	}

	public void setSportsName(String sportsName) {
		this.sportsName = sportsName;
	}

	@Override
	public String toString() {
		return "Event [eventId=" + eventId + ", eventDate=" + eventDate + ", eventName=" + eventName + ", noOfSlots="
				+ noOfSlots + ", sportsName=" + sportsName + "]";
	}

}
