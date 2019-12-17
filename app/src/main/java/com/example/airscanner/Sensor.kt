package com.example.airscanner

import com.google.gson.annotations.SerializedName

data class Sensor(
    @SerializedName("stationName")
    val stationName:String,

//    @SerializedName("paramName")
//    val paramName:String,
//
//    @SerializedName("paramCode")
//    val paramCode:String
    @SerializedName("param")
     val param:Param
)
data class Param(
    @SerializedName("paramName")
    val paramName:String,

    @SerializedName("paramCode")
    val paramCode:String
)
