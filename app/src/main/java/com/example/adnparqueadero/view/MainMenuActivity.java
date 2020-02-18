package com.example.adnparqueadero.view;

import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.adnparqueadero.R;


public class MainMenuActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void parkingEntry(View view) {
        Intent intent = new Intent(this, ParkingEntryActivity.class);
        startActivity(intent);
    }

    public void parkingExit(View view) {
        Intent intent = new Intent(this, ParkingExitActivity.class);
        startActivity(intent);
    }

    public void parkingEntered(View view) {
        Intent intent = new Intent(this, ParkingEnteredActivity.class);
        startActivity(intent);
    }

    public void close(View view) {
        ActivityCompat.finishAffinity(MainMenuActivity.this);
        finish();
        System.exit(0);
    }
}
