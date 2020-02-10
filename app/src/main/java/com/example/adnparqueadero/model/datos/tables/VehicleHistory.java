package com.example.adnparqueadero.model.datos.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "VehicleHistory")
public class VehicleHistory {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "idVehicleHistory")
    private int idVehicleHistory;

    @ColumnInfo(name = "licencePlate")
    private String licencePlate;

    @ColumnInfo(name = "dateEntry")
    private String dateEntry;

    @ColumnInfo(name = "timeEntry")
    private String timeEntry;

    @ColumnInfo(name = "dateExit")
    private String dateExit;

    @ColumnInfo(name = "timeExit")
    private String timeExit;

    @ColumnInfo(name = "hoursParked")
    private int hoursParked;

    @ColumnInfo(name = "amountCharged")
    private int amountCharged;

    public void setIdVehiculoHistorial(int idVehiculoHistorial) {
        this.idVehicleHistory = idVehiculoHistorial;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public void setDateEntry(String dateEntry) {
        this.dateEntry = dateEntry;
    }

    public void setTimeEntry(String timeEntry) {
        this.timeEntry = timeEntry;
    }

    public void setDateExit(String dateExit) {
        this.dateExit = dateExit;
    }

    public void setTimeExit(String timeExit) {
        this.timeExit = timeExit;
    }

    public void setHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }

    public void setAmountCharged(int amountCharged) {
        this.amountCharged = amountCharged;
    }



}
