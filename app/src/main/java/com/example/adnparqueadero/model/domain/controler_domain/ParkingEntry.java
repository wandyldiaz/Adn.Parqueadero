package com.example.adnparqueadero.model.domain.controler_domain;

import com.example.adnparqueadero.model.domain.ClassAbstracts.BusinessModel;

import static com.example.adnparqueadero.model.domain.ClassAbstracts.BusinessModel.daysAllowed;

public class ParkingEntry {
    private String licencePlate;
    private String currentDate;
    private String currentTime;
    private String cylinder;
    private String typeVehicle;
    private DateTimeParking dateTimeParking;

    public ParkingEntry(String licencePlate, String cylinder, String typeVehicle,
                        DateTimeParking dateTimeParking) {
        this.licencePlate = licencePlate;
        this.cylinder = cylinder;
        this.typeVehicle = typeVehicle;
        this.dateTimeParking = dateTimeParking;
    }

    private boolean validateDayEntry(){
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

        return true;
    }

    private String vehicleEntry(){


        return "";
    }

}
