package com.example.adnparqueadero.model.domain.model;

import android.content.Context;

import com.example.adnparqueadero.model.datos.database.ParqueaderoDatabase;
import com.example.adnparqueadero.model.domain.controler_domain.ControlerDomainDatos;


public class ModelDomain implements InterfaceDomain {
    private static ModelDomain instance;
    private InterfaceDomain controlerDomain;
    private Context context;

    public static ModelDomain getInstance(Context context){
        if(instance==null)
        {
            instance= new ModelDomain();
        }
        instance.controlerDomain=ControlerDomainDatos.getInstance(ParqueaderoDatabase.getInstance(context));
        return  instance;
    }

    @Override
    public void getSelectAllDiaSemana(final CallbackHandlerRspArray callback) {
        controlerDomain.getSelectAllDiaSemana(new InterfaceDomain.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] respuesta) {
                callback.respuestaArray(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllTipoVehiculo(final CallbackHandlerRspArray callback) {
        controlerDomain.getSelectAllTipoVehiculo(new InterfaceDomain.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] respuesta) {
                callback.respuestaArray(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllTipoCondicion(final CallbackHandlerRspArray callback) {
        controlerDomain.getSelectAllTipoCondicion(new InterfaceDomain.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] respuesta) {
                callback.respuestaArray(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllTipoPrecios(final CallbackHandlerRspArray callback) {
        controlerDomain.getSelectAllTipoPrecios(new InterfaceDomain.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] respuesta) {
                callback.respuestaArray(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllLimiteVehiculos(final CallbackHandlerRspMatriz callback) {
        controlerDomain.getSelectAllLimiteVehiculos(new InterfaceDomain.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                callback.respuestaMatriz(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllLetraCondicion(final CallbackHandlerRspMatriz callback) {
        controlerDomain.getSelectAllLetraCondicion(new InterfaceDomain.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                callback.respuestaMatriz(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllPrecios(final CallbackHandlerRspMatriz callback) {
        controlerDomain.getSelectAllPrecios(new InterfaceDomain.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                callback.respuestaMatriz(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllPreciosCcMayor(final CallbackHandlerRspMatriz callback) {
        controlerDomain.getSelectAllPreciosCcMayor(new InterfaceDomain.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                callback.respuestaMatriz(respuesta);
            }
        });
    }
}
