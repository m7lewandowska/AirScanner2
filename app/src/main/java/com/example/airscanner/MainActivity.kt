package com.example.airscanner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listView = findViewById(R.id.listview_stations)

        //val listOfStations = mutableListOf<Station>()


        val BASE_URL = "http://api.gios.gov.pl/pjp-api/rest/"

        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()

       val client = retrofit.create(StationService::class.java)

        client.getStations().enqueue(object: Callback<List<Station>>{
            override fun onFailure(call: Call<List<Station>>, t: Throwable) {
                Toast.makeText(this@MainActivity,"Failure: " + t.message,Toast.LENGTH_LONG).show()
                Log.e("marta",t.message)
            }

            override fun onResponse(call: Call<List<Station>>, response: Response<List<Station>>) {

                AddToListView(response.body()!!.sortedBy { it.stationName })

            }

        })

    }

        fun AddToListView(listview_stations: List<Station>){
            val listofStations = listview_stations
            val adapter = StationAdapter(this, listofStations)
            listView.adapter = adapter

    }
}
