package com.example.adnparqueadero.model.adapter;

import com.example.adnparqueadero.model.infrastructure.repository.ParkingRepository;
import com.example.adnparqueadero.model.domain.models.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.domain.service.DateTimeParking;

public class ParkingEntryAdapter implements ParkingEntry {
    private ParkingRepository parkingRepository;

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
        com.example.adnparqueadero.model.domain.service.ParkingEntry parkingEntry = new com.example.adnparqueadero.model.domain.service.ParkingEntry(vehicleRegisteredData,dateTimeParking, parkingRepository);
        return parkingEntry.StartVehicleEntry();
    }
}
