package com.example.adnparqueadero.model.infrastructure.injection;

import android.app.Application;


import com.example.adnparqueadero.model.adapter.ParkingEntryAdapterInterface;
import com.example.adnparqueadero.model.adapter.ParkingExitAdapterInterface;
import com.example.adnparqueadero.model.adapter.RepositoryVehicleAdapterInterface;
import com.example.adnparqueadero.model.infrastructure.database.ParkingDatabase;
import com.example.adnparqueadero.model.domain.repository.ParkingRepository;
import com.example.adnparqueadero.view.MainActivity;
import com.example.adnparqueadero.viewmodel.ViewModelParkingEntered;
import com.example.adnparqueadero.viewmodel.ViewModelParkingEntry;
import com.example.adnparqueadero.viewmodel.ViewModelParkingExit;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {}, modules = {AppModule.class, RoomModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    ParkingDatabase parkingDatabase();

    ParkingRepository parkingRepository();

    ParkingEntryAdapterInterface parkingEntryAdapter();

    ParkingExitAdapterInterface parkingExitAdapter();

    RepositoryVehicleAdapterInterface repositoryVehicleAdapter();

    ViewModelParkingEntry viewModelParkingEntry();

    ViewModelParkingExit viewModelParkingExit();

    ViewModelParkingEntered viewModelParkingEntered();

    Application application();

}
