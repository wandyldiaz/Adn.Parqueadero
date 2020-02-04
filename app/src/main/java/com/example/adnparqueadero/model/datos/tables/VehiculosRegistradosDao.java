package com.example.adnparqueadero.model.datos.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface VehiculosRegistradosDao {

    @Query("SELECT * FROM VehiculosRegistrados")
    List<VehiculosRegistrados> getSelect();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(VehiculosRegistrados... vehiculosRegistrados);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(VehiculosRegistrados vehiculosRegistrados);

    @Delete
    void delete(VehiculosRegistrados vehiculosRegistrados);

}
