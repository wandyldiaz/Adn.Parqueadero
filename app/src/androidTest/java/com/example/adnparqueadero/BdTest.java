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
public class BdTest {
    String[] datos;
    String[][] datosMatriz;
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
    public void SeleccionDatos() throws InterruptedException {
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        InterfaceModelDomain cont= ControlerDomainDatos.getInstance(appContext);

        cont.getSelectAllDiaSemana(new InterfaceModelDomain.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] Respuesta) {
                datos=Respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(7, datos.length);

        cont.getSelectAllTipoVehiculo(new InterfaceModelDomain.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] Respuesta) {
                datos=Respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(2, datos.length);

        cont.getSelectAllLimiteVehiculos(new InterfaceModelDomain.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                datosMatriz=respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(2, datosMatriz.length);

        cont.getSelectAllTipoCondicion(new InterfaceModelDomain.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] Respuesta) {
                datos=Respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(1, datos.length);


        cont.getSelectAllLetraCondicion(new InterfaceModelDomain.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                datosMatriz=respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(1, datosMatriz.length);


        cont.getSelectAllTipoPrecios(new InterfaceModelDomain.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] Respuesta) {
                datos=Respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(2, datos.length);

        cont.getSelectAllPrecios(new InterfaceModelDomain.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                datosMatriz=respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(4, datosMatriz.length);

        cont.getSelectAllPreciosCcMayor(new InterfaceModelDomain.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                datosMatriz=respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(1, datosMatriz.length);

    }
}