package com.example.adnparqueadero.model.adapter;


import com.example.adnparqueadero.model.domain.service.RepositoryVehicle;
import com.example.adnparqueadero.model.infrastructure.repository.ParkingRepository;

import javax.inject.Inject;


public class RepositoryVehicleAdapter implements RepositoryVehicleAdapterInterface {
    private ParkingRepository parkingRepository;

    @Inject
    public RepositoryVehicleAdapter(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public String[][] getVehicleEntered() {
        RepositoryVehicle repositoryVehicle= new RepositoryVehicle(parkingRepository);
        return repositoryVehicle.getVehicleEntered();
    }
}
