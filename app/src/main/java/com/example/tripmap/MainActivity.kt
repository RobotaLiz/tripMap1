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

        PersonTextView = findViewById(R.id.PersonNameTextview)
        passWordView = findViewById(R.id.PasswordTextview )

        var loginButton = findViewById<Button>(R.id.LogInbutton)
        var guestButton = findViewById<Button>(R.id.Guestbutton)
        var regButton = findViewById<Button>(R.id.Registerbutton)

        loginButton.setOnClickListener {
            logIn()
        }
        guestButton.setOnClickListener {
            goToMenu()
        }
        regButton.setOnClickListener {
            signUp()
        }

    }
    fun goToMenu(){
        val intent = Intent(this, MenyActivity::class.java)
        startActivity(intent)


    }
   fun signUp(){
        val email = PersonTextView.text.toString()
        val passWord = passWordView.text.toString()

       if(email.isEmpty() || passWord.isEmpty()) {
           return
       }

       auth.createUserWithEmailAndPassword(email, passWord)
           .addOnCompleteListener { task ->
               if(task.isSuccessful){
                   Log.d("###", "create success")
               }else{
                   Log.d("###", "user not created ${task.exception}")
               }


           }

   }
    fun logIn(){
        val email = PersonTextView.text.toString()
        val passWord = passWordView.text.toString()

        if(email.isEmpty() || passWord.isEmpty()){
            return
        }
        auth.signInWithEmailAndPassword(email, passWord)
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    Log.d("###", "user is Logged In ")
                    goToMenu()
                }else{
                    Log.d("###", "faild Logged in ${task.exception}")

                }

            }
    }
}














