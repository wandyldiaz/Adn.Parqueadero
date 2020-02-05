package com.example.adnparqueadero.model.domain.controler_domain;

import com.example.adnparqueadero.model.datos.tables.LimiteVehiculos;
import com.example.adnparqueadero.model.datos.tables.VehiculoHistorial;
import com.example.adnparqueadero.model.datos.tables.VehiculosRegistrados;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.TimeZone;

public class VigilanteParqueaderoIngreso extends VigilanteParqueadero {
    private String[] diasBloqueados;
    private String placa;
    private String fechaActual;
    private String horaActual;

    public VigilanteParqueaderoIngreso(String[] diasBloqueados, String placa) {
        this.diasBloqueados = diasBloqueados;
        this.placa = placa;
    }

    private String diaSemana (String fecha)
    {
        int dia= Integer.parseInt(fecha.split("/")[2]);
        int mes= Integer.parseInt(fecha.split("/")[1]);
        int ano= Integer.parseInt(fecha.split("/")[0]);
        TimeZone timeZone = TimeZone.getTimeZone(GMT);
        String letraDia;
        Calendar calendar = new GregorianCalendar(timeZone);
        calendar.set(ano, mes-1, dia);
        int nD=calendar.get(Calendar.DAY_OF_WEEK);
        if (nD == 2) {
            letraDia = "Lunes";
        } else if (nD == 3) {
            letraDia = "Martes";
        } else if (nD == 4) {
            letraDia = "Miercoles";
        } else if (nD == 5) {
            letraDia = "Jueves";
        } else if (nD == 6) {
            letraDia = "Viernes";
        } else if (nD == 7) {
            letraDia = "Sabado";
        } else if (nD == 1) {
            letraDia = "Domingo";
        }
        else{
            letraDia="";
        }
            return letraDia;
    }
    public boolean validarDiaIngreso(String fechaActual){
        String diaActual = diaSemana(fechaActual);
        for (String diasBloqueado : diasBloqueados) {
            if (diasBloqueado.equals(diaActual)) {
                return false;
            }
        }
        return true;
    }

    public boolean validarIngreso(List<VehiculoHistorial> vehiculos_Ingresados,
                                  List<LimiteVehiculos> limiteVehiculos, String tipoVehiculo ){
        fechaActual=getDate();
        horaActual=getTime();
        int limiteVehiculo=0;
        if(!validarDiaIngreso(fechaActual)){
            return false;
        }
        for(int i=0; i<limiteVehiculos.size();i++){
            if(limiteVehiculos.get(i).getTipoVehiculo().equals(tipoVehiculo)){
                limiteVehiculo=limiteVehiculos.get(i).getCantidad();
                break;
            }
        }
        if(vehiculos_Ingresados.size()>limiteVehiculo)
            return  false;
        return true;
    }


    public VehiculoHistorial getDatosIngreso(){
        return new VehiculoHistorial(0,
                placa,fechaActual,horaActual,"","",0,0);
    }





}
