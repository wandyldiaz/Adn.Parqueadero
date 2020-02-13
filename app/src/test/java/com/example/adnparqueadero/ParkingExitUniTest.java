package com.example.adnparqueadero;

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
    public void test()
    {
        assertEquals(3,2+1);
    }
    /*
    @Test
    public void validacionIngresoMoto()
    {
        DateTimeParking dateTimeParking=new DateTimeParking();
        VehicleHistory vehicleHistory =new VehicleHistory();
        vehicleHistory.setLicencePlate("HG323");
        vehicleHistory.setDateEntry("2020/02/06");
        vehicleHistory.setTimeEntry("06:43");
        ParkingExitAdapterInterface vigilanteParqueaderoSalida=new ParkingExitAdapterInterface(vehicleHistory,2000,
                500,4000,dateTimeParking, "2020/02/06","17:15");
        assertTrue(vigilanteParqueaderoSalida.validarSalida());
        vehicleHistory =vigilanteParqueaderoSalida.getVehicleExit();

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
        vehicleHistory.setTimeEntry("06:43");
        ParkingExitAdapterInterface parkingExit=new ParkingExitAdapterInterface(vehicleHistory,0,
                1000,8000,dateTimeParking,"2020/02/07","09:50" );
        assertTrue(parkingExit.validarSalida());
        vehicleHistory =parkingExit.getVehicleExit();

        assertEquals(27, vehicleHistory.getHorasEstacionado());
        assertEquals(11000, vehicleHistory.getValorCobrado());
    }
*/

}