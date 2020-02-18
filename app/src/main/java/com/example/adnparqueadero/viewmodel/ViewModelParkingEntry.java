package com.example.adnparqueadero.viewmodel;


import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.adnparqueadero.model.adapter.ParkingEntryAdapterInterface;

import javax.inject.Inject;

public class ViewModelParkingEntry extends ViewModel {

    private ParkingEntryAdapterInterface parkingEntryAdapterInterface;
    private MutableLiveData<String> liveDataResult = new MutableLiveData<>();
    private String licencePlate;
    private int cylinder;
    private String typeVehicle;
    private final Runnable executeEntryRunnable = new Runnable() {
        @Override
        public void run() {
            liveDataResult.postValue(parkingEntryAdapterInterface.vehicleEntry(licencePlate, cylinder, typeVehicle));
        }
    };

    @Inject
    public ViewModelParkingEntry(ParkingEntryAdapterInterface parkingEntryAdapterInterface) {
        this.parkingEntryAdapterInterface = parkingEntryAdapterInterface;
    }

    public void startVehicleEntry(String licencePlate, int cylinder, String typeVehicle) {
        this.licencePlate = licencePlate;
        this.cylinder = cylinder;
        this.typeVehicle = typeVehicle;
        try {
            new Thread(executeEntryRunnable).start();
        } catch (Exception e) {
            Log.e("ErrorIngreso", e.toString());
        }
    }

    public LiveData<String> getLiveDataResult() {
        return liveDataResult;
    }
}
