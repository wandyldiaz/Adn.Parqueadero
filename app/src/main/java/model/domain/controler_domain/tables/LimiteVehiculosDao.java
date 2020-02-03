package model.domain.controler_domain.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface LimiteVehiculosDao {
    @Query("SELECT * FROM LimiteVehiculos")
    List<LimiteVehiculos> getSelect();

    @Insert
    void insertAll(LimiteVehiculos... limiteVehiculos);

    @Insert
    void insert(LimiteVehiculos limiteVehiculos);

    @Delete
    void delete(LimiteVehiculos limiteVehiculos);
}
