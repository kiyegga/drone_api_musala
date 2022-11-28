package com.example.droneAPI.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
@Data
public class Medication {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    @Pattern(regexp = "[A-Za-z][0-9]", message = "Invalid Input")
    private String name;
    private double weight;
    @Pattern(regexp = "[A-Z][0-9]", message = "Invalid Input")
    private String code;
    private String image;
    private String delivered;
}
