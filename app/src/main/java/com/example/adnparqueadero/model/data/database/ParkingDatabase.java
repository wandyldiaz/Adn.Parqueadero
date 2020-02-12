package com.example.adnparqueadero.model.data.database;


import android.content.Context;
import android.util.Log;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.example.adnparqueadero.model.data.database.dao.QuerysDao;
import com.example.adnparqueadero.model.data.database.dao.VehicleHistoryDao;
import com.example.adnparqueadero.model.data.database.dao.VehicleRegisteredDao;
import com.example.adnparqueadero.model.data.database.tables.VehicleHistory;
import com.example.adnparqueadero.model.data.database.tables.VehicleRegistered;
import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

@Module
@Database(entities ={VehicleHistory.class, VehicleRegistered.class},exportSchema = false, version =1)
public abstract class ParkingDatabase extends RoomDatabase {
    private  static final String DB_NAME="parking_db";

    @Singleton
    @Provides
    public ParkingDatabase getInstance(Context context){
            try {
                return Room.databaseBuilder(context, ParkingDatabase.class, DB_NAME).fallbackToDestructiveMigration()
                        .build();
            }catch(Exception e){
                Log.e("ERROR DATABASE",e.toString());
                return null;
            }
    }

    public abstract VehicleHistoryDao vehicleHistoryDao();
    public abstract VehicleRegisteredDao vehicleRegisteredDao();
    public abstract QuerysDao querysDao();

}
