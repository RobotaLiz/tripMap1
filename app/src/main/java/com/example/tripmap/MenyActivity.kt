package com.example.tripmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MenyActivity : AppCompatActivity() {


    lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meny)

        auth = Firebase.auth


         var mapbutton = findViewById<Button>(R.id.Mapbutton)
             mapbutton.setOnClickListener {
                val intent = Intent(this, MapsActivity::class.java)
                startActivity(intent)
            }
        var addPlace = findViewById<Button>(R.id.Addbutton)
        addPlace.setOnClickListener {
            if (auth.currentUser == null){
                Toast.makeText(this, "you are not logged in", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this,AddPlace::class.java )
                startActivity(intent)
            }

        }
        var listSeachButton = findViewById<Button>(R.id.Searchbutton)
        listSeachButton.setOnClickListener {
            val intent = Intent(this,SearchMenu::class.java )
            startActivity(intent)
        }
        var menyBackButton = findViewById<Button>(R.id.backMenyButton)
        menyBackButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        }



    }
