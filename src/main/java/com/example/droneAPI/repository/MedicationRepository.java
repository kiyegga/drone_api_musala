package com.example.droneAPI.repository;

import com.example.droneAPI.model.Drone;
import com.example.droneAPI.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {

}
