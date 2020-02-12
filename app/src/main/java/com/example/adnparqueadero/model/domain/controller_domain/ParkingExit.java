package com.example.adnparqueadero.model.domain.controller_domain;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.adnparqueadero.model.datos.database.ParkingDatabase;
import com.example.adnparqueadero.model.datos.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.datos.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.datos.tables.VehicleHistory;
import com.example.adnparqueadero.model.domain.class_abstracts.BusinessModel;
import com.example.adnparqueadero.model.domain.class_abstracts.Messages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ParkingExit {

    private VehicleHistoryData vehicleHistoryEntered;
    private VehicleHistory vehicleExit;
    private VehicleRegisteredData vehicleRegistered;
    private String currentDate;
    private String currentTime;
    private String replyMessage;
    private ParkingDatabase parkingDatabase;

    public ParkingExit(VehicleHistoryData vehicleHistoryEntered, VehicleRegisteredData vehicleRegistered,
                       String currentDate, String currentTime, ParkingDatabase parkingDatabase) {
        this.vehicleHistoryEntered = vehicleHistoryEntered;
        this.vehicleRegistered = vehicleRegistered;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.parkingDatabase = parkingDatabase;
    }

    private void calculateExit() throws ParseException {
        int hoursParked;
        int daysParket;
        int priceCharged;
        int dayValue;
        int additionalValue=0;
        int hourValue;
        String dateEntry= vehicleHistoryEntered.getDateEntry();
        String timeEntry= vehicleHistoryEntered.getTimeEntry();
        replyMessage = Messages.ErrorVehicleData;
        if(vehicleRegistered.getTypeVehicle().equals(BusinessModel.typeVehicleCar)){
            dayValue=BusinessModel.priceDayCar;
            hourValue=BusinessModel.priceHourCar;
        }
        else{
            dayValue=BusinessModel.priceDayCar;
            hourValue=BusinessModel.priceHourCar;
            if(vehicleRegistered.getCylinder()>500)
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
        vehicleExit.setIdVehicleHistory(vehicleHistoryEntered.getIdVehicleHistory());
        vehicleExit.setDateEntry(vehicleHistoryEntered.getDateEntry());
        vehicleExit.setTimeEntry(vehicleHistoryEntered.getTimeEntry());
        vehicleExit.setLicencePlate(vehicleHistoryEntered.getLicencePlate());
        vehicleExit.setDateExit(currentDate);
        vehicleExit.setTimeExit(currentTime);
        vehicleExit.setHoursParked(hoursParked);
        vehicleExit.setAmountCharged(priceCharged);
    }

    private String makeExit(){
        try{
            calculateExit();
            replyMessage = Messages.ErrorVehicleExit;
            if(parkingDatabase.vehicleHistoryDao().update(vehicleExit)==-1){
                return replyMessage;
            }
            replyMessage = Messages.SuccesVehicleExit;
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

    public String StartMakeExit(){
        return makeExit();
    }

}
