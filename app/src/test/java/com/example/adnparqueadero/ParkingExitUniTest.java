package com.example.adnparqueadero;

import com.example.adnparqueadero.DataBuilder.VehicleHistoryDataBuilder;
import com.example.adnparqueadero.DataBuilder.VehicleRegisteredDataBuilder;
import com.example.adnparqueadero.model.domain.models.VehicleHistoryData;
import com.example.adnparqueadero.model.domain.models.VehicleRegisteredData;
import com.example.adnparqueadero.model.domain.repository.ParkingRepository;
import com.example.adnparqueadero.model.domain.service.ParkingExit;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ParkingExitUniTest {

    private static final String ERROR_VEHICLE_DATA = "Error al obtener los datos del vehiculo registrado";
    private static final String ERROR_VEHICLE_EXIT = "Error al realizar la salida del vehiculo";
    private static final String SUCCESS_VEHICLE_EXIT = "Salida realizada exitosamente";
    private static final String ERROR_VEHICLE_NOT_ENTERED = "Error el vehiculo no esta en el parqueadero";

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    @Mock
    ParkingRepository parkingRepositoryMockOkUpdate;
    @Mock
    ParkingRepository parkingRepositoryMockFailedUpdate;

    @Before
    public void methodsMock() {
        when(parkingRepositoryMockOkUpdate.update(ArgumentMatchers.<VehicleHistoryData>any())).thenReturn(1);
        when(parkingRepositoryMockFailedUpdate.update(ArgumentMatchers.<VehicleHistoryData>any())).thenReturn(-1);
    }

    @Test
    public void testVehicleExitMotorcycle() {
        //Arrange
        VehicleHistoryDataBuilder vehicleHistory = new VehicleHistoryDataBuilder();
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("HGG323");
        vehicleRegisteredData.withTypeVehicle("Moto");
        ParkingExit parkingExit = new ParkingExit("2020/02/06", "17:15", parkingRepositoryMockOkUpdate,
                "HGG323");
        when(parkingRepositoryMockOkUpdate.getSelectVehicleEntered("HGG323"))
                .thenReturn(vehicleHistory.build());
        when(parkingRepositoryMockOkUpdate.getSelect("HGG323"))
                .thenReturn(vehicleRegisteredData.build());
        //Act
        String[] result = parkingExit.startMakeExit().split("\n");
        //Assert
        assertEquals(SUCCESS_VEHICLE_EXIT,result[0]);
        assertEquals("Horas parqueado: "+10,result[1]);
        assertEquals("Precio: "+6000,result[2]);

    }

    @Test
    public void testVehicleExitCar() {
        //Arrange
        VehicleHistoryDataBuilder vehicleHistory = new VehicleHistoryDataBuilder();
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("HGG323");
        vehicleRegisteredData.withTypeVehicle("Carro");
        ParkingExit parkingExit = new ParkingExit("2020/02/07","09:50", parkingRepositoryMockOkUpdate,
                "HGG323");
        when(parkingRepositoryMockOkUpdate.getSelectVehicleEntered("HGG323"))
                .thenReturn(vehicleHistory.build());
        when(parkingRepositoryMockOkUpdate.getSelect("HGG323"))
                .thenReturn(vehicleRegisteredData.build());
        //Act
        String[] result = parkingExit.startMakeExit().split("\n");
        //Assert
        assertEquals(SUCCESS_VEHICLE_EXIT,result[0]);
        assertEquals("Horas parqueado: "+27,result[1]);
        assertEquals("Precio: "+11000,result[2]);
    }

    @Test
    public void testVehicleExitNotEntered() {
        //Arrange

        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("HGG323");
        vehicleRegisteredData.withTypeVehicle("Carro");
        ParkingExit parkingExit = new ParkingExit("2020/02/07","09:50", parkingRepositoryMockOkUpdate,
                "HGG323");
        when(parkingRepositoryMockOkUpdate.getSelectVehicleEntered("HGG323"))
                .thenReturn(null);
        when(parkingRepositoryMockOkUpdate.getSelect("HGG323"))
                .thenReturn(vehicleRegisteredData.build());
        //Act
        String[] result = parkingExit.startMakeExit().split("\n");
        //Assert
        assertEquals(ERROR_VEHICLE_NOT_ENTERED,result[0]);
    }

    @Test
    public void testVehicleExitErrorDataRegistered() {
        //Arrange
        VehicleHistoryDataBuilder vehicleHistory = new VehicleHistoryDataBuilder();
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("HGG323");
        vehicleRegisteredData.withTypeVehicle("");
        ParkingExit parkingExit = new ParkingExit("2020/02/06", "17:15", parkingRepositoryMockOkUpdate,
                "HGG323");
        when(parkingRepositoryMockOkUpdate.getSelectVehicleEntered("HGG323"))
                .thenReturn(vehicleHistory.build());
        when(parkingRepositoryMockOkUpdate.getSelect("HGG323"))
                .thenReturn(vehicleRegisteredData.build());
        //Act
        String[] result = parkingExit.startMakeExit().split("\n");
        //Assert
        assertEquals(ERROR_VEHICLE_DATA,result[0]);

    }

    @Test
    public void testVehicleExitErrorExit() {
        //Arrange
        VehicleHistoryDataBuilder vehicleHistory = new VehicleHistoryDataBuilder();
        VehicleRegisteredDataBuilder vehicleRegisteredData = new VehicleRegisteredDataBuilder();
        vehicleRegisteredData.withLicencePlate("HGG323");
        vehicleRegisteredData.withTypeVehicle("Carro");
        ParkingExit parkingExit = new ParkingExit("2020/02/06", "17:15", parkingRepositoryMockFailedUpdate,
                "HGG323");
        when(parkingRepositoryMockFailedUpdate.getSelectVehicleEntered("HGG323"))
                .thenReturn(vehicleHistory.build());
        when(parkingRepositoryMockFailedUpdate.getSelect("HGG323"))
                .thenReturn(vehicleRegisteredData.build());
        //Act
        String[] result = parkingExit.startMakeExit().split("\n");
        //Assert
        assertEquals(ERROR_VEHICLE_EXIT,result[0]);
    }
}