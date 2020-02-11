package com.example.adnparqueadero.model.domain.controler_domain;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.adnparqueadero.model.datos.dao.VehicleHistoryDao.VehicleHistoryData;
import com.example.adnparqueadero.model.datos.database.ParkingDatabase;
import com.example.adnparqueadero.model.datos.tables.VehicleHistory;
import com.example.adnparqueadero.model.domain.ClassAbstracts.BusinessModel;
import com.example.adnparqueadero.model.domain.ClassAbstracts.Messages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.example.adnparqueadero.model.datos.dao.VehicleRegisteredDao.*;

public class ParkingExit {

    private VehicleHistoryData vehicleHistoryEntered;
    private VehicleHistory vehicleExit;
    private VehicleRegisteredData vehicleRegistered;
    private String currentDate;
    private String currentTime;
    private String replyMessage;
    private ParkingDatabase database;

    public ParkingExit(VehicleHistoryData vehicleHistoryEntered, VehicleRegisteredData vehicleRegistered,
                       String currentDate, String currentTime, ParkingDatabase database) {
        this.vehicleHistoryEntered = vehicleHistoryEntered;
        this.vehicleRegistered = vehicleRegistered;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.database = database;
    }

    private void calculateExit() throws ParseException {
        int hoursParked;
        int daysParket;
        int priceCharged;
        int dayValue;
        int additionalValue=0;
        int hourValue;
        String dateEntry= vehicleHistoryEntered.dateEntry;
        String timeEntry= vehicleHistoryEntered.timeEntry;
        replyMessage = Messages.ErrorVehicleData;
        if(vehicleRegistered.typeVehicle.equals(BusinessModel.typeVehicleCar)){
            dayValue=BusinessModel.priceDayCar;
            hourValue=BusinessModel.priceHourCar;
        }
        else{
            dayValue=BusinessModel.priceDayCar;
            hourValue=BusinessModel.priceHourCar;
            if(vehicleRegistered.cylinder>500)
                additionalValue=BusinessModel.cylinderMotorcycleSurcharge;
        }
        hoursParked=getDifferenceBetweenDatesHours(dateEntry+" "+timeEntry,
                currentDate +" "+ currentTime);
        replyMessage = Messages.ErrorVehicleCalculate;
        if(hoursParked>=9 && hoursParked<=24){
            priceCharged=dayValue+additionalValue;
        }
        else if(hoursParked<9){
            priceCharged=(hourValue*hoursParked)+additionalValue;
        }
        else{
            daysParket=(hoursParked/24);
            int hoursParkedAfterDays=hoursParked % 24;
            if(hoursParkedAfterDays>=9){
                hoursParkedAfterDays=hoursParkedAfterDays-9;
                daysParket++;
            }
            priceCharged=(hoursParkedAfterDays*hourValue)+(daysParket*dayValue)+additionalValue;
        }
        vehicleExit=new VehicleHistory();
        vehicleExit.setIdVehicleHistory(vehicleHistoryEntered.idVehicleHistory);
        vehicleExit.setDateEntry(vehicleHistoryEntered.dateEntry);
        vehicleExit.setTimeEntry(vehicleHistoryEntered.timeEntry);
        vehicleExit.setLicencePlate(vehicleHistoryEntered.licencePlate);
        vehicleExit.setDateExit(currentDate);
        vehicleExit.setTimeExit(currentTime);
        vehicleExit.setHoursParked(hoursParked);
        vehicleExit.setAmountCharged(priceCharged);
    }

    private String makeExit(){
        try{
            calculateExit();
            replyMessage = Messages.ErrorVehicleExit;
            if(database.vehicleHistoryDao().update(vehicleExit)==-1){
                return replyMessage;
            }
            replyMessage = Messages.ErrorVehicleExit;
            return replyMessage;
        }catch (Exception e){
            Log.e("ErrorSalida",e.toString());
            return replyMessage;
        }
    }

    private int getDifferenceBetweenDatesHours(String dayStart, String dayEnd) throws ParseException {
        @SuppressLint("SimpleDateFormat") SimpleDateFormat simpleDateFormat =
                new SimpleDateFormat("yyyy/MM/dd HH:mm");
        Date dateDayStart= simpleDateFormat.parse(dayStart);
        Date dateDayEnd=  simpleDateFormat.parse(dayEnd);
        long milliseconds = dateDayEnd.getTime() - dateDayStart.getTime();
        return ((int) (milliseconds / (1000 * 60 * 60)));
    }

    public String isMakeExit(){
        return makeExit();
    }

}
