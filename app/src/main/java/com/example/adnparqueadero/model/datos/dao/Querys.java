package com.example.adnparqueadero.model.datos.dao;

import androidx.room.Dao;
import androidx.room.Query;


@Dao
public interface Querys {
    @Query("SELECT Count(*) FROM VehicleRegistered r,vehicleHistory h " +
            "where r.licencePlate=h.licencePlate and r.typeVehicle = :typeVehicle and h.dateExit = \"\"")
    Long getCountVehicleEnteredType(String typeVehicle);
}
