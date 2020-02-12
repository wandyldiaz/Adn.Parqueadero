package com.example.adnparqueadero.model.data.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.example.adnparqueadero.model.data.dto.VehicleHistoryData;
import com.example.adnparqueadero.model.data.database.tables.VehicleHistory;
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

}
