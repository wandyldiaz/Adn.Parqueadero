package com.example.adnparqueadero.model.domain.model;

import android.content.Context;

import com.example.adnparqueadero.model.domain.controler_domain.ControlerDomainDatos;


public class ModelDomain implements InterfaceModelDomain{
    private static ModelDomain instance;
    private Context context;
    private InterfaceModelDomain controlerDomain;

    public static ModelDomain getInstance(Context context){
        if(instance==null)
        {
            instance= new ModelDomain();
        }
        instance.context=context;
        instance.controlerDomain= ControlerDomainDatos.getInstance(context);
        return  instance;
    }

    @Override
    public void getSelectAllDiaSemana(final CallbackHandlerRspArray callback) {
        controlerDomain.getSelectAllDiaSemana(new InterfaceModelDomain.CallbackHandlerRspArray() {
            @Override
            public void RspArray(String[] Respuesta) {
                callback.RspArray(Respuesta);
            }
        });
    }

    @Override
    public void getSelectAllTipoVehiculo(final CallbackHandlerRspArray callback) {
        controlerDomain.getSelectAllTipoVehiculo(new InterfaceModelDomain.CallbackHandlerRspArray() {
            @Override
            public void RspArray(String[] Respuesta) {
                callback.RspArray(Respuesta);
            }
        });
    }
}
