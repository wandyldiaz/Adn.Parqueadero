package com.example.adnparqueadero.model.domain.controler_domain;

import android.util.Log;

import com.example.adnparqueadero.model.datos.tables.VehiculoHistorial;

import java.text.ParseException;
import java.util.Date;

public class VigilanteParqueaderoSalida extends VigilanteParqueadero {

    private VehiculoHistorial vehiculoIngresado;
    private int valorAdicionalTotal;
    private int valorHora;
    private int valorDia;

    public VehiculoHistorial getVehiculoIngresado() {
        return vehiculoIngresado;
    }

    public VigilanteParqueaderoSalida(VehiculoHistorial vehiculoIngresado, int valorAdicionalTotal,
                                      int valorHora, int valorDia) {
        this.vehiculoIngresado = vehiculoIngresado;
        this.valorAdicionalTotal = valorAdicionalTotal;
        this.valorHora = valorHora;
        this.valorDia = valorDia;
        fechaActual= getDate();
        horaActual=getTime();
    }

    public boolean validarSalida(){
        int horasEstacionado=0;
        int diasEstacionado=0;
        int valorCobrado;
        String fechaIngreso=vehiculoIngresado.getFechaEntrada();
        String horaIngreso=vehiculoIngresado.getHoraEntrada();
        if(horaIngreso.length()!=5 && fechaIngreso.length()!=10)
            return false;

        try {
            horasEstacionado=getDifferenceBetwenDatesMinutes(fechaIngreso+" "+horaIngreso,
                    fechaActual+" "+ horaActual);
        } catch (ParseException e) {
            Log.e("ErrorValidarSalida",e.toString());
            return false;
        }
        if(horasEstacionado>=9 && horasEstacionado<=24){
            valorCobrado=valorDia+valorAdicionalTotal;
        }
        else if(horasEstacionado<9){
            valorCobrado=(valorHora*horasEstacionado)+valorAdicionalTotal;
        }
        else{
            diasEstacionado=(horasEstacionado/24);
            int horasEstacionadoDespuesDias=horasEstacionado % 24;
            if(horasEstacionadoDespuesDias>9){
                horasEstacionadoDespuesDias=horasEstacionadoDespuesDias-9;
                diasEstacionado++;
            }
            valorCobrado=(horasEstacionadoDespuesDias*valorHora)+(diasEstacionado*valorDia)+valorAdicionalTotal;
        }

        vehiculoIngresado.salida(fechaActual,horaActual,horasEstacionado,valorCobrado);

        return true;
    }


    public int getDifferenceBetwenDatesMinutes(String FechaInicio, String FechaFinal) throws ParseException {
        Date dateInicio= dtFormat.parse(FechaInicio);
        Date dateFinal= dtFormat.parse(FechaFinal);
        long milliseconds = dateFinal.getTime() - dateInicio.getTime();
        //long seconds =  (milliseconds / 1000) % 60;
        //long minutes =  ((milliseconds / (1000 * 60)) % 60);
        //int hours = (int) (milliseconds / (1000 * 60 * 60));
        //return (minutes+(hours*60));
        return ((int) (milliseconds / (1000 * 60 * 60)));
    }
}
