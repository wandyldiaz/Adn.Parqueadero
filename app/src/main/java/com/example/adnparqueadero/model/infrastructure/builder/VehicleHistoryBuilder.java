package com.example.adnparqueadero.model.infrastructure.builder;

import com.example.adnparqueadero.model.domain.models.VehicleHistoryData;
import com.example.adnparqueadero.model.infrastructure.entity.VehicleHistory;

public class VehicleHistoryBuilder {

    public VehicleHistory create(VehicleHistoryData vehicleHistoryData){
        VehicleHistory vehicleHistory = new VehicleHistory();
        vehicleHistory.setIdVehicleHistory(vehicleHistoryData.getIdVehicleHistory());
        vehicleHistory.setLicencePlate(vehicleHistoryData.getLicencePlate());
        vehicleHistory.setDateEntry(vehicleHistoryData.getDateEntry());
        vehicleHistory.setDateExit(vehicleHistoryData.getDateExit());
        vehicleHistory.setTimeEntry(vehicleHistoryData.getTimeEntry());
        vehicleHistory.setTimeExit(vehicleHistoryData.getTimeExit());
        vehicleHistory.setHoursParked(vehicleHistoryData.getHoursParked());
        vehicleHistory.setAmountCharged(vehicleHistoryData.getAmountCharged());
        return vehicleHistory;
    }
}
