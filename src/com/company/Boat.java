package com.company;

import java.io.Serializable;
import java.util.logging.Level;

public class Boat implements Serializable {
    private float maxSpeed; // Максимальная скорость
    private double engineVolume; // Объем двигателя
    private String bodyMaterial; // Материал корпуса
    private int Power; //Мощность
    private int qPeople;
    private double fuelTank; //Объем топливного бака
    private double fuelConsumption; //Расход топлива



    public Boat()
    {
        this.maxSpeed = 100;
        this.engineVolume = 5.0;
        this.bodyMaterial = "Metal";
        this.Power = 170;
        this.qPeople = 5;
        this.fuelTank = 70;
        this.fuelConsumption = 8; // на 100 км
    }

    public Boat(float maxSpeed, float engineVolume, String bodyMaterial, int Power, int qPeople, double fuelTank, double fuelConsumption)
    {
        this.maxSpeed = maxSpeed;
        this.engineVolume = engineVolume;
        this.bodyMaterial = bodyMaterial;
        this.Power = Power;
        this.qPeople = qPeople;
        this.fuelConsumption = fuelConsumption;
        this.fuelTank = fuelTank;
    }

    @Override
    public String toString() {
        return "\nBoat{" +
                "Maximum Speed = " + maxSpeed +
                ", Engine Volume = " + engineVolume +
                ", Body Material = '" + bodyMaterial + '\'' +
                ", Power = " + Power +
                " }";
    }

    protected void Drive()
    {
        double distance;
        distance = this.fuelTank/(this.fuelConsumption/100);

        System.out.println("You drove " + distance + " km");
    }

    public double getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(double fuelTank) {
        this.fuelTank = fuelTank;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public int getqPeople() {
        return qPeople;
    }

    public void setqPeople(int qPeople) {
        this.qPeople = qPeople;
    }

    public void setPower(int power) {
        Power = power;
    }

    public int getPower() {
        return Power;
    }

    public void setMaxSpeed(float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public void setBodyMaterial(String bodyMaterial) {
        this.bodyMaterial = bodyMaterial;
    }

    public float getMaxSpeed() {
        return maxSpeed;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public String getBodyMaterial() {
        return bodyMaterial;
    }
}
