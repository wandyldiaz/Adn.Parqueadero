package com.example.adnparqueadero.model.domain.model;

public interface InterfaceModelDomain {

    void getSelectAllDiaSemana(final CallbackHandlerRspArray callback);
    void getSelectAllTipoVehiculo(final CallbackHandlerRspArray callback);

    interface CallbackHandlerRspArray {
        void RspArray(String[] Respuesta);
    }
}

