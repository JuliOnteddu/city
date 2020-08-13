package com.city;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.city.service.FileReadService;

@SpringBootApplication
public class CityApplication {

	public static void main(String[] args) {
		SpringApplication.run(CityApplication.class, args);
	}
	
	/**
	 * @return FileReadService bean
	 */
	@Bean
	public FileReadService fileReadService() {
		return new FileReadService();
	}
}
