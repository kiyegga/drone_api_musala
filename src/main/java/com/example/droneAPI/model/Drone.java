package com.example.droneAPI.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(length = 100)
    @Size( max = 100, message = "Serial number should not exceed 100 characters")
    private String serialNumber;
    private String model;
    private int weightLimit;
    private Double batteryCapacity;
    private String state;
//    private List<Medication> medications;

}
