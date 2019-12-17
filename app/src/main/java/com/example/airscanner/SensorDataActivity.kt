package com.example.airscanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class SensorDataActivity : AppCompatActivity() {

    private lateinit var listView3: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor_data)

        listView3 = findViewById(R.id.listview_sensorsdata)


        var sensorid = intent.getStringExtra("sensorid")
        //Toast.makeText(this, sensorid, Toast.LENGTH_LONG).show()

        val BASE_URL = "http://api.gios.gov.pl/pjp-api/rest/"

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

    }
}
