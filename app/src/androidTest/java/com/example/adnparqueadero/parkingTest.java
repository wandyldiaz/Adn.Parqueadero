package com.example.adnparqueadero;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;
import androidx.test.uiautomator.UiDevice;

import com.example.adnparqueadero.view.MainMenuActivity;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class parkingTest {

    private static final String ERROR_VEHICLE_ENTERED = "Error el vehiculo ya se encuentra en el parqueadero";
    private static final String ERROR_VEHICLE_LIMIT = "Error no hay cupo en el parqueadero";
    private static final String ERROR_VEHICLE_DAY = "Error el vehiculo no puede ingresar el dia de hoy";
    private static final String ERROR_VEHICLE_ENTRY = "Error no se pudo ingresar el vehiculo";
    private static final String ERROR_REGISTERED_VEHICLE = "Error no se pudo registrar el vehiculo";
    private static final String ERROR_DATA = "Error datos nulos o incorrectos";
    private static final String SUCCESS_VEHICLE_ENTRY = "Vehiculo ingresado exitosamente";

    private static final String ERROR_VEHICLE_DATA = "Error al obtener los datos del vehiculo registrado";
    private static final String ERROR_VEHICLE_EXIT = "Error al realizar la salida del vehiculo";
    private static final String SUCCESS_VEHICLE_EXIT = "Salida realizada exitosamente";
    private static final String ERROR_VEHICLE_NOT_ENTERED = "Error el vehiculo no esta en el parqueadero";

    @Rule
    public ActivityTestRule<MainMenuActivity> mActivityTestRule = new ActivityTestRule<>(MainMenuActivity.class);

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void testEntry() throws InterruptedException {

        clickInput(R.id.btnParkingExit);
        clickInput(R.id.etLicencePlate);
        keyPressInput("PRUEBA", R.id.etLicencePlate);
        clickInput(R.id.btnMakeExit);
        Thread.sleep(4000);

        pressBack();

        clickInput(R.id.btnParkingEntry);
        clickInput(R.id.etLicencePlate);
        keyPressInput("PRUEBA", R.id.etLicencePlate);
        clickInput(R.id.etCylinder);
        keyPressInput("500", R.id.etCylinder);
        clickInput(R.id.rbCar);
        clickInput(R.id.btnMakeEntry);
        Thread.sleep(4000);
        onView(allOf(withText(SUCCESS_VEHICLE_ENTRY))).check(matches(withText(SUCCESS_VEHICLE_ENTRY)));

    }
    @Test
    public void testExit() throws InterruptedException {
        clickInput(R.id.btnParkingExit);
        clickInput(R.id.etLicencePlate);
        keyPressInput("PRUEBA", R.id.etLicencePlate);
        clickInput(R.id.btnMakeExit);
        Thread.sleep(4000);
        pressBack();

        clickInput(R.id.btnParkingEntry);
        clickInput(R.id.etLicencePlate);
        keyPressInput("PRUEBA", R.id.etLicencePlate);
        clickInput(R.id.etCylinder);
        keyPressInput("500", R.id.etCylinder);
        clickInput(R.id.rbCar);
        clickInput(R.id.btnMakeEntry);
        Thread.sleep(4000);

        pressBack();

        clickInput(R.id.btnParkingExit);
        clickInput(R.id.etLicencePlate);
        keyPressInput("PRUEBA", R.id.etLicencePlate);
        clickInput(R.id.btnMakeExit);
        Thread.sleep(4000);
        onView(allOf(withText(SUCCESS_VEHICLE_EXIT + "\n"
                + "Horas parqueado: " + 0 + "\n"
                + "Precio: " + 1000))).check(matches(withText(SUCCESS_VEHICLE_EXIT + "\n"
                + "Horas parqueado: " + 0 + "\n"
                + "Precio: " + 1000)));

    }

    private void keyPressInput(String valueToWrite, int editText) {
        onView(withId(editText)).perform(replaceText(valueToWrite), closeSoftKeyboard());
    }

    private void clickInput(int view) {
        onView(withId(view)).perform(click());
    }

    private void pressBack(){
        UiDevice mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());
        mDevice.pressBack();
    }

}
