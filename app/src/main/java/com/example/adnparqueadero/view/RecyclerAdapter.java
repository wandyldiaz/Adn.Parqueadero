package com.example.adnparqueadero.view;


import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import io.reactivex.annotations.NonNull;

public class RecyclerAdapter extends RecyclerView.Adapter<VehicleViewHolder> {

    private int layoutItem;
    private String[][] vehicleEntered;

    public RecyclerAdapter(String[][] vehicleEntered, int layoutItem) {
        this.vehicleEntered = vehicleEntered.clone();
        this.layoutItem = layoutItem;
    }

    @NonNull
    @Override
    public VehicleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VehicleViewHolder(LayoutInflater
                .from(parent.getContext())
                .inflate(layoutItem, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final VehicleViewHolder holder, final int position) {
        try{
            holder.licencePlate.setText(vehicleEntered[position][1]);
            holder.dateEntry.setText(vehicleEntered[position][2]);
            holder.hourEntry.setText(vehicleEntered[position][3]);
        }catch (Exception e){
            Log.e("Datos vacios",e.toString());
        }

    }

    @Override
    public int getItemCount() {
        return vehicleEntered.length;
    }

}
