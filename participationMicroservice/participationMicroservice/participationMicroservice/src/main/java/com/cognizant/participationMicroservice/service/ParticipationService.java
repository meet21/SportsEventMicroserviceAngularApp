package com.cognizant.participationMicroservice.service;

import java.util.List;

import com.cognizant.participationMicroservice.entity.Participant;

public interface ParticipationService {
	public List<Participant> getAllParticipations();
	public Participant addParticipation( Participant participant);
	public void updateStatus(long participationId,String status);
	public List<Participant> getParticipantsByStatus(String status);
}
