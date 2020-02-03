package model.domain.controler_domain.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "VehiculoHistorial")
public class VehiculoHistorial {
    @PrimaryKey(autoGenerate = true)
    private int idVehiculoHistorial;

    @ColumnInfo(name = "placa")
    private String placa;

    @ColumnInfo(name = "fechaEntrada")
    private String fechaEntrada;

    @ColumnInfo(name = "horaEntrada")
    private String horaEntrada;

    @ColumnInfo(name = "fechaSalida")
    private String fechaSalida;

    @ColumnInfo(name = "horaSalida")
    private String horaSalida;

    @ColumnInfo(name = "horasEstacionado")
    private int horasEstacionado;


    @ColumnInfo(name = "valorCobrado")
    private int valorCobrado;

    public VehiculoHistorial(int idVehiculoHistorial, String placa, String fechaEntrada,
                             String horaEntrada, String fechaSalida, String horaSalida,
                             int horasEstacionado, int valorCobrado) {
        this.idVehiculoHistorial = idVehiculoHistorial;
        this.placa = placa;
        this.fechaEntrada = fechaEntrada;
        this.horaEntrada = horaEntrada;
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.horasEstacionado = horasEstacionado;
        this.valorCobrado = valorCobrado;
        salida("","",0,0);
    }

    public void salida( String fechaSalida, String horaSalida, int horasEstacionado,
                        int valorCobrado){
        this.fechaSalida = fechaSalida;
        this.horaSalida = horaSalida;
        this.horasEstacionado = horasEstacionado;
        this.valorCobrado = valorCobrado;
    }

    public int getIdVehiculoHistorial() {
        return idVehiculoHistorial;
    }

    public String getPlaca() {
        return placa;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public int getHorasEstacionado() {
        return horasEstacionado;
    }

    public int getValorCobrado() {
        return valorCobrado;
    }
}
