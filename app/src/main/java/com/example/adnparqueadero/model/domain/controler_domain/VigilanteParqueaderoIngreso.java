package com.example.adnparqueadero.model.domain.controler_domain;

import com.example.adnparqueadero.model.datos.tables.VehiculoHistorial;

public class VigilanteParqueaderoIngreso  {
    private String[] diasBloqueados;
    private DateTimeParking dateTimeParking;
    private String placa;
    private String fechaActual;
    private String horaActual;

    public VigilanteParqueaderoIngreso(String[] diasBloqueados, String placa, DateTimeParking dateTimeParking) {
        this.diasBloqueados = diasBloqueados;
        this.placa = placa;
        this.dateTimeParking = dateTimeParking;
    }


    public boolean validarDiaIngreso(String fechaActual){
        String diaActual = dateTimeParking.getDiaSemana(fechaActual);
        for (String diasBloqueado : diasBloqueados) {
            if (diasBloqueado.equals(diaActual)) {
                return false;
            }
        }
        return true;
    }

    public boolean validarIngreso(int vehiculosIngresadosXTipo,
                                  int limiteVehiculosXTipo){
        fechaActual= dateTimeParking.getDate();
        horaActual= dateTimeParking.getTime();
        if(!validarDiaIngreso(fechaActual) && limiteVehiculosXTipo>0){
            return false;
        }
            return vehiculosIngresadosXTipo < limiteVehiculosXTipo;
    }


    public VehiculoHistorial getDatosIngreso(){
        return new VehiculoHistorial(0,
                placa,fechaActual,horaActual,"","",0,0);
    }





}
