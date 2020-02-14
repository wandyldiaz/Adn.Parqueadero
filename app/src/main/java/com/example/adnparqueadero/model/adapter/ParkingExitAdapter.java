package com.example.adnparqueadero.model.adapter;


import com.example.adnparqueadero.model.domain.service.ParkingExit;
import com.example.adnparqueadero.model.domain.repository.ParkingRepository;
import com.example.adnparqueadero.model.domain.DateTimeParking;

import javax.inject.Inject;

public class ParkingExitAdapter implements ParkingExitAdapterInterface {

    private ParkingRepository parkingRepository;

    @Inject
    public ParkingExitAdapter(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public String makeExit(String licencePlate) {
        DateTimeParking dateTimeParking =new DateTimeParking();
        ParkingExit parkingExit = new ParkingExit(dateTimeParking.getCurrentDate(),
                dateTimeParking.getCurrentTime(),parkingRepository, licencePlate);
        return parkingExit.startMakeExit();
    }
}
