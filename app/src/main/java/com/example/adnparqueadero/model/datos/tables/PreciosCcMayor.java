package com.example.adnparqueadero.model.datos.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "PreciosCcMayor")
public class PreciosCcMayor {
    @PrimaryKey
    @NonNull
    private int cilindraje;

    @ColumnInfo(name = "precio")
    private int precio;

    @ColumnInfo(name = "tipoVehiculo")
    private String tipoVehiculo;

    public PreciosCcMayor(@NonNull int cilindraje, int precio, String tipoVehiculo) {
        this.cilindraje = cilindraje;
        this.precio = precio;
        this.tipoVehiculo = tipoVehiculo;
    }
    @NonNull
    public int getCilindraje() {
        return cilindraje;
    }

    public int getPrecio() {
        return precio;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }
}
