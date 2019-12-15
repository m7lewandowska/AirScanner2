package com.example.airscanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_sensor.*
import kotlinx.android.synthetic.main.layout_sensor.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SensorActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)

        listView = findViewById(R.id.listview_sensors)




        var stationID = intent.getStringExtra("stationID")
        var stationNAME = intent.getStringExtra("stationNAME")
        //Toast.makeText(this, stationID, Toast.LENGTH_LONG).show()

        station_of_sensor_layout.text = stationNAME.toString()



        val BASE_URL = "http://api.gios.gov.pl/pjp-api/rest/"

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()





    }
}
