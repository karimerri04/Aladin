package com.karimerri.aladin_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EntityScan(basePackageClasses = { AladinApiApplication.class, Jsr310Converters.class })
public class AladinApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AladinApiApplication.class, args);
	}

}
