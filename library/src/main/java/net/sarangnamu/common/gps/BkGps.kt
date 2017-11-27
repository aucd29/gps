package net.sarangnamu.common.gps

import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import org.slf4j.LoggerFactory

/**
 * Created by <a href="mailto:aucd29@hanwha.com">Burke Choi</a> on 2017. 11. 22.. <p/>
 */

// http://www.androidhive.info/2012/07/android-gps-location-manager-tutorial/
class GpsHelper : LocationListener {
    companion object {
        private val log = LoggerFactory.getLogger(GpsHelper::class.java)

        val MIN_TIME_BW_UPDATES: Long = 1000 * 60 * 1
        val MIN_DISTANCE_CHANGE_FOR_UPDATES: Float = 10f
    }

    protected var manager: LocationManager
    protected var isGpsEnabled = false
    protected var isNetworkEnabled = false

    var location: Location? = null
    var context: Context
    var listener: ((Location?) -> Unit)? = null
    var canGetLocation = false

    var latitude: Double = 0.0
    var longitude: Double = 0.0

    constructor(context: Context) {
        this.context = context

        manager          = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        isGpsEnabled     = manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
        isNetworkEnabled = manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)

        if (!isGpsEnabled && !isNetworkEnabled) {
            log.error("ERROR: NO NETWORK PROVIDER IS ENABLED")
        } else {
            canGetLocation = true

            if (isNetworkEnabled) {
                manager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER,
                        MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this)

                location = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
                location?.let {
                    latitude = it.latitude
                    longitude = it.longitude
                }
            }

            // if GPS Enabled get lat/long using GPS Services
            if (isGpsEnabled && location == null) {
                manager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                        MIN_TIME_BW_UPDATES, MIN_DISTANCE_CHANGE_FOR_UPDATES, this)

                location = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
                location?.let {
                    latitude = it.latitude
                    longitude = it.longitude
                }
            }
        }
    }

    fun stop() {
        manager.removeUpdates(this)
    }

    ////////////////////////////////////////////////////////////////////////////////////
    //
    // LocationListener
    //
    ////////////////////////////////////////////////////////////////////////////////////

    override fun onLocationChanged(location: Location?) {
        listener?.let { it(location) }
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {    }
    override fun onProviderEnabled(provider: String?) {    }
    override fun onProviderDisabled(provider: String?) {    }
}
