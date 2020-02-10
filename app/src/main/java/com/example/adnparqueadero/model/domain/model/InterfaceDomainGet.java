package com.example.adnparqueadero.model.domain.model;

public interface InterfaceDomainGet {

    void getSelectAllDiaSemana(InterfaceRespuestas.CallbackHandlerRspArray callback);
    void getSelectAllTipoVehiculo(InterfaceRespuestas.CallbackHandlerRspArray callback);
    void getSelectAllTipoCondicion(InterfaceRespuestas.CallbackHandlerRspArray callback);
    void getSelectAllTipoPrecios(InterfaceRespuestas.CallbackHandlerRspArray callback);
    void getSelectAllLimiteVehiculos(InterfaceRespuestas.CallbackHandlerRspMatriz callback);
    void getSelectAllLetraCondicion(InterfaceRespuestas.CallbackHandlerRspMatriz callback);
    void getSelectAllPrecios(InterfaceRespuestas.CallbackHandlerRspMatriz callback);
    void getSelectAllPreciosCcMayor(InterfaceRespuestas.CallbackHandlerRspMatriz callback);


}

