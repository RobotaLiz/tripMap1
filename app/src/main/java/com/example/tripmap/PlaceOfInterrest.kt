package com.example.tripmap

import com.google.firebase.firestore.DocumentId

class PlaceOfInterrest(@DocumentId var documentid : String?  = null, var name : String = "", var length : Double = 0.0, var long : Double = 0.0, var lat : Double = 0.0) {


}