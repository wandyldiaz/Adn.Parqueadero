package com.example.adnparqueadero.view_model;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.adnparqueadero.R;
import com.example.adnparqueadero.model.adapter.ParkingEntryAdapterInterface;

import javax.inject.Inject;


/**
 * Created by Wandyl Diaz 07/08/2015
 */
public class ParkingEntryViewModel extends AsyncTask<String, String, String> {


    private Context context;
    private CallbackString callback;
    private ProgressDialog pd;
    private String licencePlate;
    private String typeVehicle;
    private int cylinder;
    ParkingEntryAdapterInterface parkingEntryAdapterInterface;

    /**
     * @param ctx
     * @param licencePlate
     * @param typeVehicle
     * @param cylinder
     * @param callback
     */
    public ParkingEntryViewModel(Context ctx, String licencePlate, String typeVehicle, int cylinder,
                                 CallbackString callback) {
        this.callback = callback;
        this.context = ctx;
        this.licencePlate = licencePlate;
        this.typeVehicle = typeVehicle;
        this.cylinder = cylinder;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd = new ProgressDialog(context, R.style.MyAlertDialogStyle);
        pd.setCanceledOnTouchOutside(false);
        pd.setCancelable(false);
        pd.setMessage("Realizando...");
        pd.show();

    }
    @Override
    protected String doInBackground(String... strings) {
        return objectManager.parkingEntryAdapterInterface.VehicleEntry(licencePlate,cylinder,typeVehicle);
    }
    @Override
    protected void onPostExecute(String Response) {
        super.onPostExecute(Response);
        try {
            if (pd != null && pd.isShowing())
                pd.dismiss();

            callback.response(Response);

        } catch (Exception e) {
            Log.e("Error",e.toString());
        }
    }
}


