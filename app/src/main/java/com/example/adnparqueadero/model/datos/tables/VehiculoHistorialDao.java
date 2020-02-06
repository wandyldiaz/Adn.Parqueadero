package com.example.adnparqueadero.model.datos.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface VehiculoHistorialDao {

    @Query("SELECT * FROM VehiculoHistorial")
    List<VehiculoHistorial> getSelectAll();

    @Insert
    void insertAll(VehiculoHistorial... vehiculoHistorial);

    @Insert
    void insert(VehiculoHistorial vehiculoHistorial);

    @Update
    void Update(VehiculoHistorial vehiculoHistorial);

    @Delete
    void delete(VehiculoHistorial vehiculoHistorial);

}
