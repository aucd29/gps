package net.sarangnamu.common.gps

import android.location.Location
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    @Throws(Exception::class)
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("net.sarangnamu.common.gps", appContext.packageName)
    }

    @Test
    fun testgps() {
        System.out.println("== TEST GPS ==")

        val context = InstrumentationRegistry.getTargetContext()
        val gps = GpsHelper(context)
        gps.listener = object: GpsListener {
            override fun onChanged(location: Location?) {
                System.out.println("GPS CHANGED")

                GeoCodeHelper().fetch(gps)
            }
        }
    }
}
