package com.example.airscanner

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface SensorDataService{

    @GET("data/getData/{sensorId}")

    fun getSensorsData(@Path("sensorId") sensorId: String): Call<SensorData>

}