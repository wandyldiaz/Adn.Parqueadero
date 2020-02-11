package com.example.adnparqueadero.model.datos.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "VehicleRegistered")
public class VehicleRegistered {
    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "licencePlate")
    private String licencePlate;

    @ColumnInfo(name = "typeVehicle")
    private String typeVehicle;

    @ColumnInfo(name = "cylinder")
    private int cylinder;

    public void setLicencePlate(@NonNull String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public void setTypeVehicle(String typeVehicle) {
        this.typeVehicle = typeVehicle;
    }

    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public String getTypeVehicle() {
        return typeVehicle;
    }

    public int getCylinder() {
        return cylinder;
    }
}
