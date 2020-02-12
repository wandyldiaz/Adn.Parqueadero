package com.example.adnparqueadero.model.adapter;


import dagger.Component;

@Component
public interface ParkingExit {
    String makeExit(String licencePlate);
}
