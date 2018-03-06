package com.ningning.config;

import com.ningning.auth.ApplicationUser;
import com.ningning.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
	@Autowired
	private UserRepository userRepository;

	private PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();


	@Override
	public void run(String... strings) throws Exception{
		userRepository.save(new ApplicationUser("ni.ningning@gmail.com",bCryptPasswordEncoder.encode("123456")));
		userRepository.save(new ApplicationUser("guangtoutou@hotmail.com",bCryptPasswordEncoder.encode("123456")));
		userRepository.save(new ApplicationUser("8817625@qq.com",bCryptPasswordEncoder.encode("123456")));

	}
}
