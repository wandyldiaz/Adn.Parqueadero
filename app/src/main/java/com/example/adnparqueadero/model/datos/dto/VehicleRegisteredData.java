package com.example.adnparqueadero.model.datos.dto;

import androidx.room.ColumnInfo;

public class VehicleRegisteredData {
    @ColumnInfo(name = "licencePlate")
    private String licencePlate;
    @ColumnInfo(name = "typeVehicle")
    private String typeVehicle;
    @ColumnInfo(name = "cylinder")
    private int cylinder;

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public int getCylinder() {
        return cylinder;
    }

    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }
}