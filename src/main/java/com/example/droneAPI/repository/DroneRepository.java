package com.example.droneAPI.repository;

import com.example.droneAPI.model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    @Query(value ="select * from DRONE where DRONE_STATE = 'Idle'", nativeQuery = true)
    List<Drone> findIdleDrones();

    @Query(value ="select distinct * from DRONE where DRONE_SERIAL_NUMBER =:droneSerialNumber", nativeQuery = true)
    Drone getDroneObjBySerialNumber(@Param("droneSerialNumber") String droneSerialNumber);
//
    @Query(value ="SELECT CASE WHEN EXISTS(select * from DRONE where DRONE_SERIAL_NUMBER =:droneSerialNumber)" +
            "THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END", nativeQuery = true)
    boolean findDroneBySerialNumber(@Param("droneSerialNumber") String droneSerialNumber);

    @Query(value ="select DRONE.DRONE_SERIAL_NUMBER, MEDICATION.*, DRONE_ACTIVITIES.CURRENT_STATUS  from DRONE, " +
            "DRONE_ACTIVITIES,MEDICATION  where DRONE.ID =DRONE_ACTIVITIES.DRONE_ID  " +
            "and MEDICATION.ID =DRONE_ACTIVITIES.MEDICATION_ID and DRONE_STATE ='Loaded' and DRONE.DRONE_SERIAL_NUMBER =:droneSerialNumber ", nativeQuery = true)
    Map<String, Object> checkingLoadedMedicationToDrone(@Param("droneSerialNumber") String droneSerialNumber);


}
