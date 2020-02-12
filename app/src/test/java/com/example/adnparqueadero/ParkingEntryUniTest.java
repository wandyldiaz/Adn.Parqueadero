package com.example.adnparqueadero;

import org.junit.Test;


import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ParkingEntryUniTest {
    @Test
    public void test()
    {
        assertEquals(3,2+1);
    }
    /*
    @Test
    public void validacionDias()
    {
        //Arrangue
        DateTimeParking dateTimeParking=new DateTimeParking();
        String [] daysAllowed=new String[]{"Martes","Domingo","Jueves","Viernes"};
        ParkingEntry vigilanteIngreso= new ParkingEntry(daysAllowed,"HGH333",dateTimeParking);
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
        String [] daysAllowed=new String[]{""};
        DateTimeParking dateTimeParking=new DateTimeParking();
        ParkingEntry vigilanteIngreso= new ParkingEntry(daysAllowed,"HGH333",dateTimeParking);
        ///Ack
        boolean validacion=vigilanteIngreso.validarIngreso(0,0);
        // assert
        assertFalse(validacion);

    }

    @Test
    public void validacionIngresoFalse()
    {
        //Arrangue
        String [] daysAllowed=new String[]{"Domingo"};
        DateTimeParking dateTimeParking=new DateTimeParking();
        ParkingEntry vigilanteIngreso= new ParkingEntry(daysAllowed,"HGH333",dateTimeParking);
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
        String [] daysAllowed=new String[]{"Domingo"};
        DateTimeParking dateTimeParking=new DateTimeParking();
        ParkingEntry vigilanteIngreso= new ParkingEntry(daysAllowed,"HGH333",dateTimeParking);
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

    */

}