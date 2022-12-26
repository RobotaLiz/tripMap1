package com.example.tripmap
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth


import com.google.firebase.auth.ktx.auth

import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var auth : FirebaseAuth
    lateinit var PersonTextView : EditText
    lateinit var passWordView : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth
        auth.signOut()

       // PersonTextView = findViewById(R.id.PersonNameTextview)
        //passWordView = findViewById(R.id.PasswordTextview )

        var loginButton = findViewById<Button>(R.id.LogInbutton)
        var guestButton = findViewById<Button>(R.id.Guestbutton)
        var regButton = findViewById<Button>(R.id.Registerbutton)


        loginButton.setOnClickListener {
            var intent = Intent(this, signin::class.java)
            startActivity(intent)
        }
        guestButton.setOnClickListener {
            goToMenu()
        }
        regButton.setOnClickListener {
            goToRegister()
        }


    }
    fun goToRegister(){
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }



    fun goToMenu(){
        val intent = Intent(this, MenyActivity::class.java)
        startActivity(intent)


    }

}














