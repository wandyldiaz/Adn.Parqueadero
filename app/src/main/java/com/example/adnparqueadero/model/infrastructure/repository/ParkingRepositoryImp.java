package com.example.adnparqueadero.model.infrastructure.repository;

import com.example.adnparqueadero.model.infrastructure.database.ParkingDatabase;
import com.example.adnparqueadero.model.domain.models.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.domain.models.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.infrastructure.factory.VehicleHistoryFactory;
import com.example.adnparqueadero.model.infrastructure.factory.VehicleRegisteredFactory;

import java.util.List;

import javax.inject.Inject;

public class ParkingRepositoryImp implements ParkingRepository {
    private ParkingDatabase parkingDatabase;
    private VehicleHistoryFactory vehicleHistoryFactory = new VehicleHistoryFactory();
    private VehicleRegisteredFactory vehicleRegisteredFactory= new VehicleRegisteredFactory();

    @Inject
    public ParkingRepositoryImp(ParkingDatabase parkingDatabase) {
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
    public Long insert(VehicleRegisteredData vehicleRegistered) {
        return parkingDatabase.vehicleRegisteredDao().insert(vehicleRegisteredFactory.create(vehicleRegistered));
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
    public Long insert(VehicleHistoryData vehicleHistory) {
        return parkingDatabase.vehicleHistoryDao().insert(vehicleHistoryFactory.create(vehicleHistory));
    }

    @Override
    public int update(VehicleHistoryData vehicleHistory) {
        return parkingDatabase.vehicleHistoryDao().update(vehicleHistoryFactory.create(vehicleHistory));
    }

}
