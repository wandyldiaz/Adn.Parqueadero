package com.example.adnparqueadero.model.datos.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface PreciosCcMayorDao {

    @Query("SELECT * FROM PreciosCcMayor")
    List<PreciosCcMayor> getSelectAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(PreciosCcMayor... preciosCcMayor);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(PreciosCcMayor preciosCcMayor);

    @Delete
    void delete(PreciosCcMayor preciosCcMayor);
}
