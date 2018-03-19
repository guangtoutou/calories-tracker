package com.ningning.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class AuthController {
	@Autowired
	private UserRepository userRepo;

	@RequestMapping(value = "/register", method = GET)
	public String registerForm(){
		return "registration";
	}

	@RequestMapping(value = "/register", method = POST)
	public ResponseEntity<ApplicationUser> register(@RequestBody ApplicationUser applicationUser){

		if (userRepo.findByUsername(applicationUser.getUsername())!=null)
			throw new UsernameNotFoundException("user already exists");
		ApplicationUser user = Optional.ofNullable(userRepo.save (applicationUser))
				.orElseThrow(() -> new UsernameNotFoundException("user not found"));
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
}
