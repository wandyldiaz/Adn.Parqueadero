package com.example.adnparqueadero.model.data.database_manager;

import com.example.adnparqueadero.model.data.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.data.dto.VehicleRegisteredData;

import java.util.List;

public interface ManagerQuery {
    Long getCountVehicleEnteredType(String typeVehicle);

    VehicleRegisteredData getSelect(String licencePlate);

    Long insert(VehicleRegisteredData vehicleRegisteredData);

    VehicleHistoryData getSelectVehicleEntered(String licencePlate);

    List<VehicleHistoryData> getSelectVehicleEntered();

    Long insert(VehicleHistoryData vehicleHistoryData);

    int update(VehicleHistoryData vehicleHistoryData);
}
