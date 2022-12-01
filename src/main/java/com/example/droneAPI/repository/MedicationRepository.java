package com.example.droneAPI.repository;

import com.example.droneAPI.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, Long> {
    @Query(value ="select * from MEDICATION where MEDICATION_CODE =:medicationCode", nativeQuery = true)
    Medication findMedicationByCode(@Param("medicationCode") String medicationCode);

}
