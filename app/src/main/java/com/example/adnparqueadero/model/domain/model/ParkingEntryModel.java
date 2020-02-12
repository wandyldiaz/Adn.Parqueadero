package com.example.adnparqueadero.model.domain.model;

import com.example.adnparqueadero.model.data.database_manager.ManagerQuery;
import com.example.adnparqueadero.model.data.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.domain.controller_domain.DateTimeParking;
import com.example.adnparqueadero.model.domain.controller_domain.ParkingEntry;
import com.example.adnparqueadero.model.service.ServiceParkingEntry;

public class ParkingEntryModel implements ServiceParkingEntry {
    private ManagerQuery managerQuery;

    public ParkingEntryModel(ManagerQuery managerQuery) {
        this.managerQuery = managerQuery;
    }

    @Override
    public String VehicleEntry(String licencePlate, int cylinder, String typeVehicle) {
        DateTimeParking dateTimeParking = new DateTimeParking();
        VehicleRegisteredData vehicleRegisteredData=new VehicleRegisteredData();
        vehicleRegisteredData.setLicencePlate(licencePlate);
        vehicleRegisteredData.setCylinder(cylinder);
        vehicleRegisteredData.setTypeVehicle(typeVehicle);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData,dateTimeParking, managerQuery);
        return parkingEntry.StartVehicleEntry();
    }
}
