package administracion_datos;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "DiaSemana")
public class DiaSemana{
    @PrimaryKey()
    private String dianame;

    public DiaSemana(String dianame)
    {
        this.dianame=dianame;
    }
    public String getDianame(){
        return dianame;
    }
}
