package com.example.droneAPI.service;

import com.example.droneAPI.exceptions.RequestNotFoundException;
import com.example.droneAPI.model.Drone;
import com.example.droneAPI.model.Medication;
import com.example.droneAPI.repository.DroneRepository;
import com.example.droneAPI.repository.MedicationRepository;
import com.example.droneAPI.utility.LoadDrone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class DroneService {
    @Autowired
    DroneRepository droneRepository;
    @Autowired
    MedicationRepository medicationRepository;



    public void checkRequired(String checkString){
        if(Objects.isNull(checkString) || "".equals(checkString)){
            throw new RequestNotFoundException("Drone Serial number is required/mandatory");
        }
    }

    public String registerDrone(Drone drone) {
        checkRequired(drone.getDroneSerialNumber());
        if(droneRepository.findDroneBySerialNumber(drone.getDroneSerialNumber())){
         return   "Drone with SerialNumber: "+drone.getDroneSerialNumber()+" already exists";
          //  throw new RequestNotFoundException("Drone with SerialNumber: "+drone.getDroneSerialNumber()+" already exists");
        }
//        Drone drone1 = droneRepository.findDroneBySerialNumber(drone.getDroneSerialNumber());
//        if(drone1.getDroneSerialNumber() != null){
//            return "Drone with SerialNumber "+drone1.getDroneSerialNumber()+" already existss";
//        }

        droneRepository.save(drone);
        return "Drone "+drone.getDroneSerialNumber()+" was added successfully";
    }

    public List<Drone> availableDroneForLoadin() {
        return droneRepository.findIdleDrones();
    }

    public String checkBatteryLevel(String droneSerialNumber) {
        droneRepository.findBatteryCapacityForSpecificDrone(droneSerialNumber);
        Drone batterCapacityObject = droneRepository.findBatteryCapacityForSpecificDrone(droneSerialNumber);
        String bcapacity = String.valueOf(batterCapacityObject.getDroneBatteryCapacity() * 100) ;
        return "Drone "+droneSerialNumber+" has "+bcapacity+"% battery capacity";

    }

    public String loadIdleDrone(LoadDrone loadDrone) {
//        "droneSerialNumber":"S0000000DR001",
//                "medicationName":"dsffssf",
//                "medicationWeight": 400,
//                "medicationCode":"CD0001",
//                "medicationImage":"gdssjsjjsj"
        // System.out.println(droneSerialNumber);
        checkRequired(loadDrone.getDroneSerialNumber());
        if(!droneRepository.findDroneBySerialNumber(loadDrone.getDroneSerialNumber())){
            throw new RequestNotFoundException("Drone with SerialNumber:"+loadDrone.getDroneSerialNumber()+" to be loaded does not exists");
        }
        Medication medication = new Medication();
        medication.setMedicationCode(loadDrone.getMedicationCode());
        medication.setMedicationImage(loadDrone.getMedicationImage());
        medication.setMedicationName(loadDrone.getMedicationName());

        // droneRepository.findDroneBySerialNumber(loadDrone.getDroneSerialNumber());
        //System.out.println("check drone existance " + drone);
        return "";
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
