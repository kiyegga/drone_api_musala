package com.example.droneAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
//    @Pattern(regexp = "[A-Za-z][0-9]", message = "Invalid Input")
    private String medicationName;
    private int medicationWeight;
//    @Pattern(regexp = "[A-Z][0-9]", message = "Invalid Input")
    private String medicationCode;
    private String medicationImage;

    //one to many relationship with DroneActivities table
    @JsonIgnore
    @OneToMany(mappedBy = "medication")
    private List<DroneActivities> droneActivities = new ArrayList<>();

    public Medication(Long Id, String medicationName, int medicationWeight, String medicationCode, String medicationImage) {
        Id = Id;
        this.medicationName = medicationName;
        this.medicationWeight = medicationWeight;
        this.medicationCode = medicationCode;
        this.medicationImage = medicationImage;
    }

}
