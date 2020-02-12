package com.example.adnparqueadero.model.domain.controller_domain;

import android.util.Log;

import com.example.adnparqueadero.model.datos.database_manager.ManagerQuerys;
import com.example.adnparqueadero.model.datos.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.datos.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.domain.class_abstracts.BusinessModel;
import com.example.adnparqueadero.model.domain.class_abstracts.Messages;

import static com.example.adnparqueadero.model.domain.class_abstracts.BusinessModel.daysAllowed;

public class ParkingEntry {
    private String currentDate;
    private String currentTime;
    private DateTimeParking dateTimeParking;
    private VehicleRegisteredData vehicleRegistered;
    private String replyMessage;
    private ManagerQuerys managerQuerys;

    public ParkingEntry(VehicleRegisteredData vehicleRegistered,
                        DateTimeParking dateTimeParking, ManagerQuerys managerQuerys) {
        this.vehicleRegistered = vehicleRegistered;
        this.dateTimeParking = dateTimeParking;
        this.managerQuerys = managerQuerys;
    }

    private boolean validateDayEntry(){
        replyMessage=Messages.ErrorVehicleDay;
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
            replyMessage = Messages.ErrorVehicleLimit;
            if(vehicleRegistered.getTypeVehicle().equals(BusinessModel.typeVehicleCar))
                limitVehicle= (long) BusinessModel.limitCar;
            else if(vehicleRegistered.getTypeVehicle().equals(BusinessModel.typeVehicleMotorcycle))
                limitVehicle= (long) BusinessModel.limitMotorcycle;
            else
                limitVehicle=(long) 0;
            return (managerQuerys
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
            replyMessage=Messages.ErrorRegisteredVehicle;
            if(managerQuerys.insert(vehicleRegistered)==0)
                return replyMessage;
            replyMessage=Messages.ErrorVehicleEntered;
            vehicleHistory.setLicencePlate(vehicleRegistered.getLicencePlate());
            vehicleHistory.setDateEntry(currentDate);
            vehicleHistory.setTimeEntry(currentTime);
            vehicleHistory.setAmountCharged(0);
            vehicleHistory.setDateExit("");
            vehicleHistory.setHoursParked(0);
            vehicleHistory.setTimeExit("");
            if(managerQuerys.insert(vehicleHistory)!=0)
            replyMessage=Messages.SuccesVehicleEntry;

        }catch(Exception e){
            Log.e("ErrorVehiculoEntrando",e.toString());
        }
        return replyMessage;
    }

    public String StartVehicleEntry(){
        return vehicleEntry();
    }

}
