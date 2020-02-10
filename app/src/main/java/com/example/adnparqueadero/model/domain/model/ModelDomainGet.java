package com.example.adnparqueadero.model.domain.model;

import android.content.Context;

import com.example.adnparqueadero.model.datos.database.ParqueaderoDatabase;
import com.example.adnparqueadero.model.domain.controler_domain.ControlerDomainDatosGet;


public class ModelDomainGet implements InterfaceDomainGet {
    private static ModelDomainGet instance;
    private InterfaceDomainGet controlerDomain;
    private Context context;

    public static ModelDomainGet getInstance(Context context){
        if(instance==null)
        {
            instance= new ModelDomainGet();
        }
        instance.controlerDomain= ControlerDomainDatosGet.getInstance(ParqueaderoDatabase.getInstance(context));
        return  instance;
    }

    @Override
    public void getSelectAllDiaSemana(final InterfaceRespuestas.CallbackHandlerRspArray callback) {
        controlerDomain.getSelectAllDiaSemana(new InterfaceRespuestas.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] respuesta) {
                callback.respuestaArray(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllTipoVehiculo(final InterfaceRespuestas.CallbackHandlerRspArray callback) {
        controlerDomain.getSelectAllTipoVehiculo(new InterfaceRespuestas.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] respuesta) {
                callback.respuestaArray(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllTipoCondicion(final InterfaceRespuestas.CallbackHandlerRspArray callback) {
        controlerDomain.getSelectAllTipoCondicion(new InterfaceRespuestas.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] respuesta) {
                callback.respuestaArray(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllTipoPrecios(final InterfaceRespuestas.CallbackHandlerRspArray callback) {
        controlerDomain.getSelectAllTipoPrecios(new InterfaceRespuestas.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] respuesta) {
                callback.respuestaArray(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllLimiteVehiculos(final InterfaceRespuestas.CallbackHandlerRspMatriz callback) {
        controlerDomain.getSelectAllLimiteVehiculos(new InterfaceRespuestas.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                callback.respuestaMatriz(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllLetraCondicion(final InterfaceRespuestas.CallbackHandlerRspMatriz callback) {
        controlerDomain.getSelectAllLetraCondicion(new InterfaceRespuestas.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                callback.respuestaMatriz(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllPrecios(final InterfaceRespuestas.CallbackHandlerRspMatriz callback) {
        controlerDomain.getSelectAllPrecios(new InterfaceRespuestas.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                callback.respuestaMatriz(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllPreciosCcMayor(final InterfaceRespuestas.CallbackHandlerRspMatriz callback) {
        controlerDomain.getSelectAllPreciosCcMayor(new InterfaceRespuestas.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                callback.respuestaMatriz(respuesta);
            }
        });
    }
}
