package com.example.tripmap

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class AddPlace : AppCompatActivity() {

    lateinit var addName: TextView
    lateinit var info : TextView
    var pictureName : String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_place)

        info = findViewById(R.id.textView5)

        addName = findViewById(R.id.AddNameTextView)
        var addButton = findViewById<Button>(R.id.AddPlacebutton)
        addButton.setOnClickListener {
            val place = PlaceOfInterrest(
                name = addName.text.toString(),
                info = info.text.toString(),
                pictureName = pictureName,
                long = 25.8,
                lat = 45.0
            )
            DataManager.addPlace(place)
            Toast.makeText(this, "you added a new place", Toast.LENGTH_LONG).show()
        }
        var btnSelectImage = findViewById<Button>(R.id.setPicturebutton)
        btnSelectImage.setOnClickListener {
            // PICK INTENT picks item from data
            // and returned selected item
            val galleryIntent = Intent(Intent.ACTION_PICK)
            // here item is type of image
            galleryIntent.type = "image/*"
            // ActivityResultLauncher callback
            //startActivity(galleryIntent)
            imagePickerActivityResult.launch(galleryIntent)
        }
        var backAddButton = findViewById<FloatingActionButton>(R.id.AddBackButton)
        backAddButton.setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }


    }
    private var imagePickerActivityResult: ActivityResultLauncher<Intent> =
        registerForActivityResult( ActivityResultContracts.StartActivityForResult()) { result ->
            if (result != null) {
                // getting URI of selected Image
                val imageUri: Uri? = result.data?.data

                // val fileName = imageUri?.pathSegments?.last()

                // extract the file name with extension
                val sd = getFileName(applicationContext, imageUri!!)

                // Upload Task with upload to directory 'file'
                // and name of the file remains same
                val storageRef = Firebase.storage.reference
                val uploadTask = storageRef.child("$sd").putFile(imageUri)

                // On success, download the file URL and display it
                uploadTask.addOnSuccessListener {
                    Log.e("fire","Uploaded")
                    pictureName = "$sd"
                }.addOnFailureListener {
                    Log.e("fire","failed")
                }
            }
        }
    @SuppressLint("Range")
    private fun getFileName(context: android.content.Context, uri: Uri): String? {
        if (uri.scheme == "content") {
            val cursor = context.contentResolver.query(uri, null, null, null, null)
            cursor.use {
                if (cursor != null) {
                    if(cursor.moveToFirst()) {
                        return cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME))
                    }
                }
            }
        }
        return uri.path?.lastIndexOf('/')?.let { uri.path?.substring(it) }
    }
}




