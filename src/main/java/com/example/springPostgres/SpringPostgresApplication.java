package com.example.springPostgres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@SpringBootApplication
public class SpringPostgresApplication {

	private static final Logger logger = LoggerFactory.getLogger(SpringPostgresApplication.class);

	public static void main(String[] args) {
		logger.info("Hello from Logback");

		SpringApplication.run(SpringPostgresApplication.class, args);
	}

}
