package com.example.adnparqueadero.model.datos.database;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.adnparqueadero.model.datos.tables.DiaSemana;
import com.example.adnparqueadero.model.datos.tables.DiaSemanaDao;
import com.example.adnparqueadero.model.datos.tables.LetraCondicion;
import com.example.adnparqueadero.model.datos.tables.LetraCondicionDao;
import com.example.adnparqueadero.model.datos.tables.LimiteVehiculos;
import com.example.adnparqueadero.model.datos.tables.LimiteVehiculosDao;
import com.example.adnparqueadero.model.datos.tables.Precios;
import com.example.adnparqueadero.model.datos.tables.PreciosDao;
import com.example.adnparqueadero.model.datos.tables.TipoCondicion;
import com.example.adnparqueadero.model.datos.tables.TipoCondicionDao;
import com.example.adnparqueadero.model.datos.tables.TipoPrecios;
import com.example.adnparqueadero.model.datos.tables.TipoPreciosDao;
import com.example.adnparqueadero.model.datos.tables.TipoVehiculo;
import com.example.adnparqueadero.model.datos.tables.TipoVehiculoDao;
import com.example.adnparqueadero.model.datos.tables.VehiculoHistorial;
import com.example.adnparqueadero.model.datos.tables.VehiculoHistorialDao;
import com.example.adnparqueadero.model.datos.tables.VehiculosRegistrados;
import com.example.adnparqueadero.model.datos.tables.VehiculosRegistradosDao;

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
