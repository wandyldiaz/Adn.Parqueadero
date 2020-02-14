package com.example.adnparqueadero.model.domain.repository;

import com.example.adnparqueadero.model.domain.models.VehicleHistoryData;
import com.example.adnparqueadero.model.domain.models.VehicleRegisteredData;

import java.util.List;

public interface ParkingRepository {
    Long getCountVehicleEnteredType(String typeVehicle);

    VehicleRegisteredData getSelect(String licencePlate);

    Long insert(VehicleRegisteredData vehicleRegistered);

    VehicleHistoryData getSelectVehicleEntered(String licencePlate);

    List<VehicleHistoryData> getSelectVehicleEntered();

    Long insert(VehicleHistoryData vehicleHistory);

    int update(VehicleHistoryData vehicleHistory);
}
