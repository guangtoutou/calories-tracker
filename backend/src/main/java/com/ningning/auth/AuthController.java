package com.ningning.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Date;
import java.util.Optional;

import static com.ningning.auth.SecurityConstants.*;
import static com.ningning.auth.SecurityConstants.Access_Control_Expose_Headers;
import static com.ningning.auth.SecurityConstants.HEADER_STRING;
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
	public ResponseEntity<ApplicationUser> register(@RequestBody ApplicationUser applicationUser,
													UriComponentsBuilder cmb){
		String username = applicationUser.getUsername();

		//save user, throw exception if user already exist
		if(userRepo.findByUsername(username) != null)
			throw new UserAlreadyExistException(username);
		ApplicationUser user = userRepo.save (applicationUser);

		//generate token and put into response header
		HttpHeaders headers = new HttpHeaders();
		String token = Jwts.builder()
				.setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes())
				.compact();
		headers.add(HEADER_STRING, TOKEN_PREFIX + token);
		headers.add(Access_Control_Expose_Headers,HEADER_STRING);

		return new ResponseEntity<>(user, headers, HttpStatus.OK);
	}

	@ExceptionHandler(UserAlreadyExistException.class)
	@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
	public Error spittleNotFound(UserAlreadyExistException e) {
		String username = e.getUsername();
		return new Error(4, "User " + username + " already exist");
	}
}
