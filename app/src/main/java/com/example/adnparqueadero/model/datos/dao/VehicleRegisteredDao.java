package com.example.adnparqueadero.model.datos.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.adnparqueadero.model.datos.dto.VehicleRegisteredData;
import com.example.adnparqueadero.model.datos.tables.VehicleRegistered;
import java.util.List;

@Dao
public interface VehicleRegisteredDao {

    @Query("SELECT licencePlate, typeVehicle,cylinder FROM VehicleRegistered")
    List<VehicleRegisteredData> getSelect();


    @Query("SELECT licencePlate, typeVehicle,cylinder FROM VehicleRegistered where licencePlate = :licencePlate limit 1")
    VehicleRegisteredData getSelect(String licencePlate);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insert(VehicleRegistered vehicleRegistered);


}
