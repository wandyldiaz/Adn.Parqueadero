package model.domain.controler_domain.tables;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "DiaSemana")
public class DiaSemana{
    @PrimaryKey()
    @NonNull
    private String dianame;

    public DiaSemana(String dianame)
    {
        this.dianame=dianame;
    }
    public String getDianame(){
        return dianame;
    }
}
