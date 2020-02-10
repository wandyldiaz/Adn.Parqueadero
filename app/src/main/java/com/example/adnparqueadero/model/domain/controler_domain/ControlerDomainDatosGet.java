package com.example.adnparqueadero.model.domain.controler_domain;

import android.util.Log;

import com.example.adnparqueadero.model.datos.database.ParqueaderoDatabase;
import com.example.adnparqueadero.model.datos.tables.DiaSemana;
import com.example.adnparqueadero.model.datos.tables.LetraCondicion;
import com.example.adnparqueadero.model.datos.tables.LimiteVehiculos;
import com.example.adnparqueadero.model.datos.tables.Precios;
import com.example.adnparqueadero.model.datos.tables.PreciosCcMayor;
import com.example.adnparqueadero.model.datos.tables.TipoCondicion;
import com.example.adnparqueadero.model.datos.tables.TipoPrecios;
import com.example.adnparqueadero.model.datos.tables.TipoVehiculo;
import com.example.adnparqueadero.model.domain.model.InterfaceDomainGet;
import com.example.adnparqueadero.model.domain.model.InterfaceRespuestas;

import java.util.List;

public class ControlerDomainDatosGet implements InterfaceDomainGet {
    private static ControlerDomainDatosGet instance;
    private ParqueaderoDatabase parqueadero;
    private List<DiaSemana> dias;
    private List<TipoVehiculo> tipoVehiculos;
    private List<LimiteVehiculos> limiteVehiculos;
    private List<TipoCondicion> tipoCondicion;
    private List<LetraCondicion> letraCondicion;
    private List<TipoPrecios> tipoPrecios;
    private List<Precios> precios;
    private List<PreciosCcMayor> preciosCcMayor;

    public static ControlerDomainDatosGet getInstance(ParqueaderoDatabase parqueadero){
       if(instance==null)
        {
            instance= new ControlerDomainDatosGet();
        }
        instance.parqueadero =parqueadero;
        return  instance;
    }

