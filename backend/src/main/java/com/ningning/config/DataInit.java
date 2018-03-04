package com.ningning.config;

import com.ningning.auth.User;
import com.ningning.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class DataInit implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	public void run(String... strings) throws Exception{
		userRepository.save(new User("ni.ningning@gmail.com","123456"));
		userRepository.save(new User("guangtoutou@hotmail.com","123456"));
		userRepository.save(new User("8817625@qq.com","123456"));

	}
}
