package com.example.airscanner

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast

class StationAdapter(private val context: Context, private val dataSource: List<Station>): BaseAdapter()
{
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        val rowView = inflater.inflate(R.layout.layout_station, parent, false)

        val idStationView = rowView.findViewById(R.id.idstation_layout) as TextView
        val nameStationView = rowView.findViewById(R.id.stationname_layout) as TextView

        val station = getItem(position) as Station

        idStationView.text = station.id.toString()
        nameStationView.text = station.stationName

        rowView.setOnClickListener {

           // Toast.makeText(context, "Another activity ", Toast.LENGTH_LONG).show()
            changeActivity(context, station.id.toString(), station.stationName.toString())
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
        fun changeActivity(context: Context, stationid: String, stationname: String) {

            val intent = Intent(context, SensorActivity::class.java)
            intent.putExtra("stationID", stationid)
            intent.putExtra("stationNAME", stationname)
            context.startActivity(intent)

        }
    }


}