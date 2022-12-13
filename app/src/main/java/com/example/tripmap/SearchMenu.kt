package com.example.tripmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.savedstate.findViewTreeSavedStateRegistryOwner

class SearchMenu : AppCompatActivity() {

    lateinit var RecyclerView : RecyclerView
    lateinit var adapter : PlaceOfInterrestRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_menu)
        adapter = PlaceOfInterrestRecyclerAdapter(this, DataManager.getPlaces())
       //var placesMap = listOf<PlaceOfInterrest>(PlaceOfInterrest("salen", length = 4.0,
         //  lat =  61.16411469994586, long =  13.264168529476438),

           //PlaceOfInterrest("malung", length = 5.0, long = 56.0, lat = 25.9))

        RecyclerView = findViewById(R.id.RecyclerView)
        RecyclerView.layoutManager = LinearLayoutManager(this,)
        RecyclerView.adapter = adapter
        val listSeachButton = findViewById<Button>(R.id.ListSearchbutton)
        listSeachButton.setOnClickListener {
            adapter.notifyDataSetChanged()
        }
    }

}