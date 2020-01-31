package administracion_datos;

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
