package administracion_datos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DiaSemanadDao {

    @Query("SELECT * FROM DiaSemana")
    List<DiaSemana> getSelect();

    @Insert
    void insertAll(DiaSemana... diasemana);

    @Delete
    void delete(DiaSemana diasemana);


}
