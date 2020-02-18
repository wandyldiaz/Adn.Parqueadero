package com.example.adnparqueadero.view;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adnparqueadero.model.infrastructure.injection.AppModule;
import com.example.adnparqueadero.model.infrastructure.injection.DaggerAppComponent;
import com.example.adnparqueadero.model.infrastructure.injection.RoomModule;
import com.example.adnparqueadero.viewmodel.ViewModelParkingEntered;
import com.example.adnparqueadero.viewmodel.ViewModelParkingEntry;
import com.example.adnparqueadero.viewmodel.ViewModelParkingExit;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Inject
    protected ViewModelParkingEntry viewModelParkingEntry;
    @Inject
    protected ViewModelParkingEntered viewModelParkingEntered;
    @Inject
    protected ViewModelParkingExit viewModelParkingExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .build()
                .inject(this);
    }
}
