package com.example.adnparqueadero.model.datos.dao;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.adnparqueadero.model.datos.tables.VehicleHistory;

import java.util.List;

@Dao
public interface VehicleHistoryDao {

    @Query("SELECT idVehicleHistory, licencePlate, dateEntry, timeEntry, dateExit, timeExit, hoursParked, amountCharged " +
            "FROM vehicleHistory where dateExit = \"\" and licencePlate like :licencePlate Limit 1")
    VehicleHistoryData getSelectVehicleEntered(String licencePlate);

    @Query("SELECT idVehicleHistory, licencePlate, dateEntry, timeEntry, dateExit, timeExit, hoursParked, amountCharged " +
            "FROM vehicleHistory where dateExit == \"\"")
    List<VehicleHistoryData> getSelectVehicleEntered();


    @Insert
    Long insert(VehicleHistory vehicleHistory);

    @Update
    int update(VehicleHistory vehicleHistory);

    class VehicleHistoryData {
        @ColumnInfo(name = "idVehicleHistory")
        public int idVehicleHistory;
        @ColumnInfo(name = "licencePlate")
        public String licencePlate;
        @ColumnInfo(name = "dateEntry")
        public String dateEntry;
        @ColumnInfo(name = "timeEntry")
        public String timeEntry;
        @ColumnInfo(name = "dateExit")
        public String dateExit;
        @ColumnInfo(name = "timeExit")
        public String timeExit;
        @ColumnInfo(name = "hoursParked")
        public int hoursParked;
        @ColumnInfo(name = "amountCharged")
        public int amountCharged;
    }

}
