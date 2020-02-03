package model.domain.controler_domain.datos;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface TipoCondicionDao {
    @Query("SELECT * FROM Precios")
    List<TipoCondicion> getSelect();

    @Insert
    void insertAll(TipoCondicion... tipoCondicion);

    @Insert
    void insert(TipoCondicion tipoCondicion);

    @Delete
    void delete(TipoCondicion tipoCondicion);

}
