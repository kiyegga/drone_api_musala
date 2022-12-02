package com.example.droneAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.jfr.Timestamp;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
//@Data
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DroneBatteryLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long Id;
//    private String serialNumber;
    private double batteryLevel;
    private LocalDateTime timestamp;
  //many to one relationship with drone table
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "droneId", referencedColumnName = "Id")
    private Drone drone;
}
