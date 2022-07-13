package com.cognizant.participationMicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Participant {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long participationId;
	private long playerId;
	private String playerName;
	private long eventId;
	private String eventName;
	private long sportsId;
	private String SportsName;
	private String status;

	public Participant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Participant(long participationId, long playerId, String playerName, long eventId, String eventName,
			long sportsId, String sportsName, String status) {
		super();
		this.participationId = participationId;
		this.playerId = playerId;
		this.playerName = playerName;
		this.eventId = eventId;
		this.eventName = eventName;
		this.sportsId = sportsId;
		SportsName = sportsName;
		this.status = status;
	}

	public long getParticipationId() {
		return participationId;
	}

	public void setParticipationId(long participationId) {
		this.participationId = participationId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public long getSportsId() {
		return sportsId;
	}

	public void setSportsId(long sportsId) {
		this.sportsId = sportsId;
	}

	public String getSportsName() {
		return SportsName;
	}

	public void setSportsName(String sportsName) {
		SportsName = sportsName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Participation [participationId=" + participationId + ", playerId=" + playerId + ", playerName="
				+ playerName + ", eventId=" + eventId + ", eventName=" + eventName + ", sportsId=" + sportsId
				+ ", SportsName=" + SportsName + ", status=" + status + "]";
	}

}
