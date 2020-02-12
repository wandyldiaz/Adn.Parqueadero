package com.example.adnparqueadero.model.domain.service;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.adnparqueadero.model.domain.models.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.infrastructure.repository.ParkingRepository;
import com.example.adnparqueadero.model.domain.models.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.domain.business_model.BusinessModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ParkingExit {
    public static final String errorVehicleCalculate  = "Error al calcular la salida del vehiculo";
    public static final String errorVehicleData       = "Error al obtener los datos del vehiculo registrado";
    public static final String errorVehicleExit       = "Error al realizar la salida del vehiculo";
    public static final String succesVehicleExit      = "Salida realizada exitosamente";
    public static final int priceHourCar =1000;
    public static final int priceHourMotorcycle =500;
    public static final int priceDayCar =8000;
    public static final int priceDayMotorcycle =4000;
    public static final int priceMotorcycleCylinderSurcharge =2000;
    public static final int cylinderMotorcycleSurcharge = 500;
    private VehicleHistoryData vehicleHistoryEntered;
    private VehicleRegisteredData vehicleRegistered;
    private String currentDate;
    private String currentTime;
    private String replyMessage;
    private ParkingRepository parkingRepository;

    public ParkingExit(VehicleHistoryData vehicleHistoryEntered, VehicleRegisteredData vehicleRegistered,
                       String currentDate, String currentTime, ParkingRepository parkingRepository) {
        this.vehicleHistoryEntered = vehicleHistoryEntered;
        this.vehicleRegistered = vehicleRegistered;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.parkingRepository = parkingRepository;
    }

    private boolean calculateExit() throws ParseException {
        int hoursParked;
        int daysParket;
        int priceCharged;
        int dayValue;
        int additionalValue=0;
        int hourValue;
        String dateEntry= vehicleHistoryEntered.getDateEntry();
        String timeEntry= vehicleHistoryEntered.getTimeEntry();
        replyMessage = errorVehicleData;
        if(vehicleRegistered.getTypeVehicle().equals(BusinessModel.typeVehicleCar)){
            dayValue=priceDayCar;
            hourValue=priceHourCar;
        }
        else if(vehicleRegistered.getTypeVehicle().equals(BusinessModel.typeVehicleMotorcycle)){
            dayValue=priceDayMotorcycle;
            hourValue=priceHourMotorcycle;
            if(vehicleRegistered.getCylinder()>cylinderMotorcycleSurcharge)
                additionalValue=priceMotorcycleCylinderSurcharge;
        }
        else{
            return false;
        }
        hoursParked=getDifferenceBetweenDatesHours(dateEntry+" "+timeEntry,
                currentDate +" "+ currentTime);
        replyMessage = errorVehicleCalculate;
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
        vehicleHistoryEntered.setDateExit(currentDate);
        vehicleHistoryEntered.setTimeExit(currentTime);
        vehicleHistoryEntered.setHoursParked(hoursParked);
        vehicleHistoryEntered.setAmountCharged(priceCharged);
        return true;
    }

    private String makeExit(){
        try{
            if(!calculateExit())
                return replyMessage;
            replyMessage = errorVehicleExit;
            if(parkingRepository.update(vehicleHistoryEntered)==-1){
                return replyMessage;
            }
            replyMessage = succesVehicleExit;
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

    public String startMakeExit(){
        return makeExit();
    }

}
