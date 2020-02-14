package com.example.adnparqueadero.viewmodel;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.example.adnparqueadero.R;
import com.example.adnparqueadero.model.adapter.RepositoryVehicleAdapterInterface;

public class RepositoryVehicleViewModel  extends AsyncTask<String, String, String> {


    private Context context;
    private CallbackString callback;
    private ProgressDialog pd;
    private String licencePlate;
    RepositoryVehicleAdapterInterface repositoryVehicleAdapterInterface;

    /**
     * @param ctx
     * @param callback
     * @param licencePlate
     */
    public RepositoryVehicleViewModel(Context ctx,  String licencePlate, CallbackString callback) {
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




        return "";


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