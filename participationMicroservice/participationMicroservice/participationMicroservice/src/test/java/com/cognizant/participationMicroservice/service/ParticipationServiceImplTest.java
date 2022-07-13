package com.cognizant.participationMicroservice.service;

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

import com.cognizant.participationMicroservice.entity.Participant;
import com.cognizant.participationMicroservice.repository.ParticipationRepository;

@ExtendWith(MockitoExtension.class)
class ParticipationServiceImplTest {

	@Mock
	private ParticipationRepository pRepo;

	@Autowired
	@InjectMocks
	private ParticipationServiceImpl pService;

	private Participant p1, p2;

	List<Participant> pList;

	@BeforeEach
	public void setUp() {
		pList = new ArrayList<>();
		p1 = new Participant(376, 211, "Rahul", 333, "IPL", 1111, "Cricket", "pending");
		p2 = new Participant(376, 212, "Rohit", 334, "FIFA", 1112, "Football", "pending");
		pList.add(p1);
		pList.add(p2);
	}

	@AfterEach
	public void tearDown() {
		p1 = p2 = null;
		pList = null;
	}

	@Test
	void testGetAllParticipations() {
		Mockito.when(pRepo.findAll()).thenReturn(pList);
		List<Participant> pList1 = pService.getAllParticipations();
		assertEquals(pList, pList1);
	}

	@Test
	void testAddParticipation() {
		Mockito.when(pRepo.save(any())).thenReturn(p1);
		pService.addParticipation(p1);
		verify(pRepo, times(1)).save(any());
	}

}
