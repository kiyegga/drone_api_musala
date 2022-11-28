package com.example.droneAPI.controller;

import com.example.droneAPI.model.Drone;
import com.example.droneAPI.service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class DroneController {
    @Autowired
    DroneService droneService;

    @PostMapping("register-drone")
    public String registerDrone(@RequestBody Drone drone){
        return droneService.registerDrone(drone);

    }

//    registering a drone;
//    loading a drone with medication items;
//    checking loaded medication items for a given drone;
//    checking available drones for loading;
//    check drone battery level for a given drone;


//    @GetMapping("get-idle-drone")
//    public List<Drone> getIdleDrone(){
//        return droneService.getIdleDrones();
//    }
}
