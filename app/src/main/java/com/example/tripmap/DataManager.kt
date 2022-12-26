package com.example.tripmap


import android.app.Activity
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.annotation.GlideModule
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
