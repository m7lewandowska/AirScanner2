package com.example.airscanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_sensor.*

class SensorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)

        var stationID = intent.getStringExtra("stationID")
        var stationNAME = intent.getStringExtra("stationNAME")
        //Toast.makeText(this, stationID, Toast.LENGTH_LONG).show()

        station_of_sensor_layout.text = stationNAME.toString()
    }
}
