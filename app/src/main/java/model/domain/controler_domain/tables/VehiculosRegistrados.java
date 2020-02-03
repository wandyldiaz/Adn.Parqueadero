package model.domain.controler_domain.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "VehiculosRegistrados")
public class VehiculosRegistrados {
    @PrimaryKey()
    @NonNull
    private String placa;

    @ColumnInfo(name = "tipoVehiculo")
    private String tipoVehiculo;

    @ColumnInfo(name = "cilindrage")
    private String cilindrage;

    public VehiculosRegistrados(String placa, String tipoVehiculo, String cilindrage) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.cilindrage = cilindrage;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public String getCilindrage() {
        return cilindrage;
    }
}
