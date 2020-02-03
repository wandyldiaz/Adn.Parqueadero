package model.domain.controler_domain.datos;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

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
