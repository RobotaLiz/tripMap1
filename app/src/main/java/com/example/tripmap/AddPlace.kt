package com.example.tripmap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class AddPlace : AppCompatActivity() {

    lateinit var addName : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_place)

        addName = findViewById(R.id.AddNameTextView)
        var addButton = findViewById<Button>(R.id.AddPlacebutton)
        addButton.setOnClickListener {
           val place =  PlaceOfInterrest(name = addName.text.toString(), length =  4.0, long =  25.8, lat =  45.0)
            DataManager.addPlace(place)
        }

    }
}