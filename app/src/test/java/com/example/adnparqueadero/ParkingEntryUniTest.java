package com.example.adnparqueadero;

import com.example.adnparqueadero.model.domain.DateTimeInterface;
import com.example.adnparqueadero.model.domain.models.VehicleHistoryData;
import com.example.adnparqueadero.model.domain.models.VehicleRegisteredData;
import com.example.adnparqueadero.model.domain.repository.ParkingRepository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;


import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ParkingEntryUniTest {

    private ParkingRepository parkingRepositoryMockOk;
    private ParkingRepository parkingRepositoryMockFailed;
    private DateTimeInterface dateTimeParkingMock;

    @Before
    public void declaracionVariables(){
        parkingRepositoryMockOk = mock(ParkingRepository.class);
        parkingRepositoryMockFailed = mock(ParkingRepository.class);
        when(parkingRepositoryMockOk.insert(ArgumentMatchers.<VehicleRegisteredData>any())).thenReturn((long) 1);
        when(parkingRepositoryMockOk.insert(ArgumentMatchers.<VehicleHistoryData>any())).thenReturn((long) 1);
        when(parkingRepositoryMockOk.insert(ArgumentMatchers.<VehicleRegisteredData>any())).thenReturn((long) 0);
        when(parkingRepositoryMockOk.insert(ArgumentMatchers.<VehicleHistoryData>any())).thenReturn((long) 0);

    }
    @Test
    public void test() {
        assertEquals(3, 2 + 1);
    }
    /*
    @Test
    public void validacionDias()
    {
        //Arrangue
        DateTimeParking dateTimeParking=new DateTimeParking();

        ParkingEntry vigilanteIngreso= new ParkingEntry(parkingRepositoryMockOk, dateTimeParkingMock);
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
        ParkingEntryAdapterInterface vigilanteIngreso= new ParkingEntryAdapterInterface(daysAllowed,"HGH333",dateTimeParking);
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
        ParkingEntryAdapterInterface vigilanteIngreso= new ParkingEntryAdapterInterface(daysAllowed,"HGH333",dateTimeParking);
        //Ack
        boolean validacion=vigilanteIngreso.validarIngreso(6,
                6);
        // assert
        assertFalse(validacion);

        //Ack
        validacion=vigilanteIngreso.validarIngreso(7,6);
        // assert
        assertFalse(validacion);

    }

    @Test
    public void validacionIngresoTrue()
    {
        //Arrangue
        String [] daysAllowed=new String[]{"Domingo"};
        DateTimeParking dateTimeParking=new DateTimeParking();
        ParkingEntryAdapterInterface vigilanteIngreso= new ParkingEntryAdapterInterface(daysAllowed,"HGH333",dateTimeParking);
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