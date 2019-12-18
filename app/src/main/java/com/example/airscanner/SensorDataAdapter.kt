package com.example.airscanner

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class SensorDataAdapter(private val context: Context, private val dataSource: SensorData): BaseAdapter() {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rowView = inflater.inflate(R.layout.layout_sensor_data, parent, false)

        val sensorkey = rowView.findViewById(R.id.idsensordata_layout) as TextView
        val sensordate = rowView.findViewById(R.id.sensordate_layout) as TextView
        val sensorvalue = rowView.findViewById(R.id.sensorvalue_layout) as TextView

        // val sensor = getItem(position) as Sensor
        // stationName.text = sensor.stationName

        val sensordata = getItem(position) as SensorData
        sensorkey.text = sensordata.key
        sensordate.text = sensordata.values[position].date
        sensorvalue.text = sensordata.values[position].value

        return rowView
    }

    override fun getCount(): Int {
        return dataSource.values.size
    }

    override fun getItem(position: Int): Any {
        return dataSource
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

}