package com.example.adnparqueadero;

import android.content.Context;

import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import model.domain.controler_domain.database.ParqueaderoDatabase;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class bdTest {
    @Test
    public void creationBd() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        if(ParqueaderoDatabase.getInstance(appContext)!=null)
            assertEquals(4, 2 + 2);
        else
            assertEquals(4, 2 + 5);

        //assertEquals("com.example.adnparqueadero", appContext.getPackageName());
    }
}
