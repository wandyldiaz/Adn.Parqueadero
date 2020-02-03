package model.domain.controler_domain.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import model.domain.controler_domain.tables.DiaSemana;
import model.domain.controler_domain.tables.DiaSemanaDao;
import model.domain.controler_domain.tables.LetraCondicion;
import model.domain.controler_domain.tables.LetraCondicionDao;
import model.domain.controler_domain.tables.LimiteVehiculos;
import model.domain.controler_domain.tables.LimiteVehiculosDao;
import model.domain.controler_domain.tables.Precios;
import model.domain.controler_domain.tables.PreciosDao;
import model.domain.controler_domain.tables.TipoCondicion;
import model.domain.controler_domain.tables.TipoCondicionDao;
import model.domain.controler_domain.tables.TipoPrecios;
import model.domain.controler_domain.tables.TipoPreciosDao;
import model.domain.controler_domain.tables.TipoVehiculo;
import model.domain.controler_domain.tables.TipoVehiculoDao;
import model.domain.controler_domain.tables.VehiculoHistorial;
import model.domain.controler_domain.tables.VehiculoHistorialDao;
import model.domain.controler_domain.tables.VehiculosRegistrados;
import model.domain.controler_domain.tables.VehiculosRegistradosDao;

@Database(entities ={DiaSemana.class, LetraCondicion.class, LimiteVehiculos.class,
        Precios.class, TipoCondicion.class, TipoPrecios.class, TipoVehiculo.class,
        VehiculoHistorial.class, VehiculosRegistrados.class},exportSchema = false, version =1)
public abstract class ParqueaderoDatabase extends RoomDatabase {
    private  static final String DB_NAME="parqueadero_db";
    private static ParqueaderoDatabase instance;

    public static  synchronized ParqueaderoDatabase getInstance(Context context){
        if(instance==null){
            try {
                instance = Room.databaseBuilder(context, ParqueaderoDatabase.class, DB_NAME).fallbackToDestructiveMigration()
                        .build();
            }catch(Exception e){
                e.printStackTrace();
                return null;
            }

        }

        return instance;
    }
   public abstract DiaSemanaDao diaSemanaDao();
   public abstract LetraCondicionDao letraCondicionDao();
   public abstract LimiteVehiculosDao limiteVehiculosDao();
   public abstract PreciosDao preciosDao();
   public abstract TipoCondicionDao tipoCondicionDao();
   public abstract TipoPreciosDao tipoPreciosDao();
   public abstract TipoVehiculoDao tipoVehiculoDao();
   public abstract VehiculoHistorialDao vehiculoHistorialDao();
   public abstract VehiculosRegistradosDao vehiculosRegistradosDao();

}
