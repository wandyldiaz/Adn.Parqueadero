package com.example.adnparqueadero;

import com.example.adnparqueadero.model.datos.tables.VehicleHistory;
import com.example.adnparqueadero.model.domain.controler_domain.DateTimeParking;
import com.example.adnparqueadero.model.domain.controler_domain.ParkingExit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ParkingExitUniTest {
    @Test
    public void validacionIngresoMoto()
    {
        DateTimeParking dateTimeParking=new DateTimeParking();
        VehicleHistory vehicleHistory =new VehicleHistory();
        vehicleHistory.setLicencePlate("HG323");
        vehicleHistory.setDateEntry("2020/02/06");
        vehicleHistory.setTimeExit("06:43");
        ParkingExit vigilanteParqueaderoSalida=new ParkingExit(vehicleHistory,2000,
                500,4000,dateTimeParking, "2020/02/06","17:15");
        assertTrue(vigilanteParqueaderoSalida.validarSalida());
        vehicleHistory =vigilanteParqueaderoSalida.getVehiculoIngresado();

        assertEquals(10, vehicleHistory.getHorasEstacionado());
        assertEquals(6000, vehicleHistory.getValorCobrado());
    }
    @Test
    public void validacionIngresoCarro()
    {
        DateTimeParking dateTimeParking=new DateTimeParking();
        VehicleHistory vehicleHistory =new VehicleHistory();
        vehicleHistory.setLicencePlate("HG323");
        vehicleHistory.setDateEntry("2020/02/06");
        vehicleHistory.setTimeExit("06:43");
        ParkingExit vigilanteParqueaderoSalida=new ParkingExit(vehicleHistory,0,
                1000,8000,dateTimeParking,"2020/02/07","09:50" );
        assertTrue(vigilanteParqueaderoSalida.validarSalida());
        vehicleHistory =vigilanteParqueaderoSalida.getVehiculoIngresado();

        assertEquals(27, vehicleHistory.getHorasEstacionado());
        assertEquals(11000, vehicleHistory.getValorCobrado());
    }


}