package model.domain.controler_domain.datos;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TipoCondicion")
public class TipoCondicion {
    @PrimaryKey
    private String tipCondicion;

    public TipoCondicion(String condicion) {
        this.tipCondicion = condicion;
    }

    public String getCondicion() {
        return tipCondicion;
    }
}
