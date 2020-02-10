package com.example.adnparqueadero.model.domain.controler_domain;

import android.util.Log;

import com.example.adnparqueadero.model.datos.tables.VehiculoHistorial;

import java.text.ParseException;

public class VigilanteParqueaderoSalida{

    private DateTimeParking dateTimeParking;
    private VehiculoHistorial vehiculoIngresado;
    private int valorAdicionalTotal;
    private int valorHora;
    private int valorDia;
    private String fechaActual;
    private String horaActual;

    public VehiculoHistorial getVehiculoIngresado() {
        return vehiculoIngresado;
    }

    public VigilanteParqueaderoSalida(VehiculoHistorial vehiculoIngresado, int valorAdicionalTotal,
                                      int valorHora, int valorDia, DateTimeParking dateTimeParking, String fechaActual, String horaActual) {
        this.vehiculoIngresado = vehiculoIngresado;
        this.valorAdicionalTotal = valorAdicionalTotal;
        this.valorHora = valorHora;
        this.valorDia = valorDia;
        this.dateTimeParking = dateTimeParking;
        this.fechaActual= fechaActual;
        this.horaActual= horaActual;
    }

    public boolean validarSalida(){
        double horasEstacionado=0;
        int diasEstacionado=0;
        int valorCobrado;
        String fechaIngreso=vehiculoIngresado.getFechaEntrada();
        String horaIngreso=vehiculoIngresado.getHoraEntrada();
        if(horaIngreso.length()!=5 && fechaIngreso.length()!=10)
            return false;

        try {
            horasEstacionado=dateTimeParking.getDifferenceBetwenDatesMinutes(fechaIngreso+" "+horaIngreso,
                    fechaActual+" "+ horaActual);
        } catch (ParseException e) {
            Log.e("ErrorValidarSalida",e.toString());
            return false;
        }
        if(horasEstacionado>=9 && horasEstacionado<=24){
            valorCobrado=valorDia+valorAdicionalTotal;
        }
        else if(horasEstacionado<9){
            valorCobrado=(int)((valorHora*horasEstacionado)+valorAdicionalTotal);
        }
        else{
            diasEstacionado=(int)((horasEstacionado/24));
            double horasEstacionadoDespuesDias=horasEstacionado % 24;
            if(horasEstacionadoDespuesDias>9){
                horasEstacionadoDespuesDias=horasEstacionadoDespuesDias-9;
                diasEstacionado++;
            }
            valorCobrado=(int)(horasEstacionadoDespuesDias*valorHora)+(diasEstacionado*valorDia)+valorAdicionalTotal;
        }

        vehiculoIngresado.salida(fechaActual,horaActual,(int)horasEstacionado,valorCobrado);

        return true;
    }

}
