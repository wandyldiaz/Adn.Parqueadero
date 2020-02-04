package com.example.adnparqueadero.model.datos.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface PreciosDao {

    @Query("SELECT * FROM Precios")
    List<Precios> getSelectAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Precios... precios);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Precios precios);

    @Delete
    void delete(Precios precios);
}
