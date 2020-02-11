package com.example.adnparqueadero.model.domain.model;

import android.util.Log;

import com.example.adnparqueadero.model.datos.database.ParkingDatabase;
import com.example.adnparqueadero.model.datos.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.datos.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.domain.ClassAbstracts.Messages;
import com.example.adnparqueadero.model.domain.controler_domain.ParkingExit;
import com.example.adnparqueadero.model.service.ServiceParkingExit;

public class ParkingExitModel implements ServiceParkingExit {
    private ParkingDatabase parkingDatabase;
    private String replyMessage;
    private VehicleHistoryData vehicleHistoryData;
    private VehicleRegisteredData vehicleRegisteredData;

    public ParkingExitModel(ParkingDatabase parkingDatabase) {
        this.parkingDatabase = parkingDatabase;
    }

    private  boolean validateEntered(String licencePlate){
        replyMessage= Messages.ErrorVehicleNotEntered;
        try{
            vehicleRegisteredData= parkingDatabase.vehicleRegisteredDao().getSelect(licencePlate);
            vehicleHistoryData=parkingDatabase.vehicleHistoryDao().getSelectVehicleEntered(licencePlate);
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
        ParkingExit parkingExit;
        if(validateEntered(licencePlate))
            return replyMessage;


        return replyMessage;
    }
}
