package com.cognizant.participationMicroservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.participationMicroservice.entity.Participant;
import com.cognizant.participationMicroservice.repository.ParticipationRepository;

@Service
public class ParticipationServiceImpl implements ParticipationService {

	@Autowired
	private ParticipationRepository participationRepo;

	@Override
	public List<Participant> getAllParticipations() {
		return (List<Participant>) this.participationRepo.findAll();
	}

	@Override
	public Participant addParticipation(Participant participant) {
		return this.participationRepo.save(participant);
	}

	@Override
	public void updateStatus(long participationId, String status) {
		Optional<Participant> p = this.participationRepo.findById(participationId);
		Participant participant = p.get();
		participant.setStatus(status);
		this.participationRepo.save(participant);
	}

	@Override
	public List<Participant> getParticipantsByStatus(String status) {
		List<Participant> all = (List<Participant>) this.participationRepo.findAll();
		List<Participant> parByStatus = new ArrayList<>();
		for (Participant p : all) {
			if (p.getStatus().equals(status)) {
				parByStatus.add(p);
			}
		}
		return parByStatus;
	}

}
