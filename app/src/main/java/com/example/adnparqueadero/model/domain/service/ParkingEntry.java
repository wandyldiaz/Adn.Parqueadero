package com.example.adnparqueadero.model.domain.service;

import android.util.Log;

import com.example.adnparqueadero.model.infrastructure.repository.ParkingRepository;
import com.example.adnparqueadero.model.domain.models.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.domain.models.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.domain.business_model.BusinessModel;


public class ParkingEntry {
    private static final String errorVehicleEntered      = "Error el vehiculo ya se encuentra en el parqueadero";
    private static final String errorVehicleLimit        = "Error no hay cupo en el parqueadero";
    private static final String errorVehicleDay          = "Error el vehiculo no puede ingresar el dia de hoy";
    private static final String errorVehicleEntry        = "Error no se pudo ingresar el vehiculo";
    private static final String errorRegisteredVehicle   = "Error no se pudo registrar el vehiculo";
    private static final String successVehicleEntry      = "Vehiculo ingresado exitosamente";
    private static final int limitCar = 20;
    private static final int limitMotorcycle = 10;
    private static final String[] daysAllowed =new String[]{"Domingo","Lunes"};
    private String currentDate;
    private String currentTime;
    private DateTimeParking dateTimeParking;
    private VehicleRegisteredData vehicleRegistered;
    private String replyMessage;
    private ParkingRepository parkingRepository;

    public ParkingEntry(VehicleRegisteredData vehicleRegistered,
                        DateTimeParking dateTimeParking, ParkingRepository parkingRepository) {
        this.vehicleRegistered = vehicleRegistered;
        this.dateTimeParking = dateTimeParking;
        this.parkingRepository = parkingRepository;
    }

    private boolean validateDayEntry(){
        replyMessage=errorVehicleDay;
        currentDate = dateTimeParking.getCurrentDate();
        currentTime = dateTimeParking.getCurrentTime();
        if(vehicleRegistered.getTypeVehicle().equals(BusinessModel.typeVehicleCar))
            return true;
        String currentDay = dateTimeParking.getDayWeek(currentDate);
        String lyricsLicencePlate=(""+ vehicleRegistered.getLicencePlate().charAt(0)).toUpperCase();
        for (String day : daysAllowed) {
            if ((!day.equals(currentDay)) && "A".equals(lyricsLicencePlate)) {
                return false;
            }
        }
        return true;
    }
    private boolean validateLimitEntry(){
        try{
            Long limitVehicle;
            replyMessage = errorVehicleLimit;
            if(vehicleRegistered.getTypeVehicle().equals(BusinessModel.typeVehicleCar))
                limitVehicle= (long) limitCar;
            else if(vehicleRegistered.getTypeVehicle().equals(BusinessModel.typeVehicleMotorcycle))
                limitVehicle= (long) limitMotorcycle;
            else
                limitVehicle=(long) 0;
            return (parkingRepository
                    .getCountVehicleEnteredType(vehicleRegistered.getTypeVehicle()) > limitVehicle);
        }catch (Exception e){
            Log.e("ErrorSalida",e.toString());
            return false;
        }
    }

    private String vehicleEntry(){
        VehicleHistoryData vehicleHistory=new VehicleHistoryData();
        try {
            if (!validateLimitEntry() || !validateDayEntry())
                return replyMessage;
            replyMessage=errorRegisteredVehicle;
            if(parkingRepository.insert(vehicleRegistered)==0)
                return replyMessage;
            replyMessage=errorVehicleEntered;
            if(parkingRepository.getSelectVehicleEntered(vehicleRegistered.getLicencePlate())==null)
                return replyMessage;
            replyMessage=errorVehicleEntry;
            vehicleHistory.setIdVehicleHistory(0);
            vehicleHistory.setLicencePlate(vehicleRegistered.getLicencePlate());
            vehicleHistory.setDateEntry(currentDate);
            vehicleHistory.setTimeEntry(currentTime);
            vehicleHistory.setAmountCharged(0);
            vehicleHistory.setDateExit("");
            vehicleHistory.setHoursParked(0);
            vehicleHistory.setTimeExit("");
            if(parkingRepository.insert(vehicleHistory)!=0)
                replyMessage= successVehicleEntry;

        }catch(Exception e){
            Log.e("ErrorVehiculoEntrando",e.toString());
        }
        return replyMessage;
    }

    public String StartVehicleEntry(){
        return vehicleEntry();
    }

}
