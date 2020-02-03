package model.domain.controler_domain.datos;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "LimiteVehiculos")
public class LimiteVehiculos {

    @PrimaryKey(autoGenerate = true)
    private int idLimiteVehiculos;

    @ColumnInfo(name = "cantidad")
    private int cantidad;

    @ColumnInfo(name = "tipoVehiculo")
    private String tipoVehiculo;

    public LimiteVehiculos(int idLimiteVehiculos, int cantidad, String tipoVehiculo) {
        this.idLimiteVehiculos = idLimiteVehiculos;
        this.cantidad = cantidad;
        this.tipoVehiculo = tipoVehiculo;
    }

    public int getIdLimiteVehiculos() {
        return idLimiteVehiculos;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }
}
