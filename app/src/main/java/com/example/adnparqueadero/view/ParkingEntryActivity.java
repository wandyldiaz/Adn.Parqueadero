package com.example.adnparqueadero.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.adnparqueadero.R;
import com.example.adnparqueadero.view_model.CallbackString;
import com.example.adnparqueadero.view_model.ParkingEntryViewModel;

public class ParkingEntryActivity extends AppCompatActivity {

    private EditText etLicencePlate;
    private EditText etCylinder;
    private RadioButton rbCar;
    private RadioButton rbMotorcycle;
    private String licencePlate;
    private int cylinder;
    private String typeVehicle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_entry);
        mapViews();
    }

    public void parkingEntry(View view) {
        if(!validateEntry())
            return;
        ParkingEntryViewModel parkingEntryViewModel= new ParkingEntryViewModel(this, licencePlate, typeVehicle
                , cylinder, new CallbackString() {
            @Override
            public void response(String reply) {
                Toast.makeText(getApplicationContext(),reply,Toast.LENGTH_LONG).show();
                finish();
            }
        });

        parkingEntryViewModel.execute();
    }

    private boolean validateEntry(){
        licencePlate=etLicencePlate.getText().toString();
        if(licencePlate.length()<5)
        {
            etLicencePlate.setError("Placa incorrecta");
            return false;
        }
        String cylinder=etCylinder.getText().toString();
        if(cylinder.length()<2)
        {
            etCylinder.setError("Cilindraje incorrecto");
            return false;
        }
        this.cylinder=Integer.parseInt(cylinder);
        typeVehicle=getTypeVehicle();
        if(typeVehicle.length()==0)
        {
            rbCar.setError("Seleccione alguno");
            rbMotorcycle.setError("Seleccione alguno");
            return false;
        }

        return true;
    }

    private String getTypeVehicle() {

        if(rbCar.isChecked()){
            return rbCar.getText().toString();
        }
        else if(rbMotorcycle.isChecked()){
            return rbMotorcycle.getText().toString();
        }
        return "";
    }

    private void mapViews() {
        etLicencePlate = findViewById(R.id.etLicencePlate);
        etCylinder = findViewById(R.id.etCylinder);
        rbCar = findViewById(R.id.rbCar);
        rbMotorcycle = findViewById(R.id.rbMotorcycle);
    }

}
