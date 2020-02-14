package com.example.adnparqueadero.model.domain.service;

import android.annotation.SuppressLint;
import android.util.Log;

import com.example.adnparqueadero.model.domain.models.VehicleHistoryData;
import com.example.adnparqueadero.model.domain.repository.ParkingRepository;
import com.example.adnparqueadero.model.domain.models.VehicleRegisteredData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ParkingExit {
    private static final String ERROR_VEHICLE_CALCULATE = "Error al calcular la salida del vehiculo";
    private static final String ERROR_VEHICLE_DATA = "Error al obtener los datos del vehiculo registrado";
    private static final String ERROR_VEHICLE_EXIT = "Error al realizar la salida del vehiculo";
    private static final String SUCCESS_VEHICLE_EXIT = "Salida realizada exitosamente";
    private static final String ERROR_VEHICLE_NOT_ENTERED = "Error el vehiculo no esta en el parqueadero";
    private static final String TYPE_VEHICLE_MOTORCYCLE = "Moto";
    private static final String TYPE_VEHICLE_CAR = "Carro";
    private static final int PRICE_HOUR_CAR =1000;
    private static final int PRICE_HOUR_MOTORCYCLE =500;
    private static final int PRICE_DAY_CAR =8000;
    private static final int PRICE_DAY_MOTORCYCLE =4000;
    private static final int PRICE_MOTORCYCLE_CYLINDER_SURCHARGE =2000;
    private static final int CYLINDER_MOTORCYCLE_SURCHARGE = 500;
    private VehicleHistoryData vehicleHistoryEntered;
    private VehicleRegisteredData vehicleRegistered;
    private String currentDate;
    private String currentTime;
    private String replyMessage;
    private ParkingRepository parkingRepository;
    private String licencePlate;
    private int hoursParked;
    private int daysParked;
    private int priceCharged;


    public ParkingExit(String currentDate, String currentTime, ParkingRepository parkingRepository,
                       String licencePlate) {
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.parkingRepository = parkingRepository;
        this.licencePlate = licencePlate;
    }

    private  boolean validateEntered(){
        replyMessage= ERROR_VEHICLE_NOT_ENTERED;
        try{
            vehicleRegistered= parkingRepository.getSelect(licencePlate);
            vehicleHistoryEntered= parkingRepository.getSelectVehicleEntered(licencePlate);
            if(vehicleRegistered== null || vehicleHistoryEntered ==null){
                return false;
            }
        }catch(Exception e){
            Log.e("ErrorValidateEntered",e.toString());
            return false;
        }

        return true;
    }
    private boolean calculateExit() throws ParseException {
        hoursParked=0;
        daysParked=0;
        priceCharged=0;
        int dayValue;
        int additionalValue=0;
        int hourValue;
        String dateEntry= vehicleHistoryEntered.getDateEntry();
        String timeEntry= vehicleHistoryEntered.getTimeEntry();
        replyMessage = ERROR_VEHICLE_DATA;
        if(vehicleRegistered.getTypeVehicle().equals(TYPE_VEHICLE_CAR)){
            dayValue= PRICE_DAY_CAR;
            hourValue= PRICE_HOUR_CAR;
        }
        else if(vehicleRegistered.getTypeVehicle().equals(TYPE_VEHICLE_MOTORCYCLE)){
            dayValue= PRICE_DAY_MOTORCYCLE;
            hourValue= PRICE_HOUR_MOTORCYCLE;
            if(vehicleRegistered.getCylinder()> CYLINDER_MOTORCYCLE_SURCHARGE)
                additionalValue= PRICE_MOTORCYCLE_CYLINDER_SURCHARGE;
        }
        else{
            return false;
        }
        hoursParked=getDifferenceBetweenDatesHours(dateEntry+" "+timeEntry,
                currentDate +" "+ currentTime);
        replyMessage = ERROR_VEHICLE_CALCULATE;
        if(hoursParked>=9 && hoursParked<=24){
            priceCharged=dayValue+additionalValue;
        }
        else if(hoursParked<9){
            priceCharged=(hourValue*hoursParked)+additionalValue;
        }
        else{
            daysParked=(hoursParked/24);
            int hoursParkedAfterDays=hoursParked % 24;
            if(hoursParkedAfterDays>=9){
                hoursParkedAfterDays=hoursParkedAfterDays-9;
                daysParked++;
            }
            priceCharged=(hoursParkedAfterDays*hourValue)+(daysParked*dayValue)+additionalValue;
        }
        vehicleHistoryEntered.setDateExit(currentDate);
        vehicleHistoryEntered.setTimeExit(currentTime);
        vehicleHistoryEntered.setHoursParked(hoursParked);
        vehicleHistoryEntered.setAmountCharged(priceCharged);
        return true;
    }

    private String makeExit(){
        try{
            if (!validateEntered())
                return replyMessage;
            if(!calculateExit())
                return replyMessage;
            replyMessage = ERROR_VEHICLE_EXIT;
            if (parkingRepository.update(vehicleHistoryEntered) != -1)

                replyMessage = SUCCESS_VEHICLE_EXIT+"\n"+"Dias parqueado:"+daysParked+"\n"
                + "Horas parqueado: "+hoursParked+"\n"+"Precio:"+priceCharged;
            }catch (Exception e){
                Log.e("ErrorSalida",e.toString());
        }
        return replyMessage;
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
