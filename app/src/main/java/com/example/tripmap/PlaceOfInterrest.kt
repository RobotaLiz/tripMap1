package com.example.tripmap

import com.google.firebase.firestore.DocumentId

// placeofintress är en class för att hålla info om en plast.
class PlaceOfInterrest(@DocumentId var documentid : String?  = null,
                       var name : String = "",
                       var pictureName : String = "",
                       var info : String = "",
                       var long : Double = 0.0,
                       var lat : Double = 0.0) {


}