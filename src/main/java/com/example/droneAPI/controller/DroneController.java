package com.example.droneAPI.controller;

import com.example.droneAPI.model.Drone;
import com.example.droneAPI.service.DroneService;
import com.example.droneAPI.utility.LoadDrone;
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
//        return "drone "+ drone.toString();
       return droneService.registerDrone(drone);

    }

    //    loading a drone with medication items;
    @PostMapping("load-idle-drone")
    public String loadIdleDrone(@RequestBody LoadDrone loadDrone){
        droneService.loadIdleDrone(loadDrone);
     return "body request we received is "+ loadDrone.toString();
    }

    @GetMapping("available-for-loading")
    public List<Drone> availableDroneForLoading(){
        return droneService.availableDroneForLoadin();
    }


    @GetMapping("check-drone-batter/{droneSerialNumber}")
    public String checkBatteryLevel(@PathVariable String droneSerialNumber ){
        return droneService.checkBatteryLevel(droneSerialNumber);

    }

//    checking loaded medication items for a given drone;



//    @GetMapping("get-idle-drone")
//    public List<Drone> getIdleDrone(){
//        return droneService.getIdleDrones();
//    }
}
