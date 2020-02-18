package com.example.adnparqueadero.model.adapter;

import com.example.adnparqueadero.model.domain.DateTimeInterface;
import com.example.adnparqueadero.model.domain.service.ParkingEntry;
import com.example.adnparqueadero.model.domain.repository.ParkingRepository;
import com.example.adnparqueadero.model.domain.models.VehicleRegisteredData;

import javax.inject.Inject;

public class ParkingEntryAdapter implements ParkingEntryAdapterInterface {

    private ParkingRepository parkingRepository;
    private DateTimeInterface dateTimeParking;

    @Inject
    public ParkingEntryAdapter(ParkingRepository parkingRepository, DateTimeInterface dateTimeParking) {
        this.parkingRepository = parkingRepository;
        this.dateTimeParking = dateTimeParking;
    }

    @Override
    public String vehicleEntry(String licencePlate, int cylinder, String typeVehicle) {
        VehicleRegisteredData vehicleRegisteredData=new VehicleRegisteredData();
        vehicleRegisteredData.setLicencePlate(licencePlate);
        vehicleRegisteredData.setCylinder(cylinder);
        vehicleRegisteredData.setTypeVehicle(typeVehicle);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData, parkingRepository,dateTimeParking);
        return parkingEntry.startVehicleEntry();
    }
}
