package com.example.adnparqueadero.model.domain.service;


import com.example.adnparqueadero.model.infrastructure.repository.ParkingRepository;
import com.example.adnparqueadero.model.domain.models.dto.VehicleHistoryData;

import java.util.List;

public class RepositoryVehicle{
    private ParkingRepository parkingRepository;

    public RepositoryVehicle(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    private String[][] vehicleEntered(){
        String[][] reply = new String[0][0];
        List<VehicleHistoryData> vehicleEntered = parkingRepository.getSelectVehicleEntered();
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
    public String[][] getVehicleEntered(){
        return vehicleEntered();
    }
}
