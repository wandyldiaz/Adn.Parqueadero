package com.example.adnparqueadero.model.datos.tables;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "DiaSemana")
public class DiaSemana{
    @PrimaryKey()
    @NonNull
    @ColumnInfo(name = "dianame")
    private String dianame;

    public DiaSemana(@NonNull String dianame)
    {
        this.dianame=dianame;
    }

    @NonNull
    public String getDianame(){
        return dianame;
    }
}
