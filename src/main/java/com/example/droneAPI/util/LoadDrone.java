package com.example.droneAPI.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LoadDrone {
    private String droneSerialNumber;
    private String medicationName;
    private int medicationWeight;
    private String medicationCode;
    private String medicationImage;
}
