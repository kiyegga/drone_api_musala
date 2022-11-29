package com.example.droneAPI.repository;

import com.example.droneAPI.model.DroneActivities;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneActivityRepository extends JpaRepository<DroneActivities, Long> {
}
