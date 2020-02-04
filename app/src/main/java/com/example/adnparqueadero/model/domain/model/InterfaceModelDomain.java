package com.example.adnparqueadero.model.domain.model;

public interface InterfaceModelDomain {

    void getSelectAllDiaSemana(CallbackHandlerRspArray callback);
    void getSelectAllTipoVehiculo(CallbackHandlerRspArray callback);
    void getSelectTipoCondicion(CallbackHandlerRspArray callback);
    void getSelectAllLimiteVehiculos(CallbackHandlerRspMatriz callback);

    interface CallbackHandlerRspArray {
        void respuestaArray(String[] respuesta);
    }
    interface CallbackHandlerRspMatriz {
        void respuestaMatriz(String[][] respuesta);
    }
}

