package com.example.adnparqueadero.model.service;


import dagger.Component;

@Component
public interface ServiceParkingExit {
    String makeExit(String licencePlate);
}
