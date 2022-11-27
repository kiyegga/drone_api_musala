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


    @GetMapping("get-idle-drone")
    public List<Drone> getIdleDrone(){
        return droneService.getIdleDrones();
    }
}
