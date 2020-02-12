package com.example.adnparqueadero;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.runner.RunWith;

import com.example.adnparqueadero.model.data.database.ParkingDatabase;
import com.example.adnparqueadero.model.domain.controller_domain.RepositoryVehicle;
import com.example.adnparqueadero.model.service.ServiceRepositoryVehicle;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class BdTest {
    String[] datos;
    String[][] datosMatriz;
    Context appContext;
    ServiceRepositoryVehicle controler;

    @Before
    public void iniciarDatos(){
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        controler = RepositoryVehicle.getInstance(ParkingDatabase.getInstance(appContext));
    }

}
