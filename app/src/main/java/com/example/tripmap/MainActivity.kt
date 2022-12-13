package com.example.tripmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var loginButton = findViewById<Button>(R.id.LogInbutton)
        var guestButton = findViewById<Button>(R.id.Guestbutton)
        var regButton = findViewById<Button>(R.id.Registerbutton)

        loginButton.setOnClickListener {
            goToMenu()
        }
        guestButton.setOnClickListener {
            goToMenu()
        }
        regButton.setOnClickListener {
            goToMenu()
        }



    }
    fun goToMenu(){
        val intent = Intent(this, MenyActivity::class.java)
        startActivity(intent)


    }
}