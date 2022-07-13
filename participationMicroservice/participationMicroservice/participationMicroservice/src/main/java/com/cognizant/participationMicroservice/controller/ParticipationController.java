package com.cognizant.participationMicroservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.cognizant.participationMicroservice.entity.Participant;
import com.cognizant.participationMicroservice.service.ParticipationService;
import com.cognizant.participationMicroservice.utilModel.Event;
import com.cognizant.participationMicroservice.utilModel.Player;
import com.cognizant.participationMicroservice.utilModel.PlayerResponse;
import com.cognizant.participationMicroservice.utilModel.Sports;
import com.cognizant.participationMicroservice.utilModel.Status;

import io.swagger.annotations.ApiOperation;

@RestController
public class ParticipationController {
	@Autowired
	private ParticipationService ps;
	@Autowired
	private RestTemplate rt;

	@GetMapping("/participations")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Find all participations",notes="Returns a list of all participations")
	public List<Participant> getAllParticipations() {
		return this.ps.getAllParticipations();
	}

	@PostMapping("/participations")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Add Participation",notes="API for adding any new Participant")
	public Participant addParticipation(@RequestBody PlayerResponse playerResponse) {
		Participant participant = new Participant();

		String url_sports = "http://sportsEvent-service/sports";
		String url_events = "http://sportsEvent-service/events";
		String url_player = "http://player-service/players";

		// get all sports
		ResponseEntity<Sports[]> sp = rt.getForEntity(url_sports, Sports[].class);
		Sports[] sports = sp.getBody();

		// get all events
		ResponseEntity<Event[]> ev = rt.getForEntity(url_events, Event[].class);
		Event[] events = ev.getBody();

		Player p = new Player();
		p.setPlayerName(playerResponse.getPlayerName());
		p.setAge(playerResponse.getAge());
		p.setContactNumber(playerResponse.getContactNumber());
		p.setEmail(playerResponse.getEmail());
		p.setGender(playerResponse.getGender());
		p.setSportsName(playerResponse.getSportsName());

		Player player = rt.postForObject(url_player, p, Player.class);

		// set sportsId in participant
		for (Sports s : sports) {
			if (s.getSportsName().equals(playerResponse.getSportsName())) {
				participant.setSportsId(s.getSportsId());
				break;
			}
		}
		// set eventId in participant
		for (Event e : events) {
			if (e.getEventName().equals(playerResponse.getEventName())) {
				participant.setEventId(e.getEventId());
				break;
			}
		}
		// set eventName in participant
		participant.setEventName(playerResponse.getEventName());

		// set sportsName in participant
		participant.setSportsName(playerResponse.getSportsName());

		// set playerName in participant
		participant.setPlayerName(playerResponse.getPlayerName());

		// set playerId in participant
		participant.setPlayerId(player.getPlayerId());

		// set participation status pending by default
		participant.setStatus("pending");

		return this.ps.addParticipation(participant);
	}

	@PutMapping("/participations/{participationId}")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Update any participation",notes="API for updating any Participation")
	public void updateStatus(@RequestBody Status status, @PathVariable long participationId) {
		System.out.println(status.getStatus());
		this.ps.updateStatus(participationId, status.getStatus());
	}

	@GetMapping("/participations/{status}")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Find participation by status",notes="API for getting all participations based on their status")
	public List<Participant> getParticipantsByStatus(@PathVariable String status) {
		return this.ps.getParticipantsByStatus(status);
	}
};
