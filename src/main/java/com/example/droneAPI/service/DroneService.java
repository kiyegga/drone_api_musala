package com.example.droneAPI.service;

import com.example.droneAPI.model.Drone;
import com.example.droneAPI.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class DroneService {
    @Autowired
    DroneRepository droneRepository;

    public String registerDrone(Drone drone) {
        droneRepository.save(drone);
        return "Drone successfully added";
    }


    public List<Drone> getIdleDrones() {
        return droneRepository.findIdleDrones();
    }
}
