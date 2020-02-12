package com.example.adnparqueadero.model.domain.model;

import android.content.Context;

import com.example.adnparqueadero.model.datos.database.ParkingDatabase;
import com.example.adnparqueadero.model.domain.controller_domain.GetData;
import com.example.adnparqueadero.model.service.RepositoryVehicle;


public class RepositoryVehicleModel implements RepositoryVehicle {
    private static RepositoryVehicleModel instance;
    private RepositoryVehicle getData;
    private Context context;

    public static RepositoryVehicleModel getInstance(Context context){
        if(instance==null)
        {
            instance= new RepositoryVehicleModel();
        }
        instance.getData= GetData.getInstance(ParkingDatabase.getInstance(context));
        return  instance;
    }
/*
    @Override
    public void getSelectAllPreciosCcMayor(final ReplyInterface.CallbackHandlerRspMatriz callback) {
        getData.getSelectAllPreciosCcMayor(new ReplyInterface.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                callback.respuestaMatriz(respuesta);
            }
        });
    }
    */
}
