package com.example.adnparqueadero;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.adnparqueadero.model.datos.database.ParqueaderoDatabase;
import com.example.adnparqueadero.model.domain.controler_domain.ControlerDomainDatos;
import com.example.adnparqueadero.model.domain.model.InterfaceModelDomain;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class bdTest {
    String[] datos;
    @Test
    public void creationBd() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        if(ParqueaderoDatabase.getInstance(appContext)!=null)
            assertEquals(4, 2 + 2);
        else
            assertEquals(4, 2 + 5);
    }
    @Test
    public void InserccionDatos() throws InterruptedException {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        InterfaceModelDomain cont= ControlerDomainDatos.getInstance(appContext);

        cont.getSelectAllDiaSemana(new InterfaceModelDomain.CallbackHandlerRspArray() {
            @Override
            public void RspArray(String[] Respuesta) {
                datos=Respuesta;
            }
        });
        Thread.sleep(500);
        assertEquals(7, datos.length);

        cont.getSelectAllTipoVehiculo(new InterfaceModelDomain.CallbackHandlerRspArray() {
            @Override
            public void RspArray(String[] Respuesta) {
                datos=Respuesta;
            }
        });
        Thread.sleep(500);
        assertEquals(2, datos.length);

    }
}
