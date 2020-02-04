package com.example.adnparqueadero.model.datos.tables;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TipoPrecios")
public class TipoPrecios {
    @PrimaryKey()
    @NonNull
    private String tipoPrecio;

    public TipoPrecios(String tipoPrecio) {
        this.tipoPrecio = tipoPrecio;
    }

    public String getTipoPrecio() {
        return tipoPrecio;
    }
}
