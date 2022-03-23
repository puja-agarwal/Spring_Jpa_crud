package com.Ashish.Hire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HireApplication {

	public static void main(String[] args) {
		SpringApplication.run(HireApplication.class, args);
	}

}
