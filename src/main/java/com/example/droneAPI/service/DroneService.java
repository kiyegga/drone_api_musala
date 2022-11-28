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

//    Functional requirements
//    There is no need for UI;
//    Prevent the drone from being loaded with more weight that it can carry;
//    Prevent the drone from being in LOADING state if the battery level is below 25%;
//    Introduce a periodic task to check drones battery levels and create history/audit event log for this.


//    public List<Drone> getIdleDrones() {
//        return droneRepository.findIdleDrones();
//    }
}
