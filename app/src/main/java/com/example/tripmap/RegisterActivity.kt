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

class RegisterActivity : AppCompatActivity() {


    lateinit var auth : FirebaseAuth
    lateinit var nameTextView : EditText
    lateinit var emailTextView : EditText
    lateinit var passWordTextView : EditText


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        auth = Firebase.auth
        emailTextView = findViewById(R.id.RegisterEmailTextView)
        passWordTextView = findViewById(R.id.RegisterPasswordTextView)
        nameTextView = findViewById(R.id.RegisterNameTextview)

        var signUpButton = findViewById<Button>(R.id.RegisterSignUpbutton)
        signUpButton.setOnClickListener {
            signUp()
        }
    }
    fun goToMenu(){
        val intent = Intent(this, MenyActivity::class.java)
        startActivity(intent)
    }
    fun signUp(){
        val email = emailTextView.text.toString()
        val passWord = passWordTextView.text.toString()


        if(email.isEmpty() || passWord.isEmpty()) {
            return
        }

        auth.createUserWithEmailAndPassword(email, passWord)
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    goToMenu()
                    Log.d("###", "create success")
                }else{
                    Log.d("###", "user not created ${task.exception}")
                }


            }

    }
}