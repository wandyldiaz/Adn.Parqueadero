package model.domain.controler_domain.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface VehiculosRegistradosDao {

    @Query("SELECT * FROM VehiculosRegistrados")
    List<VehiculosRegistrados> getSelect();

    @Insert
    void insertAll(VehiculosRegistrados... vehiculosRegistrados);

    @Insert
    void insert(VehiculosRegistrados vehiculosRegistrados);

    @Delete
    void delete(VehiculosRegistrados vehiculosRegistrados);

}
