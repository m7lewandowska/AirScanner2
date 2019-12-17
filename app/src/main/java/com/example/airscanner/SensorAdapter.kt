package com.example.airscanner

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.google.gson.Gson

class SensorAdapter(private val context: Context, private val dataSource: List<Sensor>): BaseAdapter()
{
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.layout_sensor, parent, false)

        val sensorParamCode = rowView.findViewById(R.id.sensor_paramCode_layout) as TextView
        val sensorParamName = rowView.findViewById(R.id.sensor_paramName_layout) as TextView
        val stationName = rowView.findViewById(R.id.station_of_sensor_name_layout) as TextView


        val sensor = getItem(position) as Sensor

        stationName.text = sensor.stationName
        sensorParamCode.text = sensor.param.paramCode
        sensorParamName.text = sensor.param.paramName

        rowView.setOnClickListener {

            // Toast.makeText(context, "Another activity ", Toast.LENGTH_LONG).show()
            changeActivity(context, sensor.id)
        }

        return rowView
    }

    override fun getCount(): Int {
        return dataSource.size
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    companion object {
        fun changeActivity(context: Context, sensorid: String) {

            val intent = Intent(context, SensorDataActivity::class.java)
            intent.putExtra("sensorid", sensorid)
            context.startActivity(intent)

        }
    }


}