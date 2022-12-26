package com.example.tripmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import org.w3c.dom.Text

class signin : AppCompatActivity() {

    lateinit var PersonTextView: TextView
    lateinit var passWordView: TextView
    lateinit var auth : FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        PersonTextView = findViewById(R.id.EmailsignInTextview)
        passWordView = findViewById(R.id.PasswordsignInTextview)

       auth =  Firebase.auth
        val SignInButton = findViewById<Button>(R.id.signInbutton)
        SignInButton.setOnClickListener {
            signIn()
        }
        val backButton = findViewById<Button>(R.id.signInBackbutton)
            backButton.setOnClickListener {
                var intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
    }

    fun signIn(){
        val email = PersonTextView.text.toString()
        val passWord = passWordView.text.toString()

        if(email.isEmpty() || passWord.isEmpty()){
            return
        }
        auth.signInWithEmailAndPassword(email, passWord)
            .addOnCompleteListener { task ->
                if(task.isSuccessful){
                    Log.d("###", "user is Logged In ")
                    Toast.makeText(this, "Logged in!", Toast.LENGTH_LONG).show()
                    var intent = Intent(this, MenyActivity::class.java)
                    startActivity(intent)
                }else{
                    Log.d("###", "faild Logged in ${task.exception}")
                    Toast.makeText(this, "Failed! wrong password or email", Toast.LENGTH_LONG).show()

                }

            }

    }
}