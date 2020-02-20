package com.example.adnparqueadero.DataBuilder;

import com.example.adnparqueadero.model.domain.models.VehicleHistoryData;

public class VehicleHistoryDataBuilder {

    private int idVehicleHistory;
    private String licencePlate;
    private String dateEntry;
    private String timeEntry;
    private String dateExit;
    private String timeExit;
    private int hoursParked;
    private int amountCharged;

    public VehicleHistoryDataBuilder() {
        idVehicleHistory = 0;
        licencePlate = "HGG323";
        dateEntry = "2020/02/06";
        timeEntry = "06:43";
        dateExit = "";
        timeExit = "";
        hoursParked = 0;
        amountCharged = 0;
    }

    public void withIdVehicleHistory(int idVehicleHistory) {
        this.idVehicleHistory = idVehicleHistory;
    }

    public void withLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public void withDateEntry(String dateEntry) {
        this.dateEntry = dateEntry;
    }

    public void withTimeEntry(String timeEntry) {
        this.timeEntry = timeEntry;
    }

    public void withDateExit(String dateExit) {
        this.dateExit = dateExit;
    }

    public void withTimeExit(String timeExit) {
        this.timeExit = timeExit;
    }

    public void withHoursParked(int hoursParked) {
        this.hoursParked = hoursParked;
    }

    public void whithAmountCharged(int amountCharged) {
        this.amountCharged = amountCharged;
    }

    public VehicleHistoryData build() {
        VehicleHistoryData vehicleHistoryData = new VehicleHistoryData();
        vehicleHistoryData.setAmountCharged(amountCharged);
        vehicleHistoryData.setDateEntry(dateEntry);
        vehicleHistoryData.setDateExit(dateExit);
        vehicleHistoryData.setHoursParked(hoursParked);
        vehicleHistoryData.setIdVehicleHistory(idVehicleHistory);
        vehicleHistoryData.setLicencePlate(licencePlate);
        vehicleHistoryData.setTimeEntry(timeEntry);
        vehicleHistoryData.setDateExit(timeExit);
        return vehicleHistoryData;
    }
}
