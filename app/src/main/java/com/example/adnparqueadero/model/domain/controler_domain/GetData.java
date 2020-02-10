package com.example.adnparqueadero.model.domain.controler_domain;

import com.example.adnparqueadero.model.datos.database.AbstractParkingDatabase;
import com.example.adnparqueadero.model.domain.model.GetDataInterface;
import com.example.adnparqueadero.model.domain.model.ReplyInterface;


public class GetData implements GetDataInterface {
    private static GetData instance;
    private AbstractParkingDatabase parkingDatabase;

    public static GetData getInstance(AbstractParkingDatabase parkingDatabase){
       if(instance==null)
        {
            instance= new GetData();
        }
        instance.parkingDatabase =parkingDatabase;
        return  instance;
    }

    public void getSelectVehiculoHistorial(final ReplyInterface.CallbackHandlerReplyArray callback) {
/*
        try {
            new Thread(new Runnable() {
                public void run() {
                    String [] diasSemana;
                    dias = parkingDatabase.diaSemanaDao().getSelectAll();
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
        */
    }

}
