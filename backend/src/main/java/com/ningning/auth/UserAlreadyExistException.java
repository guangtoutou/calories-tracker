package com.ningning.auth;

import lombok.Data;

@Data
public class UserAlreadyExistException extends RuntimeException {

	private String username;

	public UserAlreadyExistException (String username){
		this.username = username;
	}
}
