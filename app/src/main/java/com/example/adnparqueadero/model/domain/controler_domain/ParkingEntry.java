package com.example.adnparqueadero.model.domain.controler_domain;

import static com.example.adnparqueadero.model.domain.controler_domain.BusinessModel.daysAllowed;

public class ParkingEntry {
    private DateTimeParking dateTimeParking;
    private String placa;
    private String fechaActual;
    private String horaActual;

    public ParkingEntry(String placa, DateTimeParking dateTimeParking) {
        this.placa = placa;
        this.dateTimeParking = dateTimeParking;
    }

    private boolean validarDiaIngreso(){
        String diaActual = dateTimeParking.getDayWeek(fechaActual);
        String letraPlaca=(""+placa.charAt(0)).toUpperCase();
        for (String diasBloqueado : daysAllowed) {
            if ((!diasBloqueado.equals(diaActual))&&"A".equals(letraPlaca)) {
                return false;
            }
        }
        return true;
    }

    private boolean validarIngreso(int vehiculosIngresadosXTipo,
                                  int limiteVehiculosXTipo){
        fechaActual= dateTimeParking.getDate();
        horaActual= dateTimeParking.getTime();
        if(!validarDiaIngreso() && limiteVehiculosXTipo>0){
            return false;
        }
            return vehiculosIngresadosXTipo < limiteVehiculosXTipo;
    }

    private boolean vehicleEntry(){
        fechaActual=dateTimeParking.getDate();
        horaActual=dateTimeParking.getTime();


        return true;
    }

    public boolean setVehicleEntry(){
        return vehicleEntry();
    }

}
