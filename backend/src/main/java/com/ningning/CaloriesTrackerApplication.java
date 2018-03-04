package com.ningning;

import com.ningning.auth.User;
import com.ningning.auth.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CaloriesTrackerApplication{

	public static void main(String[] args) {
		SpringApplication.run(CaloriesTrackerApplication.class, args);
	}


}
