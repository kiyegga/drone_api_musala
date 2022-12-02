package com.example.droneAPI.controller;

import com.example.droneAPI.model.Drone;
import com.example.droneAPI.service.DroneService;
import com.example.droneAPI.service.StatusUpdate;
import com.example.droneAPI.utility.LoadDrone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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


    @GetMapping("check-drone-battery/{droneSerialNumber}")
    public String checkBatteryLevel(@PathVariable String droneSerialNumber ){
        return droneService.checkBatteryLevel(droneSerialNumber);

    }

//    checking loaded medication items for a given drone;
    @GetMapping("medicine-carried-by/{droneSerialNumber}")
    public Map<String, Object> medicalItemOnDrone(@PathVariable String droneSerialNumber ){
        return droneService.getMedicineOnSpecificDrone(droneSerialNumber);
    }

    @PostMapping("update-batter-and-state")
    public Drone updateBatteryAndStatus(@RequestBody StatusUpdate statusUpdate){
         return droneService.updateBatterAndStatus(statusUpdate);
    }
}
