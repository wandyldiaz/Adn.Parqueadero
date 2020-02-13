package com.example.adnparqueadero.view_model;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.adnparqueadero.R;
import com.example.adnparqueadero.model.adapter.ParkingExitAdapterInterface;
import javax.inject.Inject;

public class ParkingExitViewModel extends AsyncTask<String, String, String> {


    private Context context;
    private CallbackString callback;
    private ProgressDialog pd;
    private String licencePlate;
    ParkingExitAdapterInterface parkingExitAdapterInterface;

    /**
     * @param ctx
     * @param callback
     * @param licencePlate
     */
    public ParkingExitViewModel(Context ctx,  String licencePlate, CallbackString callback) {
        this.callback = callback;
        this.context = ctx;
        this.licencePlate = licencePlate;
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
        return objectManager.parkingExitAdapterInterface.makeExit(licencePlate);
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);
        try {

            if (pd != null && pd.isShowing())
                pd.dismiss();
            callback.response(response);

        } catch (Exception e) {
            Log.e("Error",e.toString());
        }
    }

}