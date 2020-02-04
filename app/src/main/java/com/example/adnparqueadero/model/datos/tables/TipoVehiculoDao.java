package com.example.adnparqueadero.model.datos.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TipoVehiculoDao {
    @Query("SELECT * FROM TipoVehiculo")
    List<TipoVehiculo> getSelectAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(TipoVehiculo... tipoVehiculo);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TipoVehiculo tipoVehiculo);

    @Delete
    void delete(TipoVehiculo tipoVehiculo);
}
