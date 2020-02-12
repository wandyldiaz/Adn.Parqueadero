package com.example.adnparqueadero.model.data.database_manager;

import com.example.adnparqueadero.model.data.database.ParkingDatabase;
import com.example.adnparqueadero.model.data.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.data.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.data.database.tables.VehicleHistory;
import com.example.adnparqueadero.model.data.database.tables.VehicleRegistered;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ModelQuery implements ManagerQuery {
    private ParkingDatabase parkingDatabase;
    VehicleHistory vehicleHistory;

    @Inject
    public ModelQuery(ParkingDatabase parkingDatabase) {
        this.parkingDatabase = parkingDatabase;
    }

    @Override
    public Long getCountVehicleEnteredType(String typeVehicle) {
        return parkingDatabase.querysDao().getCountVehicleEnteredType(typeVehicle);
    }

    @Override
    public VehicleRegisteredData getSelect(String licencePlate) {
        return parkingDatabase.vehicleRegisteredDao().getSelect(licencePlate);
    }

    @Override
    public Long insert(VehicleRegisteredData vehicleRegisteredData) {
        VehicleRegistered vehicleRegistered= new VehicleRegistered();
        vehicleRegistered.setTypeVehicle(vehicleRegisteredData.getTypeVehicle());
        vehicleRegistered.setLicencePlate(vehicleRegisteredData.getLicencePlate());
        vehicleRegistered.setCylinder(vehicleRegisteredData.getCylinder());

        return parkingDatabase.vehicleRegisteredDao().insert(vehicleRegistered);
    }

    @Override
    public VehicleHistoryData getSelectVehicleEntered(String licencePlate) {
        return parkingDatabase.vehicleHistoryDao().getSelectVehicleEntered(licencePlate);
    }

    @Override
    public List<VehicleHistoryData> getSelectVehicleEntered() {
        return parkingDatabase.vehicleHistoryDao().getSelectVehicleEntered();
    }

    @Override
    public Long insert(VehicleHistoryData vehicleHistoryData) {
        vehicleHistory = new VehicleHistory();
        vehicleHistory.setIdVehicleHistory(vehicleHistoryData.getIdVehicleHistory());
        vehicleHistory.setLicencePlate(vehicleHistoryData.getLicencePlate());
        vehicleHistory.setDateEntry(vehicleHistoryData.getDateEntry());
        vehicleHistory.setTimeEntry(vehicleHistoryData.getTimeEntry());
        vehicleHistory.setAmountCharged(vehicleHistoryData.getAmountCharged());
        vehicleHistory.setDateExit(vehicleHistoryData.getDateExit());
        vehicleHistory.setTimeExit(vehicleHistoryData.getTimeExit());
        vehicleHistory.setHoursParked(vehicleHistoryData.getHoursParked());
        return parkingDatabase.vehicleHistoryDao().insert(vehicleHistory);
    }

    @Override
    public int update(VehicleHistoryData vehicleHistoryData) {
        vehicleHistory = new VehicleHistory();
        vehicleHistory.setIdVehicleHistory(vehicleHistoryData.getIdVehicleHistory());
        vehicleHistory.setLicencePlate(vehicleHistoryData.getLicencePlate());
        vehicleHistory.setDateEntry(vehicleHistoryData.getDateEntry());
        vehicleHistory.setTimeEntry(vehicleHistoryData.getTimeEntry());
        vehicleHistory.setAmountCharged(vehicleHistoryData.getAmountCharged());
        vehicleHistory.setDateExit(vehicleHistoryData.getDateExit());
        vehicleHistory.setTimeExit(vehicleHistoryData.getTimeExit());
        vehicleHistory.setHoursParked(vehicleHistoryData.getHoursParked());
        return parkingDatabase.vehicleHistoryDao().update(vehicleHistory);
    }

}
