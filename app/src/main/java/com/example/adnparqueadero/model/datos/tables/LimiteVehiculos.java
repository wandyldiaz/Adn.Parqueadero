package com.example.adnparqueadero.model.datos.tables;
import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "LimiteVehiculos")
public class LimiteVehiculos {

    @PrimaryKey
    @NonNull
    private String tipoVehiculo;

    @ColumnInfo(name = "cantidad")
    private int cantidad;

    public LimiteVehiculos(int cantidad, @NonNull String tipoVehiculo) {
        this.cantidad = cantidad>0?cantidad:limiteVehiculosDefault(tipoVehiculo);
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getCantidad() {
        return cantidad;
    }

    @NonNull
    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    private int limiteVehiculosDefault(String tipo){
        if (tipo.equals("Carro")) {
            return 20;
        } else if (tipo.equals("Moto")) {
            return 10;
        }
        return 0;
    }

}
