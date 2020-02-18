package com.example.adnparqueadero.model.infrastructure.repository;

import com.example.adnparqueadero.model.domain.repository.ParkingRepository;
import com.example.adnparqueadero.model.infrastructure.database.ParkingDatabase;
import com.example.adnparqueadero.model.domain.models.VehicleHistoryData;
import com.example.adnparqueadero.model.domain.models.VehicleRegisteredData;
import com.example.adnparqueadero.model.infrastructure.builder.VehicleHistoryBuilder;
import com.example.adnparqueadero.model.infrastructure.builder.VehicleRegisteredBuilder;

import java.util.List;

import javax.inject.Inject;

public class ParkingRepositoryImp implements ParkingRepository {

    private ParkingDatabase parkingDatabase;
    //Cambiar los factry que no es por un patron de diseño
    private VehicleHistoryBuilder vehicleHistoryBuilder = new VehicleHistoryBuilder();
    private VehicleRegisteredBuilder vehicleRegisteredBuilder = new VehicleRegisteredBuilder();

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
        return parkingDatabase.vehicleRegisteredDao().insert(vehicleRegisteredBuilder.create(vehicleRegistered));
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
        return parkingDatabase.vehicleHistoryDao().insert(vehicleHistoryBuilder.create(vehicleHistory));
    }

    @Override
    public int update(VehicleHistoryData vehicleHistory) {
        return parkingDatabase.vehicleHistoryDao().update(vehicleHistoryBuilder.create(vehicleHistory));
    }

}
