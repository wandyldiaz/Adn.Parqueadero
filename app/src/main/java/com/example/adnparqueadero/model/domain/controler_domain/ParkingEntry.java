package com.example.adnparqueadero.model.domain.controler_domain;

import android.util.Log;

import com.example.adnparqueadero.model.datos.database.ParkingDatabase;
import com.example.adnparqueadero.model.datos.tables.VehicleHistory;
import com.example.adnparqueadero.model.datos.tables.VehicleRegistered;
import com.example.adnparqueadero.model.domain.ClassAbstracts.BusinessModel;
import com.example.adnparqueadero.model.domain.ClassAbstracts.Messages;

import static com.example.adnparqueadero.model.domain.ClassAbstracts.BusinessModel.daysAllowed;

public class ParkingEntry {
    private String licencePlate;
    private String currentDate;
    private String currentTime;
    private int cylinder;
    private String typeVehicle;
    private String replyMessage;
    private DateTimeParking dateTimeParking;
    private ParkingDatabase database;

    public ParkingEntry(String licencePlate, int cylinder, String typeVehicle,
                        DateTimeParking dateTimeParking, ParkingDatabase database) {
        this.licencePlate = licencePlate.toUpperCase();
        this.cylinder = cylinder;
        this.typeVehicle = typeVehicle;
        this.dateTimeParking = dateTimeParking;
        this.database = database;
    }

    private boolean validateDayEntry(){
        replyMessage=Messages.ErrorVehicleDay;
        currentDate = dateTimeParking.getCurrentDate();
        currentTime = dateTimeParking.getCurrentTime();
        if(typeVehicle.equals(BusinessModel.typeVehicleCar))
            return true;
        String currentDay = dateTimeParking.getDayWeek(currentDate);
        String lyricsLicencePlate=(""+ licencePlate.charAt(0)).toUpperCase();
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
            if(typeVehicle.equals(BusinessModel.typeVehicleCar))
                limitVehicle= (long) BusinessModel.limitCar;
            else if(typeVehicle.equals(BusinessModel.typeVehicleMotorcycle))
                limitVehicle= (long) BusinessModel.limitMotorcycle;
            else
                limitVehicle=(long) 0;
            return (database.querysDao().getCountVehicleEnteredType(typeVehicle) > limitVehicle);
        }catch (Exception e){
            Log.e("ErrorSalida",e.toString());
            return false;
        }
    }

    private String vehicleEntry(){
        VehicleRegistered vehicleRegistered=new VehicleRegistered();
        VehicleHistory vehicleHistory=new VehicleHistory();
        try {
            if (!validateLimitEntry() || !validateDayEntry())
                return replyMessage;
            vehicleRegistered.setCylinder(cylinder);
            vehicleRegistered.setLicencePlate(licencePlate);
            vehicleRegistered.setTypeVehicle(typeVehicle);
            replyMessage=Messages.ErrorRegisteredVehicle;
            if(database.vehicleRegisteredDao().insert(vehicleRegistered)==0)
                return replyMessage;
            replyMessage=Messages.ErrorVehicleEntered;
            vehicleHistory.setLicencePlate(licencePlate);
            vehicleHistory.setDateEntry(currentDate);
            vehicleHistory.setTimeEntry(currentTime);
            vehicleHistory.setAmountCharged(0);
            vehicleHistory.setDateExit("");
            vehicleHistory.setHoursParked(0);
            vehicleHistory.setTimeExit("");
            if(database.vehicleHistoryDao().insert(vehicleHistory)!=0)
            replyMessage=Messages.SuccesVehicleEntry;

        }catch(Exception e){
            Log.e("ErrorVehiculoEntrando",e.toString());
        }
        return replyMessage;
    }

    public String getVehicleEntry(){
        return vehicleEntry();
    }

}
