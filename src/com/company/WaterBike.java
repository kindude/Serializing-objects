package com.company;

import java.io.Serializable;

public class WaterBike extends Boat implements Serializable {
    private String type; //Сидячий или Стоячий

    public WaterBike()
    {

        this.setMaxSpeed(150);
        this.setEngineVolume(3.50);
        this.setPower(120);
        this.setqPeople(2);
        this.type = "Сидячий";
        this.setBodyMaterial("Plastic");
        this.setFuelConsumption(4);
        this.setFuelTank(40);

    }
    public WaterBike(float maxSpeed, float engineVolume, String bodyMaterial, int Power, int qPeople)
    {
        this.setMaxSpeed(maxSpeed);
        this.setEngineVolume(engineVolume);
        this.setBodyMaterial(bodyMaterial);
        this.setPower(Power);
        this.setqPeople(qPeople);
    }

    @Override
    public String toString() {
        return "\nWaterBike {" +
                "type='" + type + ", " + " Maximum Speed = " + this.getMaxSpeed() +
                ", Engine Volume = " + this.getEngineVolume() +
                ", Body Material = '" + this.getBodyMaterial() + '\'' +
                ", Power = " + this.getPower() +
                " }";

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
