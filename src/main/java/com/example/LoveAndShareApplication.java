package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
//@EnableJpaAuditing(auditorAwareRef = "auditorAware")
@EnableJpaAuditing
public class LoveAndShareApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoveAndShareApplication.class, args);
	}

}
