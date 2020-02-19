package com.example.adnparqueadero.model.infrastructure.translator;

import com.example.adnparqueadero.model.domain.models.VehicleHistoryData;
import com.example.adnparqueadero.model.infrastructure.entity.VehicleHistory;

public class VehicleHistoryTranslator {

    public VehicleHistory translate(VehicleHistoryData vehicleHistoryData){
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
