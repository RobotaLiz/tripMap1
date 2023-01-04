package com.example.tripmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.savedstate.findViewTreeSavedStateRegistryOwner
import com.google.android.material.floatingactionbutton.FloatingActionButton

class SearchMenu : AppCompatActivity() {

    lateinit var RecyclerView: RecyclerView
    lateinit var adapter: PlaceOfInterrestRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_menu)
        adapter = PlaceOfInterrestRecyclerAdapter(this, arrayListOf())
        DataManager.getPlaces(adapter)

        RecyclerView = findViewById(R.id.RecyclerView)
        RecyclerView.layoutManager = LinearLayoutManager(this,)
        RecyclerView.adapter = adapter

        val backSearchButton = findViewById<FloatingActionButton>(R.id.ListOfPlacesBackButton)
        backSearchButton.setOnClickListener {
            val intent = Intent(this, MenyActivity::class.java)
            startActivity(intent)
        }
    }
}
