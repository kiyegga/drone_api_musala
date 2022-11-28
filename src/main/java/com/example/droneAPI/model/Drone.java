package com.example.droneAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
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
    //one to many relationship with DroneBatteryLevel table
    @JsonIgnore
    @OneToMany(mappedBy = "drone")
    private List<DroneBatteryLevel> droneBatteryLevel = new ArrayList<>();

}
