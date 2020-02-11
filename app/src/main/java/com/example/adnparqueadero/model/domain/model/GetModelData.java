package com.example.adnparqueadero.model.domain.model;

import android.content.Context;

import com.example.adnparqueadero.model.datos.database.ParkingDatabase;
import com.example.adnparqueadero.model.domain.controler_domain.GetData;
import com.example.adnparqueadero.model.service.GetServiceData;


public class GetModelData implements GetServiceData {
    private static GetModelData instance;
    private GetServiceData getData;
    private Context context;

    public static GetModelData getInstance(Context context){
        if(instance==null)
        {
            instance= new GetModelData();
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
