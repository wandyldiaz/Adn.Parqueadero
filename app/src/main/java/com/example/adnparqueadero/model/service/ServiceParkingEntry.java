package com.example.adnparqueadero.model.service;

import dagger.Component;

@Component
public interface ServiceParkingEntry {
    String VehicleEntry (String licencePlate, int cylinder, String typeVehicle);
}
