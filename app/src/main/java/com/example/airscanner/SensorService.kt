package com.example.airscanner

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SensorService{


    @GET("station/sensors/{stationId}")

    fun getSensors(@Path("stationId") stationId: String): Call<List<Sensor>>

}