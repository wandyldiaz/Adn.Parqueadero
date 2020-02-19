package com.example.adnparqueadero.model.infrastructure.translator;


import com.example.adnparqueadero.model.domain.models.VehicleRegisteredData;
import com.example.adnparqueadero.model.infrastructure.entity.VehicleRegistered;

public class VehicleRegisteredTranslator {

    public VehicleRegistered translate(VehicleRegisteredData vehicleRegisteredData) {
        VehicleRegistered vehicleRegistered = new VehicleRegistered();
        vehicleRegistered.setLicencePlate(vehicleRegisteredData.getLicencePlate());
        vehicleRegistered.setCylinder(vehicleRegisteredData.getCylinder());
        vehicleRegistered.setTypeVehicle(vehicleRegisteredData.getTypeVehicle());
        return vehicleRegistered;
    }

}
