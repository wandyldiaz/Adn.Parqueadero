package com.example.adnparqueadero;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.example.adnparqueadero.model.datos.database.ParqueaderoDatabase;
import com.example.adnparqueadero.model.domain.controler_domain.ControlerDomainDatosGet;
import com.example.adnparqueadero.model.domain.model.InterfaceDomainGet;
import com.example.adnparqueadero.model.domain.model.InterfaceRespuestas;

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
    Context appContext;
    InterfaceDomainGet controler;

    @Before
    public void iniciarDatos(){
        appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        controler = ControlerDomainDatosGet.getInstance(ParqueaderoDatabase.getInstance(appContext));
    }

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
        controler.getSelectAllDiaSemana(new InterfaceRespuestas.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] Respuesta) {
                datos=Respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(7, datos.length);

        controler.getSelectAllTipoVehiculo(new InterfaceRespuestas.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] Respuesta) {
                datos=Respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(2, datos.length);

        controler.getSelectAllLimiteVehiculos(new InterfaceRespuestas.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                datosMatriz=respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(2, datosMatriz.length);

        controler.getSelectAllTipoCondicion(new InterfaceRespuestas.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] Respuesta) {
                datos=Respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(1, datos.length);


        controler.getSelectAllLetraCondicion(new InterfaceRespuestas.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                datosMatriz=respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(1, datosMatriz.length);


        controler.getSelectAllTipoPrecios(new InterfaceRespuestas.CallbackHandlerRspArray() {
            @Override
            public void respuestaArray(String[] Respuesta) {
                datos=Respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(2, datos.length);

        controler.getSelectAllPrecios(new InterfaceRespuestas.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                datosMatriz=respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(4, datosMatriz.length);

        controler.getSelectAllPreciosCcMayor(new InterfaceRespuestas.CallbackHandlerRspMatriz() {
            @Override
            public void respuestaMatriz(String[][] respuesta) {
                datosMatriz=respuesta;
            }
        });
        Thread.sleep(200);
        assertEquals(1, datosMatriz.length);

    }
}
