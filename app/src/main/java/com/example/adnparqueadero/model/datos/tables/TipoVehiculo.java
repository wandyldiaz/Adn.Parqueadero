package com.example.adnparqueadero.model.datos.tables;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TipoVehiculo")
public class TipoVehiculo {
    @PrimaryKey()
    @NonNull
    private String vehiculo;

    public TipoVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getVehiculo() {
        return vehiculo;
    }

}
