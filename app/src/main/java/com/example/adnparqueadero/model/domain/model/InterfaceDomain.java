package com.example.adnparqueadero.model.domain.model;

public interface InterfaceDomain {

    void getSelectAllDiaSemana(CallbackHandlerRspArray callback);
    void getSelectAllTipoVehiculo(CallbackHandlerRspArray callback);
    void getSelectAllTipoCondicion(CallbackHandlerRspArray callback);
    void getSelectAllTipoPrecios(CallbackHandlerRspArray callback);
    void getSelectAllLimiteVehiculos(CallbackHandlerRspMatriz callback);
    void getSelectAllLetraCondicion(CallbackHandlerRspMatriz callback);
    void getSelectAllPrecios(CallbackHandlerRspMatriz callback);
    void getSelectAllPreciosCcMayor(CallbackHandlerRspMatriz callback);

    interface CallbackHandlerRspArray {
        void respuestaArray(String[] respuesta);
    }
    interface CallbackHandlerRspMatriz {
        void respuestaMatriz(String[][] respuesta);
    }
    interface CallbackHandlerRspString {
        void respuestaMatriz(String respuesta);
    }
}

