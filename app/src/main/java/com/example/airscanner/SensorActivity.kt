package com.example.airscanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import android.widget.Toast
import com.google.gson.Gson
import kotlinx.android.synthetic.main.activity_sensor.*
import kotlinx.android.synthetic.main.layout_sensor.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.reflect.TypeToken
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T



class SensorActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    private lateinit var sensorservice: SensorService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sensor)

        listView = findViewById(R.id.listview_sensors)



        var stationID = intent.getStringExtra("stationID")
        //var stationNAME = intent.getStringExtra("stationNAME")
        //Toast.makeText(this, stationID, Toast.LENGTH_LONG).show()
        //station_of_sensor_name_layout.text = stationNAME.toString()

        val BASE_URL = "http://api.gios.gov.pl/pjp-api/rest/"

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

        val client = retrofit.create(SensorService::class.java)

        client.getSensors(stationID).enqueue(object: Callback<List<Sensor>> {

            override fun onFailure(call: Call<List<Sensor>>, t: Throwable) {
                Toast.makeText(this@SensorActivity,"Failure: " + t.message, Toast.LENGTH_LONG).show()
                Log.e("marta",t.message)
            }

            override fun onResponse(call: Call<List<Sensor>>, response: Response<List<Sensor>>) {

                //List<Sensor> list = Gson().fromJson(response.body(), Sensor::class.java)

               // val sensors = Gson().fromJson<Sensor>(response.body(), Sensor::class.java)

//                val gson = Gson()
//                val jsonString = gson.toJson(response.body())
//                val sType = object : TypeToken<List<String>>() { }.type
//                val otherList = gson.fromJson<List<Sensor>>(jsonString, sType)
//
//                AddToListView(otherList)
                AddToListView(response.body()!!)

            }

        })
    }

    fun AddToListView(listview_sensors: List<Sensor>){
        val listofSensors = listview_sensors
        val adapter = SensorAdapter(this, listofSensors)
        listView.adapter = adapter

    }
}
