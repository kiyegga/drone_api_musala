package com.example.droneAPI.service;

import com.example.droneAPI.exceptions.RequestNotFoundException;
import com.example.droneAPI.model.Drone;
import com.example.droneAPI.model.DroneActivities;
import com.example.droneAPI.model.DroneBatteryLevel;
import com.example.droneAPI.model.Medication;
import com.example.droneAPI.repository.DroneActivityRepository;
import com.example.droneAPI.repository.DroneBatteryLevelRepository;
import com.example.droneAPI.repository.DroneRepository;
import com.example.droneAPI.repository.MedicationRepository;
import com.example.droneAPI.utility.LoadDrone;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
@Slf4j
@Component
public class DroneService {
    @Autowired
    DroneRepository droneRepository;
    @Autowired
    MedicationRepository medicationRepository;
    @Autowired
    DroneActivityRepository droneActivityRepository;
    @Autowired
    DroneBatteryLevelRepository droneBatteryLevelRepository;



    public void checkRequired(String checkString){
        if(Objects.isNull(checkString) || "".equals(checkString)){
            throw new RequestNotFoundException("Drone Serial number is required/mandatory");
        }
    }

    public String registerDrone(Drone drone) {
        checkRequired(drone.getDroneSerialNumber());
        if(droneRepository.findDroneBySerialNumber(drone.getDroneSerialNumber())){
         return   "Drone with SerialNumber: "+drone.getDroneSerialNumber()+" already exists";
        }
        droneRepository.save(drone);
        return "Drone "+drone.getDroneSerialNumber()+" was added successfully";
    }

    public List<Drone> availableDroneForLoadin() {
        return droneRepository.findIdleDrones();
    }

    public String checkBatteryLevel(String droneSerialNumber) {
        droneRepository.getDroneObjBySerialNumber(droneSerialNumber);
        Drone batterCapacityObject = droneRepository.getDroneObjBySerialNumber(droneSerialNumber);
        String bcapacity = String.valueOf(batterCapacityObject.getDroneBatteryCapacity() * 100) ;
        return "Drone "+droneSerialNumber+" has "+bcapacity+"% battery capacity";

    }

    public String loadIdleDrone(LoadDrone loadDrone) {
        checkRequired(loadDrone.getDroneSerialNumber());
        if(!droneRepository.findDroneBySerialNumber(loadDrone.getDroneSerialNumber())){
            throw new RequestNotFoundException("Drone with SerialNumber:"+loadDrone.getDroneSerialNumber()+" to be loaded does not exists");
        }
        Drone drone = droneRepository.getDroneObjBySerialNumber(loadDrone.getDroneSerialNumber());
      //checking drone battery capacity
        if((drone.getDroneBatteryCapacity() * 100) <= 25){
            return "Drone "+loadDrone.getDroneSerialNumber()+" requires to be charged before being loaded";
        }
        //checking drone weight limit
        if(loadDrone.getMedicationWeight() > drone.getDroneWeightLimit()){
           return "Drone "+loadDrone.getDroneSerialNumber()+" can not weight exceeding "+drone.getDroneWeightLimit();
        }
        //object for medicine to be loaded
        Medication medication = new Medication();
        medication.setMedicationCode(loadDrone.getMedicationCode());
        medication.setMedicationImage(loadDrone.getMedicationImage());
        medication.setMedicationName(loadDrone.getMedicationName());
        medication.setMedicationWeight(loadDrone.getMedicationWeight());
        medicationRepository.save(medication);

        // find medicine by code
        Medication medication1 = medicationRepository.findMedicationByCode(loadDrone.getMedicationCode());
        //set drone activities
        DroneActivities droneActivities = new DroneActivities();
        droneActivities.setDrone(drone);
        droneActivities.setMedication(medication1);
        droneActivities.setCurrentStatus("Loaded");
        droneActivityRepository.save(droneActivities);

        // change drone state under Drone entity
        //change status for both after sometime
        // update batter capacity

        //battery register event



        return "Drone "+loadDrone.getDroneSerialNumber()+" is loaded successfully";
    }




    @Scheduled(fixedRate = 300000)
    public void updateBatteryLevelForAllDrones(){
         List<Drone> drones = droneRepository.findAll();
         List<DroneBatteryLevel> droneBatteryLevels = new ArrayList<>();
         DroneBatteryLevel droneBatteryLevel = new DroneBatteryLevel();
        for (Drone drone1: drones) {
         droneBatteryLevel.setDrone(drone1);
          droneBatteryLevel.setBatteryLevel(drone1.getDroneBatteryCapacity());
          droneBatteryLevels.add(droneBatteryLevel);
          droneBatteryLevel.setTimestamp(LocalDateTime.now());
        }
       droneBatteryLevelRepository.saveAll(droneBatteryLevels);

    }

    public Map<String, Object> getMedicineOnSpecificDrone(String droneSerialNumber) {
      return droneRepository.checkingLoadedMedicationToDrone(droneSerialNumber);
    }

    public Drone updateBatterAndStatus(StatusUpdate statusUpdate) {
        if(Objects.isNull(statusUpdate.getDroneSerialNumber()) || "".equals(statusUpdate.getDroneSerialNumber())){
            throw new RequestNotFoundException("Drone SerialNumber is required");

        }
        if(droneRepository.findDroneBySerialNumber(statusUpdate.getDroneSerialNumber()) == false){
            throw new RequestNotFoundException("Drone with SerialNumber: "+statusUpdate.getDroneSerialNumber()+" does not exists");
        }
        Drone drone2 = droneRepository.getDroneObjBySerialNumber(statusUpdate.getDroneSerialNumber());
        drone2.setDroneState(statusUpdate.getDroneState());
        drone2.setDroneBatteryCapacity(statusUpdate.getDroneBatteryCapacity());

        return droneRepository.save(drone2);
    }


}