    @Override
    public void getSelectAllDiaSemana(final InterfaceRespuestas.CallbackHandlerRspArray callback) {
        dias=null;
        try {
            new Thread(new Runnable() {
                public void run() {
                    String [] diasSemana;
                    dias = parqueadero.diaSemanaDao().getSelectAll();
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
    }

    @Override
    public void getSelectAllTipoVehiculo(final InterfaceRespuestas.CallbackHandlerRspArray callback) {
        tipoVehiculos =null;
        try {
            new Thread(new Runnable() {
                public void run() {
                    String [] tipoVehiculoArray;
                    tipoVehiculos = parqueadero.tipoVehiculoDao().getSelectAll();
                    tipoVehiculoArray = new String[tipoVehiculos.size()];
                    for (int i = 0; i < tipoVehiculos.size(); i++) {
                        tipoVehiculoArray[i] = tipoVehiculos.get(i).getVehiculo();
                    }
                    callback.respuestaArray(tipoVehiculoArray);
                }
            }).start();
        }catch(Exception e){
            Log.e("Error AllTipoVehiculo",e.toString());
            callback.respuestaArray(new String[]{""});
        }
    }

    @Override
    public void getSelectAllTipoCondicion(final InterfaceRespuestas.CallbackHandlerRspArray callback) {
        tipoCondicion=null;
        try {
            new Thread(new Runnable() {
                public void run() {
                    String [] tipoCondicionArray;
                    tipoCondicion = parqueadero.tipoCondicionDao().getSelectAll();
                    tipoCondicionArray = new String[tipoCondicion.size()];
                    for (int i = 0; i < tipoCondicion.size(); i++) {
                        tipoCondicionArray[i] = tipoCondicion.get(i).getTipCondicion();
                    }
                    callback.respuestaArray(tipoCondicionArray);
                }
            }).start();
        }catch(Exception e){
            Log.e("Error AllTipoCondicion",e.toString());
            callback.respuestaArray(new String[]{""});
        }
    }

    @Override
    public void getSelectAllTipoPrecios(final InterfaceRespuestas.CallbackHandlerRspArray callback) {
        tipoPrecios=null;
        try {
            new Thread(new Runnable() {
                public void run() {
                    String [] tipoPreciosArray;
                    tipoPrecios = parqueadero.tipoPreciosDao().getSelectAll();
                    tipoPreciosArray = new String[tipoPrecios.size()];
                    for (int i = 0; i < tipoPrecios.size(); i++) {
                        tipoPreciosArray[i] = tipoPrecios.get(i).getTipoPrecio();
                    }
                    callback.respuestaArray(tipoPreciosArray);
                }
            }).start();
        }catch(Exception e){
            Log.e("Error AllTipoPrecios",e.toString());
            callback.respuestaArray(new String[]{""});
        }
    }

    @Override
    public void getSelectAllLimiteVehiculos(final InterfaceRespuestas.CallbackHandlerRspMatriz callback) {
        limiteVehiculos=null;
        try {
            getSelectAllTipoVehiculo(new InterfaceRespuestas.CallbackHandlerRspArray() {
                @Override
                public void respuestaArray(final String[] respuesta) {
                    new Thread(new Runnable() {
                        public void run() {
                            String[][] limitVehiculos=new String[][]{{""},{""}};
                            if (respuesta==null) {
                                callback.respuestaMatriz(limitVehiculos);
                                return;
                            }
                            limiteVehiculos = parqueadero.limiteVehiculosDao().getSelectAll();
                            if (limiteVehiculos.isEmpty()) {
                                LimiteVehiculos[] limitVehiculosInsertar = new LimiteVehiculos[respuesta.length];
                                for (int i = 0; i < respuesta.length; i++) {
                                    if("Carro".equals(respuesta[i]))
                                        limitVehiculosInsertar[i] = new LimiteVehiculos(20, respuesta[i]);
                                    else if("Moto".equals(respuesta[i]))
                                        limitVehiculosInsertar[i] = new LimiteVehiculos(10, respuesta[i]);
                                }
                                parqueadero.limiteVehiculosDao().insertAll(limitVehiculosInsertar);
                                limiteVehiculos = parqueadero.limiteVehiculosDao().getSelectAll();
                            }
                            limitVehiculos = new String[limiteVehiculos.size()][2];
                            for (int i = 0; i < limiteVehiculos.size(); i++) {
                                limitVehiculos[i][0]=limiteVehiculos.get(i).getTipoVehiculo();
                                limitVehiculos[i][1]= String.valueOf(limiteVehiculos.get(i).getCantidad());
                            }
                            callback.respuestaMatriz(limitVehiculos);
                        }
                    }).start();
                }
            });
        }catch(Exception e){
            Log.e("Error AllLimiteVehiculo",e.toString());
            callback.respuestaMatriz(new String[][]{{""},{""}});
        }
    }

    @Override
    public void getSelectAllLetraCondicion(final InterfaceRespuestas.CallbackHandlerRspMatriz callback) {
        letraCondicion=null;
        try {
            getSelectAllTipoCondicion(new InterfaceRespuestas.CallbackHandlerRspArray() {
                @Override
                public void respuestaArray(final String[] respuesta) {
                    getSelectAllDiaSemana(new InterfaceRespuestas.CallbackHandlerRspArray() {
                        @Override
                        public void respuestaArray(final String[] respuesta2) {
                            new Thread(new Runnable() {
                                public void run() {
                                    String[][] letraCondicionRspta=new String[][]{{""},{""}};
                                    if (respuesta==null||respuesta2==null) {
                                        callback.respuestaMatriz(letraCondicionRspta);
                                        return;
                                    }
                                    letraCondicion = parqueadero.letraCondicionDao().getSelectAll();
                                    if (letraCondicion.isEmpty()) {
                                        LetraCondicion[] letraCondicionInsertar = new LetraCondicion[1];
                                        String diasBloquear="";
                                        String condicion="";
                                        for (int i = 0; i < respuesta2.length; i++) {
                                            diasBloquear+=("Lunes").equals(respuesta2[i])||("Domingo").equals(respuesta2[i])?
                                                    "":(respuesta2[i]+"|");
                                        }
                                        for (int i = 0; i < respuesta.length; i++) {
                                            if (("Inicio").equals(respuesta[i]))
                                              condicion = respuesta[i];
                                        }
                                        letraCondicionInsertar[0] = new LetraCondicion(0, "A",condicion,diasBloquear);
                                        parqueadero.letraCondicionDao().insertAll(letraCondicionInsertar);
                                        letraCondicion = parqueadero.letraCondicionDao().getSelectAll();
                                    }
                                    letraCondicionRspta = new String[letraCondicion.size()][4];
                                    for (int i = 0; i < letraCondicion.size(); i++) {
                                        letraCondicionRspta[i][0]= String.valueOf(letraCondicion.get(i).getIdLetra());
                                        letraCondicionRspta[i][1]=letraCondicion.get(i).getLetra();
                                        letraCondicionRspta[i][2]=letraCondicion.get(i).getCondicion();
                                        letraCondicionRspta[i][3]=letraCondicion.get(i).getDiasBloqueados();
                                    }
                                    callback.respuestaMatriz(letraCondicionRspta);
                                }
                            }).start();
                        }
                    });
                }
            });
        }catch(Exception e){
            Log.e("Error AllLetraCondicion",e.toString());
            callback.respuestaMatriz(new String[][]{{""},{""}});
        }
    }

    @Override
    public void getSelectAllPrecios(final InterfaceRespuestas.CallbackHandlerRspMatriz callback) {
        precios=null;
        try {
            getSelectAllTipoPrecios(new InterfaceRespuestas.CallbackHandlerRspArray() {
                @Override
                public void respuestaArray(final String[] respuestaTipoPrecios) {
                    getSelectAllTipoVehiculo(new InterfaceRespuestas.CallbackHandlerRspArray() {
                        @Override
                        public void respuestaArray(final String[] respuestaTipoVehiculo) {
                            new Thread(new Runnable() {
                                public void run() {
                                    String[][] preciosRspta=new String[][]{{""},{""}};
                                    if (respuestaTipoPrecios==null||respuestaTipoVehiculo==null) {
                                        callback.respuestaMatriz(preciosRspta);
                                        return;
                                    }
                                    precios = parqueadero.preciosDao().getSelectAll();
                                    if (precios.isEmpty()) {
                                        Precios preciosInsertar;
                                        boolean carro=false;
                                        boolean moto=false;
                                        boolean tipoPrecioHora=false;
                                        boolean tipoPrecioDia=false;
                                        for (int i = 0; i < respuestaTipoVehiculo.length; i++) {
                                            if("Carro".equals(respuestaTipoVehiculo[i]))
                                                carro=true;
                                            if("Moto".equals(respuestaTipoVehiculo[i]))
                                                moto=true;
                                        }
                                        for (int i = 0; i < respuestaTipoPrecios.length; i++) {
                                            if (("Hora").equals(respuestaTipoPrecios[i]))
                                                tipoPrecioHora=true;
                                            if (("Dia").equals(respuestaTipoPrecios[i]))
                                                tipoPrecioDia=true;
                                        }
                                        if(carro && tipoPrecioHora) {
                                            preciosInsertar = new Precios(0, 1000, "Carro"
                                                    , "Hora");
                                            parqueadero.preciosDao().insert(preciosInsertar);
                                        }
                                        if(carro && tipoPrecioDia) {
                                            preciosInsertar = new Precios(0, 8000, "Carro"
                                                    ,"Dia");
                                            parqueadero.preciosDao().insert(preciosInsertar);
                                        }
                                        if(moto && tipoPrecioHora) {
                                            preciosInsertar = new Precios(0, 500, "Moto"
                                                    , "Hora");
                                            parqueadero.preciosDao().insert(preciosInsertar);
                                        }
                                        if(moto && tipoPrecioDia) {
                                            preciosInsertar = new Precios(0, 4000, "Moto"
                                                    ,"Dia");
                                            parqueadero.preciosDao().insert(preciosInsertar);
                                        }
                                        precios = parqueadero.preciosDao().getSelectAll();
                                    }
                                    preciosRspta = new String[precios.size()][4];
                                    for (int i = 0; i < precios.size(); i++) {
                                        preciosRspta[i][0]= String.valueOf(precios.get(i).getIdPrecios());
                                        preciosRspta[i][1]= String.valueOf(precios.get(i).getPrecio());
                                        preciosRspta[i][2]=precios.get(i).getTipoVehiculo();
                                        preciosRspta[i][3]=precios.get(i).getTipoPrecio();
                                    }
                                    callback.respuestaMatriz(preciosRspta);
                                }
                            }).start();
                        }
                    });
                }
            });
        }catch(Exception e){
            Log.e("Error AllLetraCondicion",e.toString());
            callback.respuestaMatriz(new String[][]{{""},{""}});
        }

    }

    @Override
    public void getSelectAllPreciosCcMayor(final InterfaceRespuestas.CallbackHandlerRspMatriz callback) {
        preciosCcMayor=null;
        getSelectAllTipoVehiculo(new InterfaceRespuestas.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(final String[] respuesta) {
                new Thread(new Runnable() {
                    public void run() {
                        String[][] preciosRspta=new String[][]{{""},{""}};
                        if (respuesta==null) {
                            callback.respuestaMatriz(preciosRspta);
                            return;
                        }
                        preciosCcMayor = parqueadero.preciosCcMayorDao().getSelectAll();
                        if (preciosCcMayor.isEmpty()) {
                            PreciosCcMayor preciosInsertar;
                            boolean moto=false;
                            for (int i = 0; i < respuesta.length; i++) {
                                if("Moto".equals(respuesta[i]))
                                    moto=true;
                            }
                            if(moto) {
                                preciosInsertar = new PreciosCcMayor(500, 2000, "Moto");
                                parqueadero.preciosCcMayorDao().insert(preciosInsertar);
                            }
                            preciosCcMayor = parqueadero.preciosCcMayorDao().getSelectAll();
                        }
                        preciosRspta = new String[preciosCcMayor.size()][3];
                        for (int i = 0; i < preciosCcMayor.size(); i++) {
                            preciosRspta[i][0]= String.valueOf(preciosCcMayor.get(i).getCilindraje());
                            preciosRspta[i][1]= String.valueOf(preciosCcMayor.get(i).getPrecio());
                            preciosRspta[i][2]=preciosCcMayor.get(i).getTipoVehiculo();
                        }
                        callback.respuestaMatriz(preciosRspta);
                    }
                }).start();
            }
        });
    }

}
