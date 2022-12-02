package com.example.droneAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bind.annotation.This;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Column(length = 100)
    @Size( max = 100, message = "Serial number should not exceed 100 characters")
    private String droneSerialNumber;
    private String droneModel;
    private int droneWeightLimit;
    private Double droneBatteryCapacity;
    private String droneState;
    //one to many relationship with DroneBatteryLevel table
    @JsonIgnore
    @OneToMany(mappedBy = "drone")
    private List<DroneBatteryLevel> droneBatteryLevel = new ArrayList<>();

    //one to many relationship with DroneActivities table
    @JsonIgnore
    @OneToMany(mappedBy = "drone")
    private List<DroneActivities> droneActivities = new ArrayList<>();


    public Drone(long Id, String droneSerialNumber, String droneModel, int droneWeightLimit, double droneBatteryCapacity, String droneState) {
        this.Id = Id;
        this.droneSerialNumber = droneSerialNumber;
        this.droneModel = droneModel;
        this.droneWeightLimit = droneWeightLimit;
        this.droneBatteryCapacity = droneBatteryCapacity;
        this.droneState = droneState;

    }
}
//}
