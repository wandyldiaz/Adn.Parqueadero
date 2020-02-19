package com.example.adnparqueadero;

import com.example.adnparqueadero.model.domain.DateTimeInterface;
import com.example.adnparqueadero.model.domain.models.VehicleHistoryData;
import com.example.adnparqueadero.model.domain.models.VehicleRegisteredData;
import com.example.adnparqueadero.model.domain.repository.ParkingRepository;
import com.example.adnparqueadero.model.domain.service.ParkingEntry;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;


import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ParkingEntryUniTest {
    private static final String ERROR_VEHICLE_ENTERED = "Error el vehiculo ya se encuentra en el parqueadero";
    private static final String ERROR_VEHICLE_LIMIT = "Error no hay cupo en el parqueadero";
    private static final String ERROR_VEHICLE_DAY = "Error el vehiculo no puede ingresar el dia de hoy";
    private static final String ERROR_VEHICLE_ENTRY = "Error no se pudo ingresar el vehiculo";
    private static final String ERROR_REGISTERED_VEHICLE = "Error no se pudo registrar el vehiculo";
    private static final String ERROR_LICENCE_PLATE = "Error placa incorrecta";
    private static final String SUCCESS_VEHICLE_ENTRY = "Vehiculo ingresado exitosamente";

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    ParkingRepository parkingRepositoryMockOk;
    @Mock
    ParkingRepository parkingRepositoryMockFailed;
    @Mock
    DateTimeInterface dateTimeParkingMock;

    @Before
    public void declaracionVariables() {
        when(dateTimeParkingMock.getCurrentDate()).thenReturn("2020/02/01");
        when(dateTimeParkingMock.getCurrentTime()).thenReturn("13:00");
        when(parkingRepositoryMockOk.insert(ArgumentMatchers.<VehicleRegisteredData>any())).thenReturn((long) 1);
        when(parkingRepositoryMockOk.insert(ArgumentMatchers.<VehicleHistoryData>any())).thenReturn((long) 1);
        when(parkingRepositoryMockFailed.insert(ArgumentMatchers.<VehicleRegisteredData>any())).thenReturn((long) 0);
        when(parkingRepositoryMockFailed.insert(ArgumentMatchers.<VehicleHistoryData>any())).thenReturn((long) 0);
        when(parkingRepositoryMockOk.getCountVehicleEnteredType("Carro")).thenReturn((long) 11);
        when(parkingRepositoryMockOk.getCountVehicleEnteredType("Moto")).thenReturn((long) 9);

    }

    @Test
    public void validacionDiaLunes() {
        //Arrangue
        VehicleRegisteredData vehicleRegisteredData = new VehicleRegisteredData();
        vehicleRegisteredData.setCylinder(500);
        vehicleRegisteredData.setLicencePlate("AHG333");
        vehicleRegisteredData.setTypeVehicle("Carro");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Lunes");
        when(parkingRepositoryMockOk.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData, parkingRepositoryMockOk,
                dateTimeParkingMock);
        //ACK
        String result = parkingEntry.startVehicleEntry();
        //assert
        assertTrue(result.equals(SUCCESS_VEHICLE_ENTRY));

    }

    @Test
    public void validacionDiaMartes() {
        //Arrangue
        VehicleRegisteredData vehicleRegisteredData = new VehicleRegisteredData();
        vehicleRegisteredData.setCylinder(500);
        vehicleRegisteredData.setLicencePlate("AHG333");
        vehicleRegisteredData.setTypeVehicle("Carro");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Martes");
        when(parkingRepositoryMockOk.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData, parkingRepositoryMockOk,
                dateTimeParkingMock);
        //ACK
        String result = parkingEntry.startVehicleEntry();
        //assert
        assertTrue(result.equals(ERROR_VEHICLE_DAY));

    }

    @Test
    public void validacionDiaMiercoles() {
        //Arrangue
        VehicleRegisteredData vehicleRegisteredData = new VehicleRegisteredData();
        vehicleRegisteredData.setCylinder(500);
        vehicleRegisteredData.setLicencePlate("EHG333");
        vehicleRegisteredData.setTypeVehicle("Carro");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Miercoles");
        when(parkingRepositoryMockOk.getSelectVehicleEntered("EHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData, parkingRepositoryMockOk,
                dateTimeParkingMock);
        //ACK
        String result = parkingEntry.startVehicleEntry();
        //assert
        assertTrue(result.equals(SUCCESS_VEHICLE_ENTRY));

    }

    @Test
    public void validacionDiaJueves() {
        //Arrangue
        VehicleRegisteredData vehicleRegisteredData = new VehicleRegisteredData();
        vehicleRegisteredData.setCylinder(500);
        vehicleRegisteredData.setLicencePlate("AHG333");
        vehicleRegisteredData.setTypeVehicle("Carro");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Jueves");
        when(parkingRepositoryMockOk.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData, parkingRepositoryMockOk,
                dateTimeParkingMock);
        //ACK
        String result = parkingEntry.startVehicleEntry();
        //assert
        assertTrue(result.equals(ERROR_VEHICLE_DAY));

    }

    @Test
    public void validacionDiaViernes() {
        //Arrangue
        VehicleRegisteredData vehicleRegisteredData = new VehicleRegisteredData();
        vehicleRegisteredData.setCylinder(500);
        vehicleRegisteredData.setLicencePlate("EHG333");
        vehicleRegisteredData.setTypeVehicle("Carro");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Viernes");
        when(parkingRepositoryMockOk.getSelectVehicleEntered("EHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData, parkingRepositoryMockOk,
                dateTimeParkingMock);
        //ACK
        String result = parkingEntry.startVehicleEntry();
        //assert
        assertTrue(result.equals(SUCCESS_VEHICLE_ENTRY));

    }

    @Test
    public void validacionDiaSabado() {
        //Arrangue
        VehicleRegisteredData vehicleRegisteredData = new VehicleRegisteredData();
        vehicleRegisteredData.setCylinder(500);
        vehicleRegisteredData.setLicencePlate("AHG333");
        vehicleRegisteredData.setTypeVehicle("Carro");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Sabado");
        when(parkingRepositoryMockOk.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData, parkingRepositoryMockOk,
                dateTimeParkingMock);
        //ACK
        String result = parkingEntry.startVehicleEntry();
        //assert
        assertTrue(result.equals(ERROR_VEHICLE_DAY));

    }

    @Test
    public void validacionDiaDomingo() {
        //Arrangue
        VehicleRegisteredData vehicleRegisteredData = new VehicleRegisteredData();
        vehicleRegisteredData.setCylinder(500);
        vehicleRegisteredData.setLicencePlate("AHG333");
        vehicleRegisteredData.setTypeVehicle("Carro");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Domingo");
        when(parkingRepositoryMockOk.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData, parkingRepositoryMockOk,
                dateTimeParkingMock);
        //ACK
        String result = parkingEntry.startVehicleEntry();
        //assert
        assertTrue(result.equals(SUCCESS_VEHICLE_ENTRY));

    }

}