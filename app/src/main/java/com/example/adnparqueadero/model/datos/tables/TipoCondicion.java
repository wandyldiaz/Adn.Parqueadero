package com.example.adnparqueadero.model.datos.tables;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TipoCondicion")
public class TipoCondicion {


    @PrimaryKey()
    @NonNull
    private String tipCondicion;

    public TipoCondicion(String tipCondicion) {
        this.tipCondicion = tipCondicion;
    }

    @NonNull
    public String getTipCondicion() {
        return tipCondicion;
    }
}
