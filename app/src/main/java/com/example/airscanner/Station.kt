package com.example.airscanner

import com.google.gson.annotations.SerializedName

data class Station(
    @SerializedName("id")
    val id:Int,
    @SerializedName("stationName")
    val stationName:String
    )