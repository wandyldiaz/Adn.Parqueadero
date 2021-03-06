package com.example.adnparqueadero.view;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adnparqueadero.R;

public class ParkingExitActivity extends MainActivity {

    private EditText etLicencePlate;
    private TextView tvTextViewSubTitle;
    private String licencePlate;
    private Button butMakeExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_exit);
        mapViews();
        final Observer<String> entryResultObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String result) {
                // Update the UI, in this case, a TextView.
                tvTextViewSubTitle.setText(result);
                cleanViews();
            }
        };
        viewModelParkingExit.getLiveDataResult().observe(this, entryResultObserver);
    }

    public void parkingExit(View view) {
        if (!validateExit())
            return;
        butMakeExit.setVisibility(View.INVISIBLE);
        viewModelParkingExit.makeExit(licencePlate);
    }

    private boolean validateExit() {
        licencePlate = etLicencePlate.getText().toString();
        if (licencePlate.length() < 5) {
            etLicencePlate.setError(getString(R.string.licence_plate_error));
            return false;
        }
        return true;
    }

    private void mapViews() {
        etLicencePlate = findViewById(R.id.etLicencePlate);
        tvTextViewSubTitle = findViewById(R.id.textViewSubTitle);
        butMakeExit = findViewById(R.id.btnMakeExit);
    }

    private void cleanViews(){
        etLicencePlate.setText("");
        butMakeExit.setVisibility(View.VISIBLE);
    }

}
