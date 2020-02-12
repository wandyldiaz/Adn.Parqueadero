package com.example.adnparqueadero.model.domain.class_abstracts;

public abstract class BusinessModel {
    public static final int priceHourCar =1000;
    public static final int priceHourMotorcycle =500;
    public static final int priceDayCar =8000;
    public static final int priceDayMotorcycle =4000;
    public static final int priceMotorcycleCylinderSurcharge =2000;
    public static final int cylinderMotorcycleSurcharge = 500;
    public static final int limitCar = 20;
    public static final int limitMotorcycle = 10;
    public static final String typeVehicleMotorcycle = "Moto";
    public static final String typeVehicleCar = "Carro";
    public static final String[] daysAllowed =new String[]{"Domingo","Lunes"};
}
