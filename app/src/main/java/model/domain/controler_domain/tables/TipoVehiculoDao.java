package model.domain.controler_domain.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TipoVehiculoDao {
    @Query("SELECT * FROM TipoVehiculo")
    List<TipoVehiculo> getSelect();

    @Insert
    void insertAll(TipoVehiculo... tipoVehiculo);

    @Insert
    void insert(TipoVehiculo tipoVehiculo);

    @Delete
    void delete(TipoVehiculo tipoVehiculo);
}
