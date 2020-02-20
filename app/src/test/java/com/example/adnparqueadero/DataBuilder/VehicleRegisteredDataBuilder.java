package com.example.adnparqueadero.DataBuilder;

import com.example.adnparqueadero.model.domain.models.VehicleRegisteredData;

public class VehicleRegisteredDataBuilder {

    private String licencePlate;
    private String typeVehicle;
    private int cylinder;

    public VehicleRegisteredDataBuilder() {
        typeVehicle = "Carro";
        licencePlate = "HGG323";
        cylinder = 600;
    }

    public void withLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }


    public void withTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public void withCylinder(int cylinder) {
        this.cylinder = cylinder;
    }

    public VehicleRegisteredData build() {
        VehicleRegisteredData vehicleRegisteredData = new VehicleRegisteredData();
        vehicleRegisteredData.setCylinder(cylinder);
        vehicleRegisteredData.setLicencePlate(licencePlate);
        vehicleRegisteredData.setTypeVehicle(typeVehicle);
        return vehicleRegisteredData;


    }
}
