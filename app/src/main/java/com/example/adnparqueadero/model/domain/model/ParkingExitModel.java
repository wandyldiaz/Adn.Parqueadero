package com.example.adnparqueadero.model.domain.model;

import android.util.Log;

import com.example.adnparqueadero.model.data.database_manager.ManagerQuery;
import com.example.adnparqueadero.model.data.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.data.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.domain.controller_domain.DateTimeParking;
import com.example.adnparqueadero.model.domain.controller_domain.ParkingExit;
import com.example.adnparqueadero.model.service.ServiceParkingExit;

public class ParkingExitModel implements ServiceParkingExit {
    public static final String errorVehicleNotEntered = "Error el vehiculo no esta en el parqueadero";
    private ManagerQuery managerQuery;
    private String replyMessage;
    private VehicleHistoryData vehicleHistoryData;
    private VehicleRegisteredData vehicleRegisteredData;

    public ParkingExitModel(ManagerQuery managerQuery) {
        this.managerQuery = managerQuery;
    }

    private  boolean validateEntered(String licencePlate){
        replyMessage= errorVehicleNotEntered;
        try{
            vehicleRegisteredData= managerQuery.getSelect(licencePlate);
            vehicleHistoryData= managerQuery.getSelectVehicleEntered(licencePlate);
            if(vehicleHistoryData== null || vehicleRegisteredData ==null){
                return false;
            }
        }catch(Exception e){
            Log.e("ErrorValidateEntered",e.toString());
            return false;
        }

        return true;
    }
    @Override
    public String makeExit(String licencePlate) {
        DateTimeParking dateTimeParking =new DateTimeParking();
        ParkingExit parkingExit;
        if(!validateEntered(licencePlate))
            return replyMessage;
        parkingExit = new ParkingExit(vehicleHistoryData, vehicleRegisteredData,
                dateTimeParking.getCurrentDate(), dateTimeParking.getCurrentTime(),
                managerQuery);
        return parkingExit.startMakeExit();
    }
}
