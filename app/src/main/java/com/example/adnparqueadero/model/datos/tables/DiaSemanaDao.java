package com.example.adnparqueadero.model.datos.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DiaSemanaDao {

    @Query("SELECT * FROM DiaSemana")
    List<DiaSemana> getSelectAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(DiaSemana... diasemana);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(DiaSemana diasemana);

    @Delete
    void delete(DiaSemana diasemana);


}
