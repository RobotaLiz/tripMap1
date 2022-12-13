package com.example.tripmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MenyActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meny)

         var mapbutton = findViewById<Button>(R.id.Mapbutton)
            mapbutton.setOnClickListener {
                val intent = Intent(this, MapsActivity::class.java)
                startActivity(intent)
            }
        var addPlace = findViewById<Button>(R.id.Addbutton)
        addPlace.setOnClickListener {
            val intent = Intent(this,AddPlace::class.java )
            startActivity(intent)
        }
        var listSeachButton = findViewById<Button>(R.id.Searchbutton)
        listSeachButton.setOnClickListener {
            val intent = Intent(this,SearchMenu::class.java )
            startActivity(intent)
        }



    }
}