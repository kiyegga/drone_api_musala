package com.example.droneAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Timestamp;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class DroneBatteryLevel {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;
    private String serialNumber;
    private double batteryLevel;
    private LocalDateTime timestamp;

  //many to one relationship with drone table
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "droneId", referencedColumnName = "Id")
    private Drone drone;
}
