package com.example.adnparqueadero.model.datos.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TipoPreciosDao {

    @Query("SELECT * FROM TipoPrecios")
    List<TipoPrecios> getSelectAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(TipoPrecios... tipoPrecios);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TipoPrecios tipoPrecios);

    @Delete
    void delete(TipoPrecios tipoPrecios);
}
