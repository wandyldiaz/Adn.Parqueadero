package com.example.adnparqueadero.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.adnparqueadero.R;

public class ParkingEntryActivity extends MainActivity {

    private EditText etLicencePlate;
    private EditText etCylinder;
    private RadioButton rbCar;
    private RadioButton rbMotorcycle;
    private String licencePlate;
    private int cylinder;
    private String typeVehicle;
    private Button butEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_entry);
        mapViews();
        final Observer<String> entryResultObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String result) {
                // Update the UI, in this case, a TextView.
                butEntry.setVisibility(View.VISIBLE);
                Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG).show();
            }
        };
        viewModelParkingEntry.getLiveDataResult().observe(this, entryResultObserver);
    }

    public void parkingEntry(View view) {
        if (!validateEntry())
            return;
        butEntry.setVisibility(View.INVISIBLE);
        viewModelParkingEntry.startVehicleEntry(licencePlate, cylinder, typeVehicle);
    }

    private boolean validateEntry() {
        boolean validate = true;
        licencePlate = etLicencePlate.getText().toString();
        if (licencePlate.length() < 5) {
            etLicencePlate.setError("Placa incorrecta");
            validate = false;
        }
        String cylinderString = etCylinder.getText().toString();
        if (cylinderString.length() < 2) {
            etCylinder.setError("Cilindraje incorrecto");
            validate = false;
        }
        this.cylinder = Integer.parseInt(cylinderString);
        typeVehicle = getTypeVehicle();
        if (typeVehicle.length() == 0) {
            rbCar.setError("Seleccione alguno");
            rbMotorcycle.setError("Seleccione alguno");
            validate = false;
        }

        return validate;
    }

    private String getTypeVehicle() {

        if (rbCar.isChecked()) {
            return rbCar.getText().toString();
        } else if (rbMotorcycle.isChecked()) {
            return rbMotorcycle.getText().toString();
        }
        return "";
    }

    private void mapViews() {
        etLicencePlate = findViewById(R.id.etLicencePlate);
        etCylinder = findViewById(R.id.etCylinder);
        rbCar = findViewById(R.id.rbCar);
        rbMotorcycle = findViewById(R.id.rbMotorcycle);
        butEntry = findViewById(R.id.btnParkingEntry);
    }

}
