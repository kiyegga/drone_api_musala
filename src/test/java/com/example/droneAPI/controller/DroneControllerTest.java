package com.example.droneAPI.controller;

import com.example.droneAPI.model.Drone;
import com.example.droneAPI.repository.DroneBatteryLevelRepository;
import com.example.droneAPI.repository.DroneRepository;
import com.example.droneAPI.repository.MedicationRepository;
import com.example.droneAPI.service.DroneService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@WebMvcTest(DroneController.class)
@AutoConfigureMockMvc()
class DroneControllerTest {

    @MockBean
    DroneController droneController;
    @MockBean
//    @Autowired
    DroneRepository droneRepository;
    @MockBean
    MedicationRepository medicationRepository;
    @MockBean
    DroneService droneService;
    @Autowired
    private MockMvc mockMvc;


    @Test
    void registerDrone() throws Exception {
        Drone drone = new Drone(1l,
                "S0000000DR001",
                "Multi-Rotor Drones",
                350,
                0.35,
                "Idle");
         String result = "Drone registered successfully";

        when(droneController.registerDrone(drone)).thenReturn(result);

               this.mockMvc
               .perform(MockMvcRequestBuilders
                       .post("/api/v1/register-drone")
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(result)

               );
       assertEquals(result, this.droneController.registerDrone(drone));


    }


    @Test
    void loadIdleDrone() {
    }

    @Test
    void availableDroneForLoading() {
    }

    @Test
    void checkBatteryLevel() {
    }

    @Test
    void medicalItemOnDrone() {
    }
}