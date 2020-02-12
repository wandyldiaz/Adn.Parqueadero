package com.example.adnparqueadero.model.domain.controller_domain;


import com.example.adnparqueadero.model.data.database_manager.ManagerQuery;
import com.example.adnparqueadero.model.data.dto.VehicleHistoryData;

import java.util.List;

public class RepositoryVehicle{
    private ManagerQuery managerQuery;

    public RepositoryVehicle(ManagerQuery managerQuery) {
        this.managerQuery = managerQuery;
    }

    private String[][] vehicleEntegered(){
        String[][] reply = new String[0][0];
        List<VehicleHistoryData> vehicleEntered =managerQuery.getSelectVehicleEntered();
        if(!vehicleEntered.isEmpty()){
            reply= new String[vehicleEntered.size()][8];
            for(int i=0; i<vehicleEntered.size();i++){
               reply[i][0]= ""+vehicleEntered.get(i).getIdVehicleHistory();
               reply[i][1]= ""+vehicleEntered.get(i).getLicencePlate();
               reply[i][2]= ""+vehicleEntered.get(i).getDateEntry();
               reply[i][3]= ""+vehicleEntered.get(i).getTimeEntry();
               reply[i][4]= ""+vehicleEntered.get(i).getDateExit();
               reply[i][5]= ""+vehicleEntered.get(i).getTimeExit();
               reply[i][6]= ""+vehicleEntered.get(i).getHoursParked();
               reply[i][7]= ""+vehicleEntered.get(i).getAmountCharged();
            }
        }
        return reply;
    }
    public String[][] getVehicleEntegered(){
        return vehicleEntegered();
    }
}
