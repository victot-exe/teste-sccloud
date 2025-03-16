package com.victot.SCClouds_Test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ScCloudsTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScCloudsTestApplication.class, args);
	}

}
