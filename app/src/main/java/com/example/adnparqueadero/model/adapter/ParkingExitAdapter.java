package com.example.adnparqueadero.model.adapter;


import com.example.adnparqueadero.model.domain.DateTimeInterface;
import com.example.adnparqueadero.model.domain.service.ParkingExit;
import com.example.adnparqueadero.model.domain.repository.ParkingRepository;
import com.example.adnparqueadero.model.domain.DateTimeParking;

import javax.inject.Inject;

public class ParkingExitAdapter implements ParkingExitAdapterInterface {

    private ParkingRepository parkingRepository;
    private DateTimeInterface dateTimeParking;

    @Inject
    public ParkingExitAdapter(ParkingRepository parkingRepository, DateTimeInterface dateTimeParking) {
        this.parkingRepository = parkingRepository;
        this.dateTimeParking = dateTimeParking;
    }

    @Override
    public String makeExit(String licencePlate) {
        ParkingExit parkingExit = new ParkingExit(dateTimeParking.getCurrentDate(),
                dateTimeParking.getCurrentTime(), parkingRepository, licencePlate);
        return parkingExit.startMakeExit();
    }
}
