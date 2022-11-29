package com.example.droneAPI.repository;

import com.example.droneAPI.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    @Query(value ="select * from DRONE where DRONE_STATE = 'Idle'", nativeQuery = true)
    List<Drone> findIdleDrones();

    @Query(value ="select * from DRONE where DRONE_SERIAL_NUMBER =:droneSerialNumber", nativeQuery = true)
    Drone findBatteryCapacityForSpecificDrone(@Param("droneSerialNumber") String droneSerialNumber);
//    Map<String, Object>
   // @Query(value ="select * from DRONE where DRONE_SERIAL_NUMBER =:droneSerialNumber", nativeQuery = true)
    @Query(value ="SELECT CASE WHEN EXISTS(select * from DRONE where DRONE_SERIAL_NUMBER =:droneSerialNumber)" +
            "THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END", nativeQuery = true)
    boolean findDroneBySerialNumber(@Param("droneSerialNumber") String droneSerialNumber);


}
