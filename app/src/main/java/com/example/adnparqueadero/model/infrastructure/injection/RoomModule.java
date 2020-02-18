package com.example.adnparqueadero.model.infrastructure.injection;

import android.app.Application;

import androidx.room.Room;

import com.example.adnparqueadero.model.adapter.ParkingEntryAdapter;
import com.example.adnparqueadero.model.adapter.ParkingEntryAdapterInterface;
import com.example.adnparqueadero.model.adapter.ParkingExitAdapter;
import com.example.adnparqueadero.model.adapter.ParkingExitAdapterInterface;
import com.example.adnparqueadero.model.adapter.RepositoryVehicleAdapter;
import com.example.adnparqueadero.model.adapter.RepositoryVehicleAdapterInterface;
import com.example.adnparqueadero.model.infrastructure.database.ParkingDatabase;
import com.example.adnparqueadero.model.domain.repository.ParkingRepository;
import com.example.adnparqueadero.model.infrastructure.repository.ParkingRepositoryImp;
import com.example.adnparqueadero.viewmodel.ViewModelParkingEntered;
import com.example.adnparqueadero.viewmodel.ViewModelParkingEntry;
import com.example.adnparqueadero.viewmodel.ViewModelParkingExit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {
    private static final String DB_NAME = "parking_db";
    private ParkingDatabase parkingDatabase;

    public RoomModule(Application myApplication) {
        parkingDatabase = Room.databaseBuilder(myApplication, ParkingDatabase.class, DB_NAME).fallbackToDestructiveMigration()
                .build();
    }

    @Singleton
    @Provides
    ParkingDatabase providesRoomDatabase() {
        return parkingDatabase;
    }

    @Singleton
    @Provides
    ParkingRepository parkingRepository(ParkingDatabase parkingDatabase) {
        return new ParkingRepositoryImp(parkingDatabase);
    }

    @Singleton
    @Provides
    ParkingEntryAdapterInterface parkingEntryAdapter(ParkingRepository parkingRepository) {
        return new ParkingEntryAdapter(parkingRepository);
    }

    @Singleton
    @Provides
    ParkingExitAdapterInterface parkingExitAdapter(ParkingRepository parkingRepository) {
        return new ParkingExitAdapter(parkingRepository);
    }

    @Singleton
    @Provides
    RepositoryVehicleAdapterInterface repositoryVehicleAdapter(ParkingRepository parkingRepository) {
        return new RepositoryVehicleAdapter(parkingRepository);
    }

    @Singleton
    @Provides
    ViewModelParkingEntry viewModelParkingEntry(ParkingEntryAdapterInterface parkingEntryAdapterInterface) {
        return new ViewModelParkingEntry(parkingEntryAdapterInterface);
    }

    @Singleton
    @Provides
    ViewModelParkingExit viewModelParkingExit(ParkingExitAdapterInterface parkingExitAdapterInterface) {
        return new ViewModelParkingExit(parkingExitAdapterInterface);
    }

    @Singleton
    @Provides
    ViewModelParkingEntered viewModelParkingEntered(RepositoryVehicleAdapterInterface repositoryVehicleAdapterInterface) {
        return new ViewModelParkingEntered(repositoryVehicleAdapterInterface);
    }
}
