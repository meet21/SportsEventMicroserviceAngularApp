package com.cognizant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.Model.Users;

public interface RegistrationRepository extends JpaRepository<Users, Integer> {

	// declaring the method as it is not present in jpa by default
	public Users findByEmailId(String email);
	public Users findByEmailIdAndPassword(String email ,String password);
	public Users findByUserName(String username);
}
