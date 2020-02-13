package com.example.adnparqueadero.model.infrastructure.injection;

import android.app.Application;


import com.example.adnparqueadero.model.adapter.ParkingEntryAdapterInterface;
import com.example.adnparqueadero.model.adapter.ParkingExitAdapterInterface;
import com.example.adnparqueadero.model.adapter.RepositoryVehicleAdapterInterface;
import com.example.adnparqueadero.model.infrastructure.database.ParkingDatabase;
import com.example.adnparqueadero.model.infrastructure.repository.ParkingRepository;
import com.example.adnparqueadero.view.MainMenu;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(dependencies = {}, modules = {AppModule.class, RoomModule.class})
public interface AppComponent {

    void inject(MainMenu mainActivity);

    ParkingDatabase parkingDatabase();

    ParkingRepository parkingRepository();

    ParkingEntryAdapterInterface parkingEntryAdapter();

    ParkingExitAdapterInterface parkingExitAdapter();

    RepositoryVehicleAdapterInterface repositoryVehicleAdapter();

    Application application();

}
