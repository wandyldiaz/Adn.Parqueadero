package com.example.adnparqueadero.model.manager;

import android.content.Context;
import android.util.Log;

import com.example.adnparqueadero.model.datos.database.ParkingDatabase;
import com.example.adnparqueadero.model.domain.model.RepositoryVehicleModel;
import com.example.adnparqueadero.model.domain.model.ParkingEntryModel;
import com.example.adnparqueadero.model.domain.model.ParkingExitModel;
import com.example.adnparqueadero.model.service.RepositoryVehicle;
import com.example.adnparqueadero.model.service.ServiceParkingEntry;
import com.example.adnparqueadero.model.service.ServiceParkingExit;

public class ObjectManager {
    private static ObjectManager instance;
    private static Context context;
    private ParkingDatabase parkingDatabase;
    private RepositoryVehicle repositoryVehicle;
    private ServiceParkingEntry serviceParkingEntry;
    private ServiceParkingExit serviceParkingExit;

    private static ObjectManager getInstance(Context context){
        if(context!=null)
            ObjectManager.context=context;
        else
            return null;
        if(instance==null){
            try {
                instance = new ObjectManager();
            }catch(Exception e){
                Log.e("ERROR DATABASE",e.toString());
                return null;
            }

        }
        instance.parkingDatabase = ParkingDatabase.getInstance(context);
        instance.repositoryVehicle = RepositoryVehicleModel.getInstance(context);
        instance.serviceParkingEntry= new ParkingEntryModel();
        instance.serviceParkingExit= new ParkingExitModel(instance.parkingDatabase);
        return instance;
    }

    public ParkingDatabase getParkingDatabase() {
        return parkingDatabase;
    }

    public RepositoryVehicle getRepositoryVehicle() {
        return repositoryVehicle;
    }

    public ServiceParkingEntry getServiceParkingEntry() {
        return serviceParkingEntry;
    }

    public ServiceParkingExit getServiceParkingExit() {
        return serviceParkingExit;
    }
}
