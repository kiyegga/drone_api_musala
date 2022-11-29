package com.example.droneAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Pattern(regexp = "[A-Za-z][0-9]", message = "Invalid Input")
    private String medicationName;
    private double medicationWeight;
    @Pattern(regexp = "[A-Z][0-9]", message = "Invalid Input")
    private String medicationCode;
    private String medicationImage;

    //one to many relationship with DroneActivities table
    @JsonIgnore
    @OneToMany(mappedBy = "medication")
    private List<DroneActivities> droneActivities = new ArrayList<>();
}
