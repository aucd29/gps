package net.sarangnamu.common.gps.apis

import net.sarangnamu.common.gps.domains.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by <a href="mailto:aucd29@hanwha.com">Burke Choi</a> on 2017. 11. 22.. <p/>
 */

interface IGoogle {
    @GET("/maps/api/geocode/json?sensor=false")
    fun geocode(@Query("latlng") latlng: String, @Query("language") lang: String): Call<Address>
}