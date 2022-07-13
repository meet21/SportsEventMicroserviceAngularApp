package com.cognizant.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.Model.AuthRequest;
import com.cognizant.Model.Users;
import com.cognizant.Sevice.RegistrationService;
import com.cognizant.Util.JwtUtil;

import io.swagger.annotations.ApiOperation;

@RestController
@CrossOrigin(origins = "*")
public class RegistrationController {
	@Autowired
	private RegistrationService service;

	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping("/welcome")
	@CrossOrigin(origins = "http://localhost:4200")
	public String display() {
		return "{\"Welcome\":\"Meet\"}";
	}
	
	@PostMapping("/authenticate")
	@CrossOrigin(origins = "http://localhost:4200")
	@ApiOperation(value="Fetch User And Authenticate",notes="Returns the token for every different logins request")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getUserName());
	}

//	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
//	@CrossOrigin(origins = "http://localhost:4200")
//	// this method will be called when user submits the form using Angular ui
//	// User Registration Method
//	public Users registerUser(@RequestBody Users user) throws Exception {
//		String tempEmail = user.getEmailId();
//		// checking if email is duplicate or not
//
//		if (tempEmail != null && !"".equals(tempEmail)) {
//			Users duplicateUser = service.fetchUsersByEmailId(tempEmail);
//			if (duplicateUser != null) {
//				throw new Exception("User with " + tempEmail + " already exists");
//			}
//		}
//		Users userObj = null;
//		userObj = service.saveUserToDb(user);
//		return userObj;
//	}

	// User Login Method
//	@RequestMapping(value = "/Login", method = RequestMethod.POST)
//	@CrossOrigin(origins = "http://localhost:4200")
//	public Users UserLogin(@RequestBody Users user) throws Exception {
//		String tempPassword = user.getPassword();
//		String tempEmail = user.getEmailId();
//		Users userLoginStatus = null;
//		if (tempPassword != null && tempEmail != null) {
//			userLoginStatus = service.fetchUsersByEmailIdAndPassword(tempEmail, tempPassword);
//		}
//		if (userLoginStatus == null) {
//			throw new Exception("The User doesn't exists");
//		}
//		return userLoginStatus;
//	}

}
