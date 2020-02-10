package com.example.adnparqueadero.model.domain.model;

import android.content.Context;

import com.example.adnparqueadero.model.datos.database.AbstractParkingDatabase;
import com.example.adnparqueadero.model.domain.controler_domain.GetData;


public class GetDataModel implements GetDataInterface {
    private static GetDataModel instance;
    private GetDataInterface getData;
    private Context context;

    public static GetDataModel getInstance(Context context){
        if(instance==null)
        {
            instance= new GetDataModel();
        }
        instance.getData= GetData.getInstance(AbstractParkingDatabase.getInstance(context));
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
