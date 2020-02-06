package com.example.adnparqueadero;

import com.example.adnparqueadero.model.datos.tables.VehiculoHistorial;
import com.example.adnparqueadero.model.domain.controler_domain.VigilanteParqueaderoIngreso;
import com.example.adnparqueadero.model.domain.controler_domain.VigilanteParqueaderoSalida;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class VigilanteParqueaderoSalidaUniTest {
    @Test
    public void validacionIngresoMoto()
    {
        VehiculoHistorial vehiculoHistorial=new VehiculoHistorial(0,"HG323","2020/02/06",
                "06:43","","",0,0);
        VigilanteParqueaderoSalida vigilanteParqueaderoSalida=new VigilanteParqueaderoSalida(vehiculoHistorial,2000,
                500,4000 );
        vigilanteParqueaderoSalida.setFechaActual("2020/02/06");
        vigilanteParqueaderoSalida.setHoraActual("17:15");
        assertTrue(vigilanteParqueaderoSalida.validarSalida());
        vehiculoHistorial=vigilanteParqueaderoSalida.getVehiculoIngresado();

        assertEquals(10,vehiculoHistorial.getHorasEstacionado());
        assertEquals(6000,vehiculoHistorial.getValorCobrado());
    }
    @Test
    public void validacionIngresoCarro()
    {
        VehiculoHistorial vehiculoHistorial=new VehiculoHistorial(0,"HG323","2020/02/06",
                "06:43","","",0,0);
        VigilanteParqueaderoSalida vigilanteParqueaderoSalida=new VigilanteParqueaderoSalida(vehiculoHistorial,0,
                1000,8000 );
        vigilanteParqueaderoSalida.setFechaActual("2020/02/07");
        vigilanteParqueaderoSalida.setHoraActual("09:50");
        assertTrue(vigilanteParqueaderoSalida.validarSalida());
        vehiculoHistorial=vigilanteParqueaderoSalida.getVehiculoIngresado();

        assertEquals(27,vehiculoHistorial.getHorasEstacionado());
        assertEquals(11000,vehiculoHistorial.getValorCobrado());
    }


}