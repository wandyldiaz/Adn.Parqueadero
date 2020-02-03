package model.domain.controler_domain.datos;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TipoVehiculo")
public class TipoVehiculo {
    @PrimaryKey
    private String vehiculo;

    public TipoVehiculo(String tipoPrecio) {
        this.vehiculo = tipoPrecio;
    }

    public String getTipoVehiculo() {
        return vehiculo;
    }

}
