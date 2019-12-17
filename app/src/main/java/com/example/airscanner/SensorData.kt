package com.example.airscanner

import com.google.gson.annotations.SerializedName

data class SensorData(
    @SerializedName("key")
    val key:String,

    @SerializedName("values")
    val values:List<Values>

)

data class Values(
    @SerializedName("date")
    val date:String,

    @SerializedName("value")
    val value:String
)