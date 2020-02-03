package model.domain.controler_domain.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
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
