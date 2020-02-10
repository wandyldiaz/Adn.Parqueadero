package com.example.adnparqueadero.model.domain.model;

public interface InterfaceRespuestas {
    interface CallbackHandlerRspArray {
        void respuestaArray(String[] respuesta);
    }
    interface CallbackHandlerRspMatriz {
        void respuestaMatriz(String[][] respuesta);
    }
    interface CallbackHandlerRspString {
        void respuestaMatriz(String respuesta);
    }
    interface CallbackHandlerRspBoolean {
        void respuestaBoolean(boolean respuesta);
    }
}
