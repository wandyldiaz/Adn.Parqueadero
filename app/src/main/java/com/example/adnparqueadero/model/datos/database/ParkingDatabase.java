package com.example.adnparqueadero.model.datos.database;


import android.content.Context;
import android.util.Log;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.adnparqueadero.model.datos.dao.QuerysDao;
import com.example.adnparqueadero.model.datos.dao.VehicleHistoryDao;
import com.example.adnparqueadero.model.datos.dao.VehicleRegisteredDao;
import com.example.adnparqueadero.model.datos.tables.VehicleHistory;
import com.example.adnparqueadero.model.datos.tables.VehicleRegistered;

@Database(entities ={VehicleHistory.class, VehicleRegistered.class},exportSchema = false, version =1)
public abstract class ParkingDatabase extends RoomDatabase {
    private  static final String DB_NAME="parking_db";
    private static ParkingDatabase instance;

    public static  synchronized ParkingDatabase getInstance(Context context){
        if(instance==null){
            try {
                instance = Room.databaseBuilder(context, ParkingDatabase.class, DB_NAME).fallbackToDestructiveMigration()
                        .build();
            }catch(Exception e){
                Log.e("ERROR DATABASE",e.toString());
                return null;
            }

        }
        return instance;
    }

   public abstract VehicleHistoryDao vehicleHistoryDao();
    public abstract VehicleRegisteredDao vehicleRegisteredDao();
    public abstract QuerysDao querysDao();

}
