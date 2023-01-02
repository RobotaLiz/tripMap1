package com.example.tripmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class SkislopeInfo : AppCompatActivity() {

    lateinit var imageview : ImageView
    lateinit var textView: TextView
    lateinit var nametext: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skislope_info)

        textView = findViewById(R.id.textView4)
        nametext = findViewById(R.id.InfoSloaptextView)
        imageview = findViewById(R.id.imageView3)

        val picture =  intent.getStringExtra("PICTURENAME")
        DataManager.getPicture(imageview, this, picture.orEmpty())

        val name = intent.getStringExtra("NAME")
        textView.setText(name)

        val info = intent.getStringExtra("INFO")
        nametext.setText(info)


        var sloapBackButton = findViewById<Button>(R.id.SlopeBackbutton)
        sloapBackButton.setOnClickListener {
            var intent = Intent(this, SearchMenu::class.java)
            startActivity(intent)
        }

    }
}