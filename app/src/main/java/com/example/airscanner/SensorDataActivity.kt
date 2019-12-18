package com.example.airscanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sensor_data.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

        val client = retrofit.create(SensorDataService::class.java)
        Log.e("martha", sensorid.toString())
        client.getSensorsData(sensorid).enqueue(object: Callback<SensorData> {

            override fun onFailure(call: Call<SensorData>, t: Throwable) {
                Toast.makeText(this@SensorDataActivity,"Failure: " + t.message, Toast.LENGTH_LONG).show()
                Thread.sleep(2000)
                progressBar.visibility = View.GONE
                Log.e("marta",t.message!!)
            }

            override fun onResponse(call: Call<SensorData>, response: Response<SensorData>) {
                Thread.sleep(2000)
                progressBar.visibility = View.GONE
                AddToListView(response.body()!!)
            }
        })

    }

    fun AddToListView(listview_sensorsdata: SensorData){
        val listofSensorsData = listview_sensorsdata
        val adapter = SensorDataAdapter(this, listofSensorsData)
        listView3.adapter = adapter

    }
}
