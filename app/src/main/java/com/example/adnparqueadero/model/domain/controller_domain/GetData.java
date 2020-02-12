package com.example.adnparqueadero.model.domain.controller_domain;

import com.example.adnparqueadero.model.datos.database.ParkingDatabase;
import com.example.adnparqueadero.model.service.RepositoryVehicle;


public class GetData implements RepositoryVehicle {
    private static GetData instance;
    private ParkingDatabase parkingDatabase;

    public static GetData getInstance(ParkingDatabase parkingDatabase){
       if(instance==null)
        {
            instance= new GetData();
        }
        instance.parkingDatabase =parkingDatabase;
        return  instance;
    }

    public void getSelectVehiculoHistorial() {
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
