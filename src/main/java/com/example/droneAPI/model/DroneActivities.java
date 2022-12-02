package com.example.droneAPI.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class DroneActivities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String currentStatus;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "droneId", referencedColumnName = "Id")
    private Drone drone;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicationId", referencedColumnName = "Id")
    private Medication medication;

    public DroneActivities(long Id, String currentStatus, Drone drone, Medication medication) {
        Id = Id;
        this.currentStatus = currentStatus;
        this.drone = drone;
        this.medication = medication;
    }

    public DroneActivities(Long id, String currentStatus, Drone drone, Medication medication) {
        Id = id;
        this.currentStatus = currentStatus;
        this.drone = drone;
        this.medication = medication;
    }
}
