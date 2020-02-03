package model.domain.controler_domain.tables;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "LetraCondicion")
public class LetraCondicion{
    @PrimaryKey(autoGenerate = true)
    private int idLetra;

    @ColumnInfo(name = "letra")
    private String letra;

    @ColumnInfo(name = "condicion")
    private String condicion;

    @ColumnInfo(name = "diasBloqueados")
    private String diasBloqueados;

    public LetraCondicion(int idLetra, String letra, String condicion, String diasBloqueados) {
        this.idLetra = idLetra;
        this.letra = letra;
        this.condicion = condicion;
        this.diasBloqueados = diasBloqueados;
    }

    public int getIdLetra() {
        return idLetra;
    }

    public String getLetra() {
        return letra;
    }

    public String getCondicion() {
        return condicion;
    }

    public String getDiasBloqueados() {
        return diasBloqueados;
    }



}
