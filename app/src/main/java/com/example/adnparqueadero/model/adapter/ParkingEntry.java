package com.example.adnparqueadero.model.adapter;

import dagger.Component;

@Component
public interface ParkingEntry {
    String VehicleEntry (String licencePlate, int cylinder, String typeVehicle);
}
