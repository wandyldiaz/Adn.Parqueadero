package com.example.adnparqueadero.model.domain.controler_domain;

import android.content.Context;
import android.util.Log;

import com.example.adnparqueadero.model.datos.database.ParqueaderoDatabase;
import com.example.adnparqueadero.model.datos.tables.DiaSemana;
import com.example.adnparqueadero.model.datos.tables.LimiteVehiculos;
import com.example.adnparqueadero.model.datos.tables.TipoCondicion;
import com.example.adnparqueadero.model.datos.tables.TipoVehiculo;
import com.example.adnparqueadero.model.domain.model.InterfaceModelDomain;

import java.util.List;

public class ControlerDomainDatos implements InterfaceModelDomain {
    private static ControlerDomainDatos instance;
    private Context context;
    private ParqueaderoDatabase parqueadero;
    private List<DiaSemana> dias;
    private List<TipoVehiculo> tipoVehiculos;
    private List<LimiteVehiculos> limiteVehiculos;
    private List<TipoCondicion> tipoCondicion;

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
                    String [] diasSemana;
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
                    }
                    diasSemana = new String[dias.size()];
                    for (int i = 0; i < dias.size(); i++) {
                        diasSemana[i] = dias.get(i).getDianame();
                    }
                    callback.respuestaArray(diasSemana);
                }
            }).start();
        }catch(Exception e){
            Log.e("Error AllDiaSemana",e.toString());
            callback.respuestaArray(new String[]{""});
        }
    }

    @Override
    public void getSelectAllTipoVehiculo(final CallbackHandlerRspArray callback) {
        tipoVehiculos =null;
        try {
            parqueadero = ParqueaderoDatabase.getInstance(context);
            new Thread(new Runnable() {
                public void run() {
                    String [] tipoVehiculo;
                    tipoVehiculos = parqueadero.tipoVehiculoDao().getSelectAll();
                    if (tipoVehiculos.isEmpty()) {
                        TipoVehiculo[] tipVehiculo=new TipoVehiculo[2];
                        tipVehiculo[0] = new TipoVehiculo("Carro");
                        tipVehiculo[1] = new TipoVehiculo("Moto");
                        parqueadero.tipoVehiculoDao().insertAll(tipVehiculo);
                        tipoVehiculos = parqueadero.tipoVehiculoDao().getSelectAll();
                    }
                    tipoVehiculo = new String[tipoVehiculos.size()];
                    for (int i = 0; i < tipoVehiculos.size(); i++) {
                        tipoVehiculo[i] = tipoVehiculos.get(i).getVehiculo();
                    }
                    callback.respuestaArray(tipoVehiculo);
                }
            }).start();
        }catch(Exception e){
            Log.e("Error AllTipoVehiculo",e.toString());
            callback.respuestaArray(new String[]{""});
        }
    }

    @Override
    public void getSelectTipoCondicion(final CallbackHandlerRspArray callback) {
        tipoCondicion=null;
        try {
            parqueadero = ParqueaderoDatabase.getInstance(context);
            new Thread(new Runnable() {
                public void run() {
                    String [] tipoCondicionArray;
                    tipoCondicion = parqueadero.tipoCondicionDao().getSelectAll();
                    if (tipoCondicion.isEmpty()) {
                        TipoCondicion[] tipoCondicions=new TipoCondicion[1];
                        tipoCondicions[0] = new TipoCondicion("Inicio");
                        parqueadero.tipoCondicionDao().insertAll(tipoCondicions);
                        tipoCondicion = parqueadero.tipoCondicionDao().getSelectAll();
                    }
                    tipoCondicionArray = new String[tipoCondicion.size()];
                    for (int i = 0; i < tipoCondicion.size(); i++) {
                        tipoCondicionArray[i] = tipoCondicion.get(i).getTipCondicion();
                    }
                    callback.respuestaArray(tipoCondicionArray);
                }
            }).start();
        }catch(Exception e){
            Log.e("Error AllDiaSemana",e.toString());
            callback.respuestaArray(new String[]{""});
        }
    }

    @Override
    public void getSelectAllLimiteVehiculos(final CallbackHandlerRspMatriz callback) {
        limiteVehiculos=null;
        try {
            getSelectAllTipoVehiculo(new InterfaceModelDomain.CallbackHandlerRspArray() {
                @Override
                public void respuestaArray(final String[] respuesta) {
                    new Thread(new Runnable() {
                        public void run() {
                            String[][] limitVehiculos=new String[][]{{""},{""}};
                            if (respuesta==null) {
                                callback.respuestaMatriz(limitVehiculos);
                                return;
                            }
                            limiteVehiculos = parqueadero.limiteVehiculosDao().getSelectAll();
                            if (limiteVehiculos.isEmpty()) {
                                LimiteVehiculos[] limitVehiculosInsertar = new LimiteVehiculos[respuesta.length];
                                for (int i = 0; i < respuesta.length; i++) {
                                    limitVehiculosInsertar[i] = new LimiteVehiculos(0, respuesta[i]);
                                }
                                parqueadero.limiteVehiculosDao().insertAll(limitVehiculosInsertar);
                                limiteVehiculos = parqueadero.limiteVehiculosDao().getSelectAll();
                            }
                            limitVehiculos = new String[respuesta.length][2];
                            for (int i = 0; i < respuesta.length; i++) {
                                limitVehiculos[i][0]=limiteVehiculos.get(i).getTipoVehiculo();
                                limitVehiculos[i][1]= String.valueOf(limiteVehiculos.get(i).getCantidad());
                            }
                            callback.respuestaMatriz(limitVehiculos);
                        }
                    }).start();
                }
            });
        }catch(Exception e){
            Log.e("Error AllLimiteVehiculo",e.toString());
            callback.respuestaMatriz(new String[][]{{""},{""}});
        }
    }
}
