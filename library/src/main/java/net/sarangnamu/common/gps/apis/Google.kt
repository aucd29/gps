package net.sarangnamu.common.gps.apis

import net.sarangnamu.common.gps.domains.Address
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by <a href="mailto:aucd29@hanwha.com">Burke Choi</a> on 2017. 11. 22.. <p/>
 */

interface IGoogle {
    @GET("/maps/api/geocode/json?latlng={lat},{lng}sensor=false&language={lang}")
    fun geocode(@Path("lat") lat: String, @Path("lng") lng: String, @Path("lang") lang: String): Call<Address>
}