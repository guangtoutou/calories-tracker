package com.ningning.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AuthController {
	@Autowired
	private UserRepository userRepo;

	@RequestMapping(value = "/register", method = GET)
	public String registerForm(){
		return "registration";
	}

	@RequestMapping(value = "/register", method = POST)
	public String register(ApplicationUser applicationUser){
		userRepo.save (applicationUser);
		return "redirect:/login";
	}

	@PostMapping("/auth")
	public ResponseEntity<String> auth(){
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}

}
