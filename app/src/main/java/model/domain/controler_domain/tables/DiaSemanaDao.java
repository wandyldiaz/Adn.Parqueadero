package model.domain.controler_domain.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DiaSemanaDao {

    @Query("SELECT * FROM DiaSemana")
    List<DiaSemana> getSelect();

    @Insert
    void insertAll(DiaSemana... diasemana);

    @Insert
    void insert(DiaSemana diasemana);

    @Delete
    void delete(DiaSemana diasemana);


}
