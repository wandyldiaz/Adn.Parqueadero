package com.example.adnparqueadero;

import com.example.adnparqueadero.DataBuilder.VehicleRegisteredDataBuilder;
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
    private static final String ERROR_DATA = "Error datos nulos o incorrectos";
    private static final String SUCCESS_VEHICLE_ENTRY = "Vehiculo ingresado exitosamente";

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    ParkingRepository parkingRepositoryMockOkInsert;
    @Mock
    ParkingRepository parkingRepositoryMockFailedInsert;
    @Mock
    ParkingRepository parkingRepositoryMockFailedInsertEntry;
    @Mock
    DateTimeInterface dateTimeParkingMock;

    @Before
    public void methodsMock() {
        when(dateTimeParkingMock.getCurrentDate()).thenReturn("2020/02/01");
        when(dateTimeParkingMock.getCurrentTime()).thenReturn("13:00");

        when(parkingRepositoryMockOkInsert.insert(ArgumentMatchers.<VehicleRegisteredData>any())).thenReturn((long) 1);
        when(parkingRepositoryMockOkInsert.insert(ArgumentMatchers.<VehicleHistoryData>any())).thenReturn((long) 1);

        when(parkingRepositoryMockFailedInsertEntry.insert(ArgumentMatchers.<VehicleRegisteredData>any())).thenReturn((long) 1);
        when(parkingRepositoryMockFailedInsertEntry.getCountVehicleEnteredType("Carro")).thenReturn((long) 11);

    }

    @Test
    public void testDayMonday() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("AHG333");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Lunes");
        when(parkingRepositoryMockOkInsert.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockOkInsert,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(SUCCESS_VEHICLE_ENTRY, result);

    }

    @Test
    public void testDayTuesday() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("AHG333");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Martes");
        when(parkingRepositoryMockOkInsert.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockOkInsert,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(ERROR_VEHICLE_DAY, result);

    }

    @Test
    public void testDayWednesday() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("EHG333");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Miercoles");
        when(parkingRepositoryMockOkInsert.getSelectVehicleEntered("EHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockOkInsert,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(SUCCESS_VEHICLE_ENTRY, result);

    }

    @Test
    public void testDayThursday() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("AHG333");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Jueves");
        when(parkingRepositoryMockOkInsert.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockOkInsert,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(ERROR_VEHICLE_DAY, result);

    }

    @Test
    public void testDayFriday() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("EHG333");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Viernes");
        when(parkingRepositoryMockOkInsert.getSelectVehicleEntered("EHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockOkInsert,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(SUCCESS_VEHICLE_ENTRY, result);

    }

    @Test
    public void testDaySaturday() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("AHG333");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Sabado");
        when(parkingRepositoryMockOkInsert.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockOkInsert,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(ERROR_VEHICLE_DAY, result);

    }

    @Test
    public void testDaySunday() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("AHG333");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Domingo");
        when(parkingRepositoryMockOkInsert.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockOkInsert,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(SUCCESS_VEHICLE_ENTRY, result);

    }

    @Test
    public void testVehicleEntered() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("AHG333");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Domingo");
        when(parkingRepositoryMockOkInsert.getSelectVehicleEntered("AHG333")).thenReturn(new VehicleHistoryData());
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockOkInsert,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(ERROR_VEHICLE_ENTERED, result);

    }

    @Test
    public void testVehicleLimitCar() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("AHG333");
        when(parkingRepositoryMockOkInsert.getCountVehicleEnteredType("Carro")).thenReturn((long) 20);
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Domingo");
        when(parkingRepositoryMockOkInsert.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockOkInsert,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(ERROR_VEHICLE_LIMIT, result);

    }

    @Test
    public void testVehicleLimitMotorcycle() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("AHG333");
        vehicleRegisteredData.withTypeVehicle("Moto");
        when(parkingRepositoryMockOkInsert.getCountVehicleEnteredType("Moto")).thenReturn((long) 10);
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Domingo");
        when(parkingRepositoryMockOkInsert.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockOkInsert,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(ERROR_VEHICLE_LIMIT, result);

    }

    @Test
    public void testVehicleRegister() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("AHG333");
        vehicleRegisteredData.withTypeVehicle("Moto");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Domingo");
        when(parkingRepositoryMockFailedInsert.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockFailedInsert,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(ERROR_REGISTERED_VEHICLE, result);
    }

    @Test
    public void testLicencePlateError() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("AHG33");
        vehicleRegisteredData.withTypeVehicle("Moto");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Martes");
        when(parkingRepositoryMockFailedInsert.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockFailedInsert,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(ERROR_DATA, result);
    }

    @Test
    public void testEmptyData() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("");
        vehicleRegisteredData.withTypeVehicle("");
        vehicleRegisteredData.withCylinder(0);
        when(parkingRepositoryMockFailedInsert.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockFailedInsert,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(ERROR_DATA, result);
    }

    @Test
    public void testVehicleHistory() {
        //Arrange
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("AHG333");
        vehicleRegisteredData.withTypeVehicle("Moto");
        when(dateTimeParkingMock.getDayWeek(anyString())).thenReturn("Domingo");
        when(parkingRepositoryMockFailedInsertEntry.getSelectVehicleEntered("AHG333")).thenReturn(null);
        ParkingEntry parkingEntry = new ParkingEntry(vehicleRegisteredData.build(), parkingRepositoryMockFailedInsertEntry,
                dateTimeParkingMock);
        //Act
        String result = parkingEntry.startVehicleEntry();
        //Assert
        assertEquals(ERROR_VEHICLE_ENTRY, result);
    }

}