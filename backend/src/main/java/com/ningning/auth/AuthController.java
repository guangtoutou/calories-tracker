package com.ningning.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

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
	public String register(User user){
		userRepo.save (user);
		return "redirect:/login";
	}

}
