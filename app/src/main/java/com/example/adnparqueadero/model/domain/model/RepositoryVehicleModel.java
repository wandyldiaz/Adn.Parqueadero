package com.example.adnparqueadero.model.domain.model;


import com.example.adnparqueadero.model.data.database_manager.ManagerQuery;
import com.example.adnparqueadero.model.domain.controller_domain.RepositoryVehicle;
import com.example.adnparqueadero.model.service.ServiceRepositoryVehicle;


public class RepositoryVehicleModel implements ServiceRepositoryVehicle {
    private ManagerQuery managerQuery;

    public RepositoryVehicleModel(ManagerQuery managerQuery) {
        this.managerQuery = managerQuery;
    }

    @Override
    public String[][] getVehicleEntegered() {
        RepositoryVehicle repositoryVehicle= new RepositoryVehicle(managerQuery);
        return repositoryVehicle.getVehicleEntegered();
    }
}
