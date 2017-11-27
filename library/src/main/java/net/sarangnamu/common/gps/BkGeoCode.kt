package net.sarangnamu.common.gps

import android.location.Geocoder
import net.sarangnamu.common.gps.apis.IGoogle
import net.sarangnamu.common.gps.domains.Address
import net.sarangnamu.common.retro_jackson.Retro
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

/**
 * Created by <a href="mailto:aucd29@hanwha.com">Burke Choi</a> on 2017. 11. 22.. <p/>
 */

interface GeoCodeListener {
    fun onReceive(cityName: String)
}

class GeoCodeHelper {
    companion object {
        val BASE_URL = "http://maps.googleapis.com"
        val UNKNOWN  = "unknown"
    }

    var listener: GeoCodeListener? = null

    fun fetch(gps: GpsHelper, lang: String = "ko") {
        if (Geocoder.isPresent()) {
            fromGeocoder(gps)
        } else {
            fromGoogle(gps, lang)
        }
    }

    private fun fromGeocoder(gps: GpsHelper) {
        val addrList = Geocoder(gps.context, Locale.US).getFromLocation(gps.latitude, gps.longitude, 1)

        if (addrList.size > 0) {
            listener?.onReceive(addrList.get(0).locality)
        }
    }

    private fun fromGoogle(gps: GpsHelper, lang: String) {
        val retro = Retro.instance(BASE_URL).create(IGoogle::class.java)
        val call = retro.geocode(gps.latitude.toString(), gps.longitude.toString(), lang)
        call.enqueue(object: Callback<Address> {
            override fun onResponse(call: Call<Address>?, response: Response<Address>?) {
                response?.let {
                    if (it.isSuccessful) {
                        it.body()?.let { addr ->
                            if (addr.status == "OK") {
                                for (result in addr.results) {
                                    for (component in result.address_components) {
                                        if (component.types.get(0) == "locality") {
                                            listener?.onReceive(component.long_name)
                                            return
                                        }
                                    }
                                }
                            }

                            listener?.onReceive(UNKNOWN)
                        }
                    } else {
                        listener?.onReceive(UNKNOWN)
                    }
                }
            }

            override fun onFailure(call: Call<Address>?, t: Throwable?) {
                listener?.onReceive(UNKNOWN)
            }
        })
    }
}
