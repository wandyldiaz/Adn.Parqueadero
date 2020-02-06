package com.example.adnparqueadero;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.adnparqueadero.model.datos.tables.LimiteVehiculos;
import com.example.adnparqueadero.model.datos.tables.VehiculoHistorial;
import com.example.adnparqueadero.model.domain.controler_domain.VigilanteParqueaderoIngreso;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
        //Ack y assert
        assertTrue(vigilanteIngreso.validarDiaIngreso("2020/02/01"));
        assertFalse(vigilanteIngreso.validarDiaIngreso("2020/03/01"));
        assertTrue(vigilanteIngreso.validarDiaIngreso("2020/02/17"));
        assertFalse(vigilanteIngreso.validarDiaIngreso("2020/03/03"));
        assertTrue(vigilanteIngreso.validarDiaIngreso("2020/04/22"));
        assertFalse(vigilanteIngreso.validarDiaIngreso("2020/04/30"));
        assertFalse(vigilanteIngreso.validarDiaIngreso("2020/05/01"));


    }
    @Test
    public void validacionIngresoDatosVacios()
    {
        //Arrangue
        String [] diasBloqueados=new String[]{""};
        VigilanteParqueaderoIngreso vigilanteIngreso= new VigilanteParqueaderoIngreso(diasBloqueados,"HGH333");
        ///Ack
        boolean validacion=vigilanteIngreso.validarIngreso(0,0);
        // assert
        assertFalse(validacion);

    }

    @Test
    public void validacionIngresoFalse()
    {
        //Arrangue
        String [] diasBloqueados=new String[]{"Domingo"};
        VigilanteParqueaderoIngreso vigilanteIngreso= new VigilanteParqueaderoIngreso(diasBloqueados,"HGH333");
        //Ack
        boolean validacion=vigilanteIngreso.validarIngreso(6,
                6);
        // assert
        assertFalse(validacion);

        //Ack
        validacion=vigilanteIngreso.validarIngreso(7,
                6);
        // assert
        assertFalse(validacion);

    }

    @Test
    public void validacionIngresoTrue()
    {
        //Arrangue
        String [] diasBloqueados=new String[]{"Domingo"};
        VigilanteParqueaderoIngreso vigilanteIngreso= new VigilanteParqueaderoIngreso(diasBloqueados,"HGH333");
        //Ack
        boolean validacion=vigilanteIngreso.validarIngreso(5,
                6);
        // assert
        assertTrue(validacion);
        //Ack
        validacion=vigilanteIngreso.validarIngreso(4,
                6);
        // assert
        assertTrue(validacion);
        //Ack
        validacion=vigilanteIngreso.validarIngreso(3,
                4);
        // assert
        assertTrue(validacion);
        //Ack
        validacion=vigilanteIngreso.validarIngreso(2,
                4);
        // assert
        assertTrue(validacion);
        //Ack
        validacion=vigilanteIngreso.validarIngreso(1,
                4);
        // assert
        assertTrue(validacion);
    }

}