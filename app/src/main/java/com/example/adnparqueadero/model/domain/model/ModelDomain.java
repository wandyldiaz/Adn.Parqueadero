package com.example.adnparqueadero.model.domain.model;

import android.content.Context;

import com.example.adnparqueadero.model.domain.controler_domain.ControlerDomainDatos;


public class ModelDomain implements InterfaceModelDomain{
    private static ModelDomain instance;
    private InterfaceModelDomain controlerDomain;

    public static ModelDomain getInstance(Context context){
        if(instance==null)
        {
            instance= new ModelDomain();
        }
        instance.controlerDomain= ControlerDomainDatos.getInstance(context);
        return  instance;
    }

    @Override
    public void getSelectAllDiaSemana(final CallbackHandlerRspArray callback) {
        controlerDomain.getSelectAllDiaSemana(new InterfaceModelDomain.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] respuesta) {
                callback.respuestaArray(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllTipoVehiculo(final CallbackHandlerRspArray callback) {
        controlerDomain.getSelectAllTipoVehiculo(new InterfaceModelDomain.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] respuesta) {
                callback.respuestaArray(respuesta);
            }
        });
    }

    @Override
    public void getSelectTipoCondicion(final CallbackHandlerRspArray callback) {
        controlerDomain.getSelectTipoCondicion(new InterfaceModelDomain.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] respuesta) {
                callback.respuestaArray(respuesta);
            }
        });
    }

    @Override
    public void getSelectAllLimiteVehiculos(final CallbackHandlerRspMatriz callback) {
        controlerDomain.getSelectAllLimiteVehiculos(new InterfaceModelDomain.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                callback.respuestaMatriz(respuesta);
            }
        });
    }
}
