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

    lateinit var RecyclerView: RecyclerView
    lateinit var adapter: PlaceOfInterrestRecyclerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_menu)
        adapter = PlaceOfInterrestRecyclerAdapter(this, DataManager.getPlaces())

        RecyclerView = findViewById(R.id.RecyclerView)
        RecyclerView.layoutManager = LinearLayoutManager(this,)
        RecyclerView.adapter = adapter
        val listSeachButton = findViewById<Button>(R.id.ListSearchbutton)
        listSeachButton.setOnClickListener {
            adapter.notifyDataSetChanged()
        }
        val backSearchButton = findViewById<Button>(R.id.backButtonInSearch)
        backSearchButton.setOnClickListener {
            val intent = Intent(this, MenyActivity::class.java)
            startActivity(intent)
        }

    }

}
