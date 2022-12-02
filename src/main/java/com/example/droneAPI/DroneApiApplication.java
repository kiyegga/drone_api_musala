package com.example.droneAPI;

import com.example.droneAPI.model.Drone;
import com.example.droneAPI.model.DroneActivities;
import com.example.droneAPI.model.Medication;
import com.example.droneAPI.repository.DroneActivityRepository;
import com.example.droneAPI.repository.DroneRepository;
import com.example.droneAPI.repository.MedicationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.persistence.Id;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableScheduling
public class DroneApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(DroneApiApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(DroneRepository droneRepository, MedicationRepository medicationRepository){
		return args -> {

			droneRepository.save(new Drone(1L, "S0000000DR001", "Multi-Rotor Drones", 350, 0.50,"Idle"));
			droneRepository.save(new Drone(2L, "S0000000DR002", "Fixed-Wing Drones", 300, 0.34,"Loaded"));
			droneRepository.save(new Drone(3L, "S0000000DR003", "Single-Rotor Drones", 250, 0.23,"Idle"));
//			medicationRepository.save(new Medication(1L,
//					"Acetaminophen",
//					200,
//					"C000000M001",
//					"ytewytweewuiiie"));
//			medicationRepository.save( new Medication( 2L,
//					"Adderall",
//					300,
//					"C000000M002",
//					"hsjkskalaljk")
//
//			);

		};
	}

}
