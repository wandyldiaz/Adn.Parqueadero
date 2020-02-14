package com.example.adnparqueadero.model.domain.models;

public class VehicleHistoryData {

    private int idVehicleHistory;
    private String licencePlate;
    private String dateEntry;
    private String timeEntry;
    private String dateExit;
    private String timeExit;
    private int hoursParked;
    private int amountCharged;

    public void setIdVehicleHistory(int idVehicleHistory) {
        this.idVehicleHistory = idVehicleHistory;
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

    public int getIdVehicleHistory() {
        return idVehicleHistory;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public String getDateEntry() {
        return dateEntry;
    }

    public String getTimeEntry() {
        return timeEntry;
    }

    public String getDateExit() {
        return dateExit;
    }

    public String getTimeExit() {
        return timeExit;
    }

    public int getHoursParked() {
        return hoursParked;
    }

    public int getAmountCharged() {
        return amountCharged;
    }
}