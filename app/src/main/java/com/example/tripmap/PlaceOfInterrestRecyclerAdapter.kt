package com.example.tripmap

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class PlaceOfInterrestRecyclerAdapter(val context : Context, val list: List<PlaceOfInterrest>) :
        RecyclerView.Adapter<PlaceOfInterrestRecyclerAdapter.viewHolder>(){

        val inflater = LayoutInflater.from(context)

    // denna metod skapar en item i listan.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val itemView = inflater.inflate(R.layout.list_item,parent, false)
        return viewHolder(itemView)
    }

    // den ger en item/en plats i listan i recyklervyn med all information.
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val place = list[position]
        holder.PlaceTextView.text = place.name
        DataManager.getPicture(holder.picture, context, place.pictureName)
        holder.lat = place.lat
        holder.long = place.long
        holder.onCreate()

    }

    // denna metod ger recyklerns längd av listan
    override fun getItemCount() = list.size



    // den här bestämmer över en item i listan med information.
    inner class viewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val picture = itemView.findViewById<ImageView>(R.id.recyklerImageView)
        val PlaceTextView = itemView.findViewById<TextView>(R.id.placeTextview)
        val mapButton = itemView.findViewById<ImageButton>(R.id.goToMapButton)
        var lat = 0.0
        var long = 0.0


        // den skapar våran clicklyssnare och den anropas från OnBindviewholder
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