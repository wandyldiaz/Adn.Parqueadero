package com.example.adnparqueadero.model.adapter;

import android.util.Log;

import com.example.adnparqueadero.model.infrastructure.repository.ParkingRepository;
import com.example.adnparqueadero.model.domain.models.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.domain.models.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.domain.service.DateTimeParking;

public class ParkingExitAdapter implements ParkingExit {
    public static final String errorVehicleNotEntered = "Error el vehiculo no esta en el parqueadero";
    private ParkingRepository parkingRepository;
    private String replyMessage;
    private VehicleHistoryData vehicleHistoryData;
    private VehicleRegisteredData vehicleRegisteredData;

    public ParkingExitAdapter(ParkingRepository parkingRepository) {
        this.parkingRepository = parkingRepository;
    }

    //pasar validacion
    private  boolean validateEntered(String licencePlate){
        replyMessage= errorVehicleNotEntered;
        try{
            vehicleRegisteredData= parkingRepository.getSelect(licencePlate);
            vehicleHistoryData= parkingRepository.getSelectVehicleEntered(licencePlate);
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
        com.example.adnparqueadero.model.domain.service.ParkingExit parkingExit;
        if(!validateEntered(licencePlate))
            return replyMessage;
        parkingExit = new com.example.adnparqueadero.model.domain.service.ParkingExit(vehicleHistoryData, vehicleRegisteredData,
                dateTimeParking.getCurrentDate(), dateTimeParking.getCurrentTime(),
                parkingRepository);
        return parkingExit.startMakeExit();
    }
}
