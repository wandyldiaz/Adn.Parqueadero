package model.domain.controler_domain.tables;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;
@Dao
public interface LetraCondicionDao {
    @Query("SELECT * FROM LetraCondicion")
    List<LetraCondicion> getSelect();

    @Insert
    void insertAll(LetraCondicion... letraCondicion);

    @Insert
    void insert(LetraCondicion letraCondicion);

    @Delete
    void delete(LetraCondicion letraCondicion);

}
