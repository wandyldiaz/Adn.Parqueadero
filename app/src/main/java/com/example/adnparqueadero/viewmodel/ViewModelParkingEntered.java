package com.example.adnparqueadero.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.adnparqueadero.model.adapter.RepositoryVehicleAdapterInterface;

import javax.inject.Inject;

public class ViewModelParkingEntered extends ViewModel {

    private RepositoryVehicleAdapterInterface repositoryVehicleAdapterInterface;
    private MutableLiveData<String[][]> liveDataResult = new MutableLiveData<>();
    private final Runnable executeExitRunnable = new Runnable() {
        @Override
        public void run() {
            String[][]result=repositoryVehicleAdapterInterface.getVehicleEntered();
            liveDataResult.postValue(result);
        }
    };

    @Inject
    public ViewModelParkingEntered(RepositoryVehicleAdapterInterface repositoryVehicleAdapterInterface) {
        this.repositoryVehicleAdapterInterface = repositoryVehicleAdapterInterface;
    }

    public void getVehicleEnetered() {
        try {
            new Thread(executeExitRunnable).start();
        } catch (Exception e){
            Log.e("ErrorIngreso",e.toString());
        }
    }

    public LiveData<String[][]> getLiveDataResult() {
        return liveDataResult;
    }
}
