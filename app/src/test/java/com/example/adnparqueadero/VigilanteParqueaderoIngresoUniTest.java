package com.example.adnparqueadero;

import com.example.adnparqueadero.model.domain.controler_domain.VigilanteParqueaderoIngreso;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class VigilanteParqueaderoIngresoUniTest {
    @Test
    public void validacionDias()
    {
        //Arrangue
        String [] diasBloqueados=new String[]{"Martes","Domingo","Jueves","Viernes"};
        VigilanteParqueaderoIngreso vigilanteIngreso= new VigilanteParqueaderoIngreso(diasBloqueados,"HGH333");

        assertTrue(vigilanteIngreso.validarDiaIngreso("2020/02/01"));
        assertFalse(vigilanteIngreso.validarDiaIngreso("2020/03/01"));
        assertTrue(vigilanteIngreso.validarDiaIngreso("2020/02/17"));
        assertFalse(vigilanteIngreso.validarDiaIngreso("2020/03/03"));
        assertTrue(vigilanteIngreso.validarDiaIngreso("2020/04/22"));
        assertFalse(vigilanteIngreso.validarDiaIngreso("2020/04/30"));
        assertFalse(vigilanteIngreso.validarDiaIngreso("2020/05/01"));

    }
}