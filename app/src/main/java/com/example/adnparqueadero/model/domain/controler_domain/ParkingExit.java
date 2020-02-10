package com.example.adnparqueadero.model.domain.controler_domain;

import android.util.Log;

import com.example.adnparqueadero.model.datos.tables.VehicleHistory;

import java.text.ParseException;

public class ParkingExit {

    private DateTimeParking dateTimeParking;
    private VehicleHistory vehiculoIngresado;
    private int valorAdicionalTotal;
    private int valorHora;
    private int valorDia;
    private String fechaActual;
    private String horaActual;

    public ParkingExit(VehicleHistory vehiculoIngresado, int valorAdicionalTotal,
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
        int horasEstacionado=0;
        int diasEstacionado=0;
        int valorCobrado;
        String fechaIngreso=vehiculoIngresado.getFechaEntrada();
        String horaIngreso=vehiculoIngresado.getHoraEntrada();
        if(horaIngreso.length()!=5 && fechaIngreso.length()!=10)
            return false;
        try {
            horasEstacionado=dateTimeParking.getDifferenceDates(fechaIngreso+" "+horaIngreso,
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
            if(horasEstacionadoDespuesDias>=9){
                horasEstacionadoDespuesDias=horasEstacionadoDespuesDias-9;
                diasEstacionado++;
            }
            valorCobrado=(horasEstacionadoDespuesDias*valorHora)+(diasEstacionado*valorDia)+valorAdicionalTotal;
        }
        vehiculoIngresado.setDateExit(fechaActual);
        vehiculoIngresado.setTimeExit(horaActual);
        vehiculoIngresado.setHoursParked(horasEstacionado);
        vehiculoIngresado.setAmountCharged(valorCobrado);
        return true;
    }

    public VehicleHistory getVehiculoIngresado() {
        return vehiculoIngresado;
    }

}
