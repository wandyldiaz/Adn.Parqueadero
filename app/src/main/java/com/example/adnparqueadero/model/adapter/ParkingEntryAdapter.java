package com.example.adnparqueadero.model.adapter;

import com.example.adnparqueadero.model.domain.service.ParkingEntry;
import com.example.adnparqueadero.model.infrastructure.repository.ParkingRepository;
import com.example.adnparqueadero.model.domain.models.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.domain.service.DateTimeParking;

import javax.inject.Inject;

public class ParkingEntryAdapter implements ParkingEntryAdapterInterface {

    private ParkingRepository parkingRepository;

    @Inject
    public ParkingEntryAdapter(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public String VehicleEntry(String licencePlate, int cylinder, String typeVehicle) {
        DateTimeParking dateTimeParking = new DateTimeParking();
        VehicleRegisteredData vehicleRegisteredData=new VehicleRegisteredData();
        vehicleRegisteredData.setLicencePlate(licencePlate);
        vehicleRegisteredData.setCylinder(cylinder);
        vehicleRegisteredData.setTypeVehicle(typeVehicle);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData,dateTimeParking, parkingRepository);
        return parkingEntry.startVehicleEntry();
    }
}
