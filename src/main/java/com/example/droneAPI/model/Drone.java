package com.example.droneAPI.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column( length = 100)
    private String serialNumber;
    private String model;
    private String weightLimit;
    private String batteryCapacity;
    private String state;

}
