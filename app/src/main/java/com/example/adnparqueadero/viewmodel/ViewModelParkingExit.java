package com.example.adnparqueadero.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.adnparqueadero.model.adapter.ParkingExitAdapterInterface;

import javax.inject.Inject;

public class ViewModelParkingExit extends ViewModel {

    protected ParkingExitAdapterInterface parkingExitAdapterInterface;
    private MutableLiveData<String> liveDataResult = new MutableLiveData<>();
    private String licencePlate;
    private final Runnable executeExitRunnable = new Runnable() {
        @Override
        public void run() {
            liveDataResult.postValue(parkingExitAdapterInterface.makeExit(licencePlate));
        }
    };

    @Inject
    public ViewModelParkingExit(ParkingExitAdapterInterface parkingExitAdapterInterface) {
        this.parkingExitAdapterInterface = parkingExitAdapterInterface;
    }

    public void makeExit(String licencePlate) {
        this.licencePlate = licencePlate;
        try {
            new Thread(executeExitRunnable).start();
        } catch (Exception e){
            Log.e("ErrorIngreso",e.toString());
        }
    }

    public LiveData<String> getLiveDataResult() {
        return liveDataResult;
    }

}
