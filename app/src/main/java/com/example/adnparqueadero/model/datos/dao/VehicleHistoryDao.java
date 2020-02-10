package com.example.adnparqueadero.model.datos.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.adnparqueadero.model.datos.tables.VehicleHistory;

import java.util.List;
@Dao
public interface VehicleHistoryDao {

    @Query("SELECT idVehicleHistory, licencePlate, dateEntry, timeEntry, dateExit, timeExit, hoursParked, amountCharged FROM vehicleHistory where licencePlate ==:licencePlate")
    List<VehicleHistoryData> getSelect(String licencePlate);

    @Insert
    void insert(VehicleHistory vehicleHistory);

    @Update
    void Update(VehicleHistory vehicleHistory);

    class VehicleHistoryData {
        public int idVehicleHistory;
        public String licencePlate;
        public String dateEntry;
        public String timeEntry;
        public String dateExit;
        public String timeExit;
        public int hoursParked;
    }

}
