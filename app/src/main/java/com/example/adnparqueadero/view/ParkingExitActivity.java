package com.example.adnparqueadero.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.adnparqueadero.R;
import com.example.adnparqueadero.view_model.CallbackString;
import com.example.adnparqueadero.view_model.ParkingExitViewModel;

public class ParkingExitActivity extends AppCompatActivity {

    private EditText etLicencePlate;
    private String licencePlate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_exit);
        mapViews();
    }

    public void parkingExit(View view) {
        if(!validateExit())
            return;
        ParkingExitViewModel parkingEntryViewModel= new ParkingExitViewModel(this, licencePlate,new CallbackString() {
            @Override
            public void response(String reply) {
                Toast.makeText(getApplicationContext(),reply,Toast.LENGTH_LONG).show();
                finish();
            }
        });

        parkingEntryViewModel.execute();
    }

    private boolean validateExit(){
        licencePlate=etLicencePlate.getText().toString();
        if(licencePlate.length()<5)
        {
            etLicencePlate.setError("Placa incorrecta");
            return false;
        }
        return true;
    }
    private void mapViews() {
        etLicencePlate = findViewById(R.id.etLicencePlate);
    }


}
