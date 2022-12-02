package com.example.droneAPI.service;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StatusUpdate {
    private Double droneBatteryCapacity;
    private String droneState;
    private String droneSerialNumber;
}
