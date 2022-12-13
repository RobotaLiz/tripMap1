package com.example.tripmap

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

object DataManager {


    fun addPlace(place : PlaceOfInterrest) {
        var db =  Firebase.firestore
        var collection = db.collection("Places")
          collection.add(place)

    }
    fun getPlaces() : List<PlaceOfInterrest>{
        val listGetPlaces = mutableListOf<PlaceOfInterrest>()
        var db =  Firebase.firestore
        var collection = db.collection("Places")

        collection.get().addOnSuccessListener { documentSnapShot ->
            for (document in documentSnapShot.documents){
                val items = document.toObject<PlaceOfInterrest>()
                if(items != null)
                    listGetPlaces.add(items)
            }
        }
        return listGetPlaces
    }


}
