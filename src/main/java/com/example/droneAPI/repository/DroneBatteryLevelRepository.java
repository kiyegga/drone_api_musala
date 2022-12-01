package com.example.droneAPI.repository;

import com.example.droneAPI.model.DroneBatteryLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneBatteryLevelRepository extends JpaRepository<DroneBatteryLevel, Long>{
}
