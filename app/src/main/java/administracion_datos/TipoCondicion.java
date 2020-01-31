package administracion_datos;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "TipoCondicion")
public class TipoCondicion {
    @PrimaryKey
    private String condicion;

    public TipoCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getCondicion() {
        return condicion;
    }
}
