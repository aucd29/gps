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

class GeoCodeHelper(var listener: ((String) -> Unit)? = null) {
    companion object {
        val BASE_URL = "http://maps.googleapis.com"
        val UNKNOWN  = "unknown"
    }

    fun fetch(gps: GpsHelper, lang: String = "ko") {
        if (Geocoder.isPresent()) {
            fromGeocoder(gps, lang)
        } else {
            fromGoogle(gps, lang)
        }
    }

    private fun fromGeocoder(gps: GpsHelper, lang: String) {
        val addrList = Geocoder(gps.context, Locale(lang)).getFromLocation(gps.latitude, gps.longitude, 1)

        if (addrList.size > 0) {
            callback(addrList.get(0).locality)
        }
    }

    private fun fromGoogle(gps: GpsHelper, lang: String) {
        val retro = Retro.instance(BASE_URL).create(IGoogle::class.java)
        val call = retro.geocode("${gps.latlng()}", lang)
        call.enqueue(object: Callback<Address> {
            override fun onResponse(call: Call<Address>?, response: Response<Address>?) {
                response?.let {
                    if (it.isSuccessful) {
                        it.body()?.let { addr ->
                            if (addr.status == "OK") {
                                for (result in addr.results) {
                                    for (component in result.address_components) {
                                        if (component.types.get(0) == "locality") {
                                            callback(component.long_name)
                                            return
                                        }
                                    }
                                }
                            }

                            callback(UNKNOWN)
                        }
                    } else {
                        callback(UNKNOWN)
                    }
                }
            }

            override fun onFailure(call: Call<Address>?, t: Throwable?) {
                t?.printStackTrace()
                callback(UNKNOWN)
            }
        })
    }

    private fun callback(name: String) {
        listener?.let { it(name) }
    }
}
