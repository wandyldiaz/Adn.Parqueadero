package com.example.adnparqueadero.model.infrastructure.factory;


import com.example.adnparqueadero.model.domain.models.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.domain.models.entity.VehicleRegistered;

public class VehicleRegisteredFactory {
    public VehicleRegistered create(VehicleRegisteredData vehicleRegisteredData){
        VehicleRegistered vehicleRegistered = new VehicleRegistered();
        vehicleRegistered.setLicencePlate(vehicleRegisteredData.getLicencePlate());
        vehicleRegistered.setCylinder(vehicleRegisteredData.getCylinder());
        vehicleRegistered.setTypeVehicle(vehicleRegisteredData.getTypeVehicle());
        return vehicleRegistered;
    }

}
