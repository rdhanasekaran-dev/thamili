package com.dogood.thamili;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ThamiliApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThamiliApiApplication.class, args);
	}

}
