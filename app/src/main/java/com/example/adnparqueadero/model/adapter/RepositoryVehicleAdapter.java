package com.example.adnparqueadero.model.adapter;


import com.example.adnparqueadero.model.infrastructure.repository.ParkingRepository;


public class RepositoryVehicleAdapter implements RepositoryVehicle {
    private ParkingRepository parkingRepository;

    public RepositoryVehicleAdapter(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    @Override
    public String[][] getVehicleEntegered() {
        com.example.adnparqueadero.model.domain.service.RepositoryVehicle repositoryVehicle= new com.example.adnparqueadero.model.domain.service.RepositoryVehicle(parkingRepository);
        return repositoryVehicle.getVehicleEntegered();
    }
}
