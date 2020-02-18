package com.example.adnparqueadero.view;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.adnparqueadero.R;

public class VehicleViewHolder extends RecyclerView.ViewHolder{

    protected TextView licencePlate;
    protected TextView dateEntry;
    protected TextView hourEntry;

    VehicleViewHolder(View itemView) {
        super(itemView);
        licencePlate = (TextView)itemView.findViewById(R.id.licencePlate);
        dateEntry = (TextView)itemView.findViewById(R.id.dateEntry);
        hourEntry = (TextView)itemView.findViewById(R.id.hourEntry);

    }
}
