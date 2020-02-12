package com.example.adnparqueadero.model.datos.database_manager;

import com.example.adnparqueadero.model.datos.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.datos.dto.VehicleRegisteredData;

import java.util.List;

public interface ManagerQuerys {
    Long getCountVehicleEnteredType(String typeVehicle);

    List<VehicleRegisteredData> getSelect();

    VehicleRegisteredData getSelect(String licencePlate);

    Long insert(VehicleRegisteredData vehicleRegisteredData);

    VehicleHistoryData getSelectVehicleEntered(String licencePlate);

    List<VehicleHistoryData> getSelectVehicleEntered();

    Long insert(VehicleHistoryData vehicleHistoryData);

    int update(VehicleHistoryData vehicleHistoryData);
}
