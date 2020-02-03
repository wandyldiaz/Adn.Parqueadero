package model.domain.controler_domain.tables;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Precios")
public class Precios {
    @PrimaryKey(autoGenerate = true)
    private int idPrecios;

    @ColumnInfo(name = "precio")
    private int precio;

    @ColumnInfo(name = "tipoVehiculo")
    private String tipoVehiculo;

    @ColumnInfo(name = "tipoPrecio")
    private String tipoPrecio;

    public Precios(int idPrecios, int precio, String tipoVehiculo, String tipoPrecio) {
        this.idPrecios = idPrecios;
        this.precio = precio;
        this.tipoVehiculo = tipoVehiculo;
        this.tipoPrecio = tipoPrecio;
    }

    public int getIdPrecios() {
        return idPrecios;
    }

    public int getPrecio() {
        return precio;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public String getTipoPrecio() {
        return tipoPrecio;
    }
}
