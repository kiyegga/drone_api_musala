package com.example.droneAPI;

import com.example.droneAPI.model.Drone;
import com.example.droneAPI.repository.DroneRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DroneApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(DroneRepository droneRepository){
		return args -> {
//			droneRepository.save( new Drone(1,"drone serial", "", 100,20.0,""));
		};
	}

}
