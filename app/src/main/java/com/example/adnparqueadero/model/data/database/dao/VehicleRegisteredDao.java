package com.example.adnparqueadero.model.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.adnparqueadero.model.data.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.data.database.tables.VehicleRegistered;

@Dao
public interface VehicleRegisteredDao {

    @Query("SELECT licencePlate, typeVehicle,cylinder FROM VehicleRegistered where licencePlate = :licencePlate limit 1")
    VehicleRegisteredData getSelect(String licencePlate);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(VehicleRegistered vehicleRegistered);


}
