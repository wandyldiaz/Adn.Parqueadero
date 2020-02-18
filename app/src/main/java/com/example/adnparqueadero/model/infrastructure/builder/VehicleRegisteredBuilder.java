package com.example.adnparqueadero.model.infrastructure.builder;


import com.example.adnparqueadero.model.domain.models.VehicleRegisteredData;
import com.example.adnparqueadero.model.infrastructure.entity.VehicleRegistered;

public class VehicleRegisteredBuilder {
    public VehicleRegistered create(VehicleRegisteredData vehicleRegisteredData){
        VehicleRegistered vehicleRegistered = new VehicleRegistered();
        vehicleRegistered.setLicencePlate(vehicleRegisteredData.getLicencePlate());
        vehicleRegistered.setCylinder(vehicleRegisteredData.getCylinder());
        vehicleRegistered.setTypeVehicle(vehicleRegisteredData.getTypeVehicle());
        return vehicleRegistered;
    }

}
