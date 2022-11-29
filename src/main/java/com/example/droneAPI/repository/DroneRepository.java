package com.example.droneAPI.repository;

import com.example.droneAPI.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    @Query(value ="select * from DRONE where DRONE_STATE = 'Idle'", nativeQuery = true)
    List<Drone> findIdleDrones();

    @Query(value =" select DRONE_SERIAL_NUMBER, DRONE_BATTERY_CAPACITY   from DRONE  where DRONE_SERIAL_NUMBER = 'S0000000DR003'", nativeQuery = true)
    Map<String, Object> findBatteryCapacityForSpecificDrone();


}
