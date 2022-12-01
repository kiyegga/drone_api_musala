package com.example.droneAPI.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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
}
