package com.example.adnparqueadero.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.adnparqueadero.R;
import com.example.adnparqueadero.model.adapter.ParkingEntryAdapterInterface;
import com.example.adnparqueadero.model.adapter.ParkingExitAdapterInterface;
import com.example.adnparqueadero.model.adapter.RepositoryVehicleAdapterInterface;
import com.example.adnparqueadero.model.infrastructure.injection.AppModule;
import com.example.adnparqueadero.model.infrastructure.injection.DaggerAppComponent;
import com.example.adnparqueadero.model.infrastructure.injection.RoomModule;
import com.example.adnparqueadero.view_model.objectManager;

import javax.inject.Inject;

public class MainMenu extends AppCompatActivity {
    @Inject
    ParkingEntryAdapterInterface parkingEntryAdapterInterface;
    @Inject
    ParkingExitAdapterInterface parkingExitAdapterInterface;
    @Inject
    RepositoryVehicleAdapterInterface repositoryVehicleAdapterInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        DaggerAppComponent.builder()
                .appModule(new AppModule(getApplication()))
                .roomModule(new RoomModule(getApplication()))
                .build()
                .inject(this);
        objectManager.parkingEntryAdapterInterface=parkingEntryAdapterInterface;
        objectManager.parkingExitAdapterInterface=parkingExitAdapterInterface;
        objectManager.repositoryVehicleAdapterInterface=repositoryVehicleAdapterInterface;

    }

    public void parkingEntry(View view) {
        Intent intent = new Intent(this, ParkingEntryActivity.class);
        startActivity(intent);
    }

    public void parkingExit(View view) {
        Intent intent = new Intent(this, ParkingExitActivity.class);
        startActivity(intent);
    }

    public void close(View view) {
        ActivityCompat.finishAffinity(MainMenu.this);
        finish();
        System.exit(0);
    }
}
