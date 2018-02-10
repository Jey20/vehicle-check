package com.digital.skills.challenge.domain;

public class VehicleDetails {

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    private String registrationNumber;
    private String colour;
    private String make;

    @Override
    public String toString() {
        return "VehicleDetails{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", colour='" + colour + '\'' +
                ", make='" + make + '\'' +
                '}';
    }
}
