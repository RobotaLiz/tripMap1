package com.example.tripmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class AddPlace : AppCompatActivity() {

    lateinit var addName: TextView
    lateinit var info : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_place)

        info = findViewById(R.id.InfoAddTextView)

        addName = findViewById(R.id.AddNameTextView)
        var addButton = findViewById<Button>(R.id.AddPlacebutton)
        addButton.setOnClickListener {
            val place = PlaceOfInterrest(
                name = addName.text.toString(),
                info = info.text.toString(),
                long = 25.8,
                lat = 45.0
            )
            DataManager.addPlace(place)
            Toast.makeText(this, "you added a new place", Toast.LENGTH_LONG).show()
        }
        var backAddButton = findViewById<FloatingActionButton>(R.id.AddBackButton)
        backAddButton.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        }
    }
