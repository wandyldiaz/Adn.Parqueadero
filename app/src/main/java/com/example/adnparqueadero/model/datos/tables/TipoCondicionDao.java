package com.example.adnparqueadero.model.datos.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TipoCondicionDao {
    @Query("SELECT * FROM TipoCondicion")
    List<TipoCondicion> getSelectAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(TipoCondicion... tipoCondicion);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(TipoCondicion tipoCondicion);

    @Delete
    void delete(TipoCondicion tipoCondicion);

}
