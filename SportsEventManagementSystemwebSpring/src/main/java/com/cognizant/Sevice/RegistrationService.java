package com.cognizant.Sevice;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.Model.Users;
import com.cognizant.Repository.RegistrationRepository;

@Service
public class RegistrationService implements UserDetailsService {

	@Autowired
	private RegistrationRepository repo;

	public Users saveUserToDb(Users user) {

		return repo.save(user);
	}

	public Users fetchUsersByEmailId(String email) {

		return repo.findByEmailId(email);

	}

	public Users fetchUsersByEmailIdAndPassword(String email, String password) {

		return repo.findByEmailIdAndPassword(email,password);
	}
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user =repo.findByUserName(username);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),new ArrayList<>());
	}
	
	

}
