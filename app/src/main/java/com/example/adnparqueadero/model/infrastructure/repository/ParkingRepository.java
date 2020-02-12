package com.example.adnparqueadero.model.infrastructure.repository;

import com.example.adnparqueadero.model.domain.models.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.domain.models.dto.VehicleRegisteredData;

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
