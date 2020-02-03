package model.domain.controler_domain.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface VehiculoHistorialDao {

    @Query("SELECT * FROM VehiculoHistorial")
    List<VehiculoHistorial> getSelect();

    @Insert
    void insertAll(VehiculoHistorial... vehiculoHistorial);

    @Insert
    void insert(VehiculoHistorial vehiculoHistorial);

    @Delete
    void delete(VehiculoHistorial vehiculoHistorial);

}