package model.domain.controler_domain.datos;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

public interface PreciosDao {

    @Query("SELECT * FROM Precios")
    List<Precios> getSelect();

    @Insert
    void insertAll(Precios... precios);

    @Insert
    void insert(Precios precios);

    @Delete
    void delete(Precios precios);
}
