package com.example.adnparqueadero.model.datos.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.adnparqueadero.model.datos.tables.VehicleRegistered;

import java.util.List;
@Dao
public interface VehicleRegisteredDao {

    @Query("SELECT * FROM VehicleRegistered")
    List<VehicleRegisteredData> getSelect();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(VehicleRegistered... vehiculosRegistrados);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(VehicleRegistered vehicleRegistered);

    @Delete
    void delete(VehicleRegistered vehicleRegistered);

    class VehicleRegisteredData {
        public String licencePlate;

        public String typeVehicle;

        public String cylinder;
    }

}
