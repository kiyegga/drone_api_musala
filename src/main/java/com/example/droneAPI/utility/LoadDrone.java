package com.example.droneAPI.utility;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class LoadDrone {
    @NotBlank(message = "Name is mandatory")
    private String droneSerialNumber;
    private String medicationName;
    private int medicationWeight;
    private String medicationCode;
    private String medicationImage;
}
