package com.example.tripmap

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class PlaceOfInterrestRecyclerAdapter(val context : Context, val list: List<PlaceOfInterrest>) :
        RecyclerView.Adapter<PlaceOfInterrestRecyclerAdapter.viewHolder>(){

        val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView = inflater.inflate(R.layout.list_item,parent, false)
        return viewHolder(itemView)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val place = list[position]
        holder.PlaceTextView.text = place.name
        holder.lat = place.lat
        holder.long = place.long
        holder.onCreate()

    }

    override fun getItemCount() = list.size




    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val PlaceTextView = itemView.findViewById<TextView>(R.id.placeTextview)
        val TripLenght = itemView.findViewById<TextView>(R.id.tripLengthTextView)
        val mapButton = itemView.findViewById<ImageButton>(R.id.goToMapButton)
        var lat = 0.0
        var long = 0.0


        fun onCreate() {
            mapButton.setOnClickListener {
                val intent = Intent(context, MapsActivity::class.java)
                intent.putExtra("LAT", lat)
                intent.putExtra("LONG", long)
                context.startActivity(intent)

            }
    }

    }

}