package model.domain.controler_domain.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
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
