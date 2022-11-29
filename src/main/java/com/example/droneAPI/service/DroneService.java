package com.example.droneAPI.service;

import com.example.droneAPI.model.Drone;
import com.example.droneAPI.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DroneService {
    @Autowired
    DroneRepository droneRepository;

    public String registerDrone(Drone drone) {
        droneRepository.save(drone);
        return "Drone "+drone.getDroneSerialNumber()+" was added successfully";
    }

    public List<Drone> availableDroneForLoadin() {
        return droneRepository.findIdleDrones();
    }

    public String checkBatteryLevel(String droneSerialNumber) {
       // System.out.println(droneSerialNumber);
        droneRepository.findBatteryCapacityForSpecificDrone(droneSerialNumber);
        Drone batterCapacityObject = droneRepository.findBatteryCapacityForSpecificDrone(droneSerialNumber);
        String bcapacity = String.valueOf(batterCapacityObject.getDroneBatteryCapacity() * 100) ;
        return "Drone "+droneSerialNumber+" has "+bcapacity+"% battery capacity";

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
