package com.example.adnparqueadero.model.datos.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface LimiteVehiculosDao {
    @Query("SELECT * FROM LimiteVehiculos")
    List<LimiteVehiculos> getSelectAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(LimiteVehiculos... limiteVehiculos);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(LimiteVehiculos limiteVehiculos);

    @Delete
    void delete(LimiteVehiculos limiteVehiculos);
}
