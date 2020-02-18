package com.example.adnparqueadero.view;

import androidx.annotation.Nullable;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adnparqueadero.R;

public class ParkingEnteredActivity extends MainActivity {

    private RecyclerView rvVehicleEntered;
    private String[][] matrizVechicleEntered=new String[0][0];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_entered);
        mapsView();
        final Observer<String[][]> entryResultObserver = new Observer<String[][]>() {
            @Override
            public void onChanged(@Nullable final String[][] result) {
                // Update the UI, in this case, a TextView.
                if(result==null)
                    matrizVechicleEntered=new String[0][0];
                else
                    matrizVechicleEntered=result.clone();
                fillRecycler();
            }
        };
        viewModelParkingEntered.getLiveDataResult().observe(this,entryResultObserver );
        fillRecycler();
    }

    private void mapsView(){
        rvVehicleEntered=findViewById(R.id.rvVehicleEntered);
    }

    private void fillRecycler(){
        RecyclerAdapter adapter;
        rvVehicleEntered.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvVehicleEntered.setLayoutManager(linearLayoutManager);
        if(matrizVechicleEntered.length>0)
            adapter= new RecyclerAdapter(matrizVechicleEntered,R.layout.vehicle_item);
        else
        {
            matrizVechicleEntered=new String[1][0];
            adapter= new RecyclerAdapter(matrizVechicleEntered,R.layout.empty_view);
        }
        rvVehicleEntered.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModelParkingEntered.getVehicleEnetered();
    }
}
