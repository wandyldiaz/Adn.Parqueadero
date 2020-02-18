package com.example.adnparqueadero.model.domain.service;

import android.util.Log;

import com.example.adnparqueadero.model.domain.DateTimeParking;
import com.example.adnparqueadero.model.domain.repository.ParkingRepository;
import com.example.adnparqueadero.model.domain.models.VehicleHistoryData;
import com.example.adnparqueadero.model.domain.models.VehicleRegisteredData;


public class ParkingEntry {

    private static final String ERROR_VEHICLE_ENTERED = "Error el vehiculo ya se encuentra en el parqueadero";
    private static final String ERROR_VEHICLE_LIMIT = "Error no hay cupo en el parqueadero";
    private static final String ERROR_VEHICLE_DAY = "Error el vehiculo no puede ingresar el dia de hoy";
    private static final String ERROR_VEHICLE_ENTRY = "Error no se pudo ingresar el vehiculo";
    private static final String ERROR_REGISTERED_VEHICLE = "Error no se pudo registrar el vehiculo";
    private static final String ERROR_LICENCE_PLATE = "Error placa incorrecta";
    private static final String SUCCESS_VEHICLE_ENTRY = "Vehiculo ingresado exitosamente";
    private static final String LYRIC_CONDITION = "A";
    private static final String TYPE_VEHICLE_MOTORCYCLE = "Moto";
    private static final String TYPE_VEHICLE_CAR = "Carro";
    private static final int LIMIT_CAR = 20;
    private static final int LIMIT_MOTORCYCLE = 10;
    private static final String[] DAYS_ALLOWED = new String[]{"Domingo", "Lunes"};
    private String currentDate;
    private String currentTime;
    private DateTimeParking dateTimeParking;
    private VehicleRegisteredData vehicleRegistered;
    private String replyMessage;
    private ParkingRepository parkingRepository;

    public ParkingEntry(VehicleRegisteredData vehicleRegistered, ParkingRepository parkingRepository) {
        this.vehicleRegistered = vehicleRegistered;
        this.dateTimeParking = new DateTimeParking();
        this.parkingRepository = parkingRepository;
    }

    private boolean validateLicencePlate() {
        replyMessage = ERROR_LICENCE_PLATE;
        return vehicleRegistered.getLicencePlate().length() == 6;
    }

    private boolean validateDayEntry() {
        replyMessage = ERROR_VEHICLE_DAY;
        currentDate = dateTimeParking.getCurrentDate();
        currentTime = dateTimeParking.getCurrentTime();
        if (vehicleRegistered.getTypeVehicle().equals(TYPE_VEHICLE_CAR))
            return true;
        String currentDay = dateTimeParking.getDayWeek(currentDate);
        String lyricsLicencePlate = ("" + vehicleRegistered.getLicencePlate().charAt(0)).toUpperCase();
        for (String day : DAYS_ALLOWED) {
            if ((!day.equals(currentDay)) && LYRIC_CONDITION.equals(lyricsLicencePlate)) {
                return false;
            }
        }
        return true;
    }

    private boolean validateLimitEntry() {
        try {
            Long limitVehicle = (long) 0;
            replyMessage = ERROR_VEHICLE_LIMIT;
            if (vehicleRegistered.getTypeVehicle().equals(TYPE_VEHICLE_CAR))
                limitVehicle = (long) LIMIT_CAR;
            else if (vehicleRegistered.getTypeVehicle().equals(TYPE_VEHICLE_MOTORCYCLE))
                limitVehicle = (long) LIMIT_MOTORCYCLE;
            Log.d("LimiteVehiculo", "" + limitVehicle);
            return (parkingRepository
                    .getCountVehicleEnteredType(vehicleRegistered.getTypeVehicle()) < limitVehicle);
        } catch (Exception e) {
            Log.e("ErrorSalida", e.toString());
            return false;
        }
    }

    private String vehicleEntry() {
        VehicleHistoryData vehicleHistory = new VehicleHistoryData();
        try {
            if (!validateLicencePlate() || !validateLimitEntry() || !validateDayEntry())
                return replyMessage;
            replyMessage = ERROR_REGISTERED_VEHICLE;
            if (parkingRepository.insert(vehicleRegistered) == 0)
                return replyMessage;
            replyMessage = ERROR_VEHICLE_ENTERED;
            if (parkingRepository.getSelectVehicleEntered(vehicleRegistered.getLicencePlate()) != null)
                return replyMessage;
            replyMessage = ERROR_VEHICLE_ENTRY;
            vehicleHistory.setIdVehicleHistory(0);
            vehicleHistory.setLicencePlate(vehicleRegistered.getLicencePlate());
            vehicleHistory.setDateEntry(currentDate);
            vehicleHistory.setTimeEntry(currentTime);
            vehicleHistory.setAmountCharged(0);
            vehicleHistory.setDateExit("");
            vehicleHistory.setHoursParked(0);
            vehicleHistory.setTimeExit("");
            if (parkingRepository.insert(vehicleHistory) != 0)
                replyMessage = SUCCESS_VEHICLE_ENTRY;

        } catch (Exception e) {
            Log.e("ErrorVehiculoEntrando", e.toString());
        }
        return replyMessage;
    }

    public String startVehicleEntry() {
        return vehicleEntry();
    }

}
