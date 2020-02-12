package com.example.adnparqueadero.model.datos.database_manager;

import com.example.adnparqueadero.model.datos.database.ParkingDatabase;
import com.example.adnparqueadero.model.datos.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.datos.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.datos.tables.VehicleHistory;
import com.example.adnparqueadero.model.datos.tables.VehicleRegistered;

import java.util.List;

public class ModelQuerys implements  ManagerQuerys {
    private ParkingDatabase parkingDatabase;
    VehicleHistory vehicleHistory;

    public ModelQuerys(ParkingDatabase parkingDatabase) {
        this.parkingDatabase = parkingDatabase;
    }

    @Override
    public Long getCountVehicleEnteredType(String typeVehicle) {
        return parkingDatabase.querysDao().getCountVehicleEnteredType(typeVehicle);
    }

    @Override
    public List<VehicleRegisteredData> getSelect() {
        return parkingDatabase.vehicleRegisteredDao().getSelect();
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
