package model.domain.controler_domain.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface TipoCondicionDao {
    @Query("SELECT * FROM TipoCondicion")
    List<TipoCondicion> getSelect();

    @Insert
    void insertAll(TipoCondicion... tipoCondicion);

    @Insert
    void insert(TipoCondicion tipoCondicion);

    @Delete
    void delete(TipoCondicion tipoCondicion);

}
