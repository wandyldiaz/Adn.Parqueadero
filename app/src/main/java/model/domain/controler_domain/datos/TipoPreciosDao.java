package model.domain.controler_domain.datos;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface TipoPreciosDao {

    @Query("SELECT * FROM TipoPrecios")
    List<TipoPrecios> getSelect();

    @Insert
    void insertAll(TipoPrecios... tipoPrecios);

    @Insert
    void insert(TipoPrecios tipoPrecios);

    @Delete
    void delete(TipoPrecios tipoPrecios);
}
