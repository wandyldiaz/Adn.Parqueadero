package com.example.adnparqueadero.model.infrastructure.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.adnparqueadero.model.infrastructure.dao.QuerysDao;
import com.example.adnparqueadero.model.infrastructure.dao.VehicleHistoryDao;
import com.example.adnparqueadero.model.infrastructure.dao.VehicleRegisteredDao;
import com.example.adnparqueadero.model.infrastructure.entity.VehicleHistory;
import com.example.adnparqueadero.model.infrastructure.entity.VehicleRegistered;

@Database(entities = {VehicleHistory.class, VehicleRegistered.class}, exportSchema = false, version = 1)
public abstract class ParkingDatabase extends RoomDatabase {

    public abstract VehicleHistoryDao vehicleHistoryDao();

    public abstract VehicleRegisteredDao vehicleRegisteredDao();

    public abstract QuerysDao querysDao();

}
