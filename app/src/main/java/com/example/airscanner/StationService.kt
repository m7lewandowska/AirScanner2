package com.example.airscanner

import retrofit2.Call
import retrofit2.http.GET

interface StationService
{
    @GET("station/findAll")

    fun getStations(): Call<List<Station>>
}