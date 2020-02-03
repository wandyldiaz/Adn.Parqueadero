package model.domain.controler_domain.datos;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TipoPrecios")
public class TipoPrecios {
    @PrimaryKey
    private String tipoPrecio;

    public TipoPrecios(String tipoPrecio) {
        this.tipoPrecio = tipoPrecio;
    }

    public String getTipoPrecio() {
        return tipoPrecio;
    }
}
