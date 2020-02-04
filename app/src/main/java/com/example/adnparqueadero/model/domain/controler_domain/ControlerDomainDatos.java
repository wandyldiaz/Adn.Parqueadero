package com.example.adnparqueadero.model.domain.controler_domain;

import android.content.Context;
import android.util.Log;

import com.example.adnparqueadero.model.datos.database.ParqueaderoDatabase;
import com.example.adnparqueadero.model.datos.tables.DiaSemana;
import com.example.adnparqueadero.model.datos.tables.TipoVehiculo;
import com.example.adnparqueadero.model.domain.model.InterfaceModelDomain;

import java.util.List;

public class ControlerDomainDatos implements InterfaceModelDomain {
    private static ControlerDomainDatos instance;
    private Context context;
    private ParqueaderoDatabase parqueadero;
    private List<DiaSemana> dias;
    private List<TipoVehiculo> tipoVehiculos;

    public static ControlerDomainDatos getInstance(Context context){
       if(instance==null)
        {
            instance= new ControlerDomainDatos();
            instance.context=context;
        }
        return  instance;
    }


    @Override
    public void getSelectAllDiaSemana(final CallbackHandlerRspArray callback) {
        dias=null;
        try {
            parqueadero = ParqueaderoDatabase.getInstance(context);
            new Thread(new Runnable() {
                public void run() {
                    String [] diasSemana={""};
                    dias = parqueadero.diaSemanaDao().getSelectAll();
                    if (dias.isEmpty()) {
                        DiaSemana[] dia=new DiaSemana[7];
                        dia[0] = new DiaSemana("Domingo");
                        dia[1] = new DiaSemana("Lunes");
                        dia[2] = new DiaSemana("Martes");
                        dia[3] = new DiaSemana("Miercoles");
                        dia[4] = new DiaSemana("Jueves");
                        dia[5] = new DiaSemana("Viernes");
                        dia[6] = new DiaSemana("Sabado");
                        parqueadero.diaSemanaDao().insertAll(dia);
                        dias = parqueadero.diaSemanaDao().getSelectAll();

                        if (!dias.isEmpty()) {
                            diasSemana = new String[dias.size()];
                            for (int i = 0; i < dias.size(); i++) {
                                diasSemana[i] = dias.get(i).getDianame();
                            }
                        }
                    }
                    else{
                        diasSemana = new String[7];
                        for (int i = 0; i < 7; i++) {
                            diasSemana[i] = dias.get(i).getDianame();
                        }
                    }
                    callback.RspArray(diasSemana);
                }
            }).start();
        }catch(Exception e){
            Log.e("Error",e.toString());
            callback.RspArray(new String[]{""});
        }
    }

    @Override
    public void getSelectAllTipoVehiculo(final CallbackHandlerRspArray callback) {
        tipoVehiculos =null;
        try {
            parqueadero = ParqueaderoDatabase.getInstance(context);
            new Thread(new Runnable() {
                public void run() {
                    String [] tipoVehiculo={""};
                    tipoVehiculos = parqueadero.tipoVehiculoDao().getSelectAll();
                    if (tipoVehiculos.isEmpty()) {
                        TipoVehiculo[] tipVehiculo=new TipoVehiculo[2];
                        tipVehiculo[0] = new TipoVehiculo("Carro");
                        tipVehiculo[1] = new TipoVehiculo("Moto");
                        parqueadero.tipoVehiculoDao().insertAll(tipVehiculo);
                        tipoVehiculos = parqueadero.tipoVehiculoDao().getSelectAll();
                        if (!tipoVehiculos.isEmpty()) {
                            tipoVehiculo = new String[tipoVehiculos.size()];
                            for (int i = 0; i < tipoVehiculos.size(); i++) {
                                tipoVehiculo[i] = tipoVehiculos.get(i).getVehiculo();
                            }
                        }
                    }
                    else{
                        tipoVehiculo = new String[tipoVehiculos.size()];
                        for (int i = 0; i < tipoVehiculos.size(); i++) {
                            tipoVehiculo[i] = tipoVehiculos.get(i).getVehiculo();
                        }
                    }
                    callback.RspArray(tipoVehiculo);
                }
            }).start();
        }catch(Exception e){
            Log.e("Error",e.toString());
            callback.RspArray(new String[]{""});
        }
    }
}
