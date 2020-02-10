package com.example.adnparqueadero.model.domain.controler_domain;

import android.util.Log;

import com.example.adnparqueadero.model.datos.database.ParqueaderoDatabase;
import com.example.adnparqueadero.model.datos.tables.DiaSemana;
import com.example.adnparqueadero.model.datos.tables.TipoCondicion;
import com.example.adnparqueadero.model.datos.tables.TipoPrecios;
import com.example.adnparqueadero.model.datos.tables.TipoVehiculo;
import com.example.adnparqueadero.model.domain.model.InterfaceRespuestas.CallbackHandlerRspBoolean;

public class DatosDefault {
    private ParqueaderoDatabase parqueadero;
    DiaSemana[] dia;
    TipoVehiculo[] tipVehiculo;

    public DatosDefault( ParqueaderoDatabase parqueaderoDatabase) {
        this.parqueadero = parqueaderoDatabase;
    }

    private boolean verificarDiasSemana(){
        if (parqueadero.diaSemanaDao().getSelectAll().isEmpty()) {
            dia=new DiaSemana[7];
            dia[0] = new DiaSemana("Domingo");
            dia[1] = new DiaSemana("Lunes");
            dia[2] = new DiaSemana("Martes");
            dia[3] = new DiaSemana("Miercoles");
            dia[4] = new DiaSemana("Jueves");
            dia[5] = new DiaSemana("Viernes");
            dia[6] = new DiaSemana("Sabado");
            parqueadero.diaSemanaDao().insertAll(dia);
            return !parqueadero.diaSemanaDao().getSelectAll().isEmpty();
        }
        return true;
    }

    private boolean verificarTipoVehiculo(){
        if (parqueadero.tipoVehiculoDao().getSelectAll().isEmpty()) {
            tipVehiculo=new TipoVehiculo[2];
            tipVehiculo[0] = new TipoVehiculo("Carro");
            tipVehiculo[1] = new TipoVehiculo("Moto");
            parqueadero.tipoVehiculoDao().insertAll(tipVehiculo);
            return !parqueadero.tipoVehiculoDao().getSelectAll().isEmpty();
        }
        return true;
    }

    private boolean verificarTipoCondicion(){
        if (parqueadero.tipoCondicionDao().getSelectAll().isEmpty()) {
            TipoCondicion[] tipoCondicions=new TipoCondicion[1];
            tipoCondicions[0] = new TipoCondicion("Inicio");
            parqueadero.tipoCondicionDao().insertAll(tipoCondicions);
            return !parqueadero.tipoCondicionDao().getSelectAll().isEmpty();
        }
        return true;
    }
    private boolean verificarTipoPrecios(){
        if (parqueadero.tipoPreciosDao().getSelectAll().isEmpty()) {
            TipoPrecios[] tipoPreciosArrayClass =new TipoPrecios[2];
            tipoPreciosArrayClass[0] = new TipoPrecios("Hora");
            tipoPreciosArrayClass[1] = new TipoPrecios("Dia");
            parqueadero.tipoPreciosDao().insertAll(tipoPreciosArrayClass);
            return !parqueadero.tipoPreciosDao().getSelectAll().isEmpty();
        }
        return true;
    }

    private void iniciarVerificacion(final CallbackHandlerRspBoolean callback){
        try {
            new Thread(new Runnable() {
                public void run() {
                    boolean respuestaMetodo;
                    boolean respuesta=true;
                    respuestaMetodo= verificarDiasSemana();
                    if(!respuestaMetodo)
                        respuesta=respuestaMetodo;
                    respuestaMetodo= verificarTipoVehiculo();
                    if(!respuestaMetodo)
                        respuesta=respuestaMetodo;
                    respuestaMetodo= verificarTipoCondicion();
                    if(!respuestaMetodo)
                        respuesta=respuestaMetodo;
                    respuestaMetodo= verificarTipoPrecios();
                    if(!respuestaMetodo)
                        respuesta=respuestaMetodo;
                    callback.respuestaBoolean(respuesta);
                }
            }).start();
        }catch(Exception e){
            Log.e("Error verificacion",e.toString());
            callback.respuestaBoolean(false);
        }
    }

    public void verificacionDatosDefault(final CallbackHandlerRspBoolean callback){
        iniciarVerificacion(new CallbackHandlerRspBoolean() {
            @Override
            public void respuestaBoolean(boolean respuesta) {
                callback.respuestaBoolean(true);
            }
        });
    }
}
