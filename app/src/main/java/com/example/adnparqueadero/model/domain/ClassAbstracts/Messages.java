package com.example.adnparqueadero.model.domain.ClassAbstracts;

public abstract class Messages {
    //Ingreso parqueadero
    public static final String ErrorVehicleEntered      = "Error el vehiculo ya se encuentra en el parqueadero";
    public static final String ErrorVehicleLimit        = "Error no hay cupo en el parqueadero";
    public static final String ErrorVehicleDay          = "Error el vehiculo no puede ingresar el dia de hoy";
    public static final String ErrorVehicleEntry        = "Error no se pudo ingresar el vehiculo";
    public static final String ErrorRegisteredVehicle   = "Error no se pudo registrar el vehiculo";
    public static final String SuccesVehicleEntry       = "Vehiculo ingresado exitosamente";

    // Salida parqueadero
    public static final String ErrorVehicleNotEntered = "Error el vehiculo no esta en el parqueadero";
    public static final String ErrorVehicleCalculate  = "Error al calcular la salida del vehiculo";
    public static final String ErrorVehicleData       = "Error al obtener los datos del vehiculo registrado";
    public static final String ErrorVehicleExit       = "Error al realizar la salida del vehiculo";
    public static final String SuccesVehicleExit      = "Salida realizada exitosamente";
}
