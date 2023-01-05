package com.example.tripmap


import android.app.Activity
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import io.grpc.Context

object DataManager {

    fun addPlace(place : PlaceOfInterrest) {
        var db = Firebase.firestore
        var collection = db.collection("Places")
        collection.add(place)

    }
    fun deletePlace(id : String?, position : Int, name:String,placeOfInterrestRecyclerAdapter: PlaceOfInterrestRecyclerAdapter) {
        var auth = Firebase.auth
        if (auth.currentUser == null) {
            Toast.makeText(
                placeOfInterrestRecyclerAdapter.context,
                "you need to be logged in",
                Toast.LENGTH_LONG
            ).show()
            return
        }

        placeOfInterrestRecyclerAdapter.list.removeAt(position)

        var db = Firebase.firestore
        var collection = db.collection("Places")
        collection.document(id.toString()).delete().addOnSuccessListener {
            Log.d("!!!", "Document deleted")
            placeOfInterrestRecyclerAdapter.notifyDataSetChanged()
            val storageRef = Firebase.storage.reference

            if(name != ""){
                val image = storageRef.child(name)
                image.delete().addOnSuccessListener {

                }.addOnFailureListener {



                }
            }





        }
    }
    fun getPlaces(placeOfInterrestRecyclerAdapter: PlaceOfInterrestRecyclerAdapter){
        var db =  Firebase.firestore
        var collection = db.collection("Places")

        collection.get().addOnSuccessListener { documentSnapShot ->
            for (document in documentSnapShot.documents){
                val items = document.toObject<PlaceOfInterrest>()
                if(items != null)
                    placeOfInterrestRecyclerAdapter.list.add(items)
            }
            placeOfInterrestRecyclerAdapter.notifyDataSetChanged()
        }
    }

    fun getPicture (imageView : ImageView, context : android.content.Context, pictureName : String){
        if(pictureName === "")
            return
        val storageRef = Firebase.storage.reference
        var spaceRef = storageRef.child(pictureName)


        Glide.with(context)
            .load(spaceRef)
            .into(imageView)

    }
}


