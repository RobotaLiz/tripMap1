package com.example.tripmap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.tripmap.databinding.ActivityMapsBinding
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        val backMapButton = findViewById<FloatingActionButton>(R.id.backMapButton)
        backMapButton.setOnClickListener {
           val intent = Intent(this, SearchMenu ::class.java )
            startActivity(intent)
        }
    }
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        var db =  Firebase.firestore
        var collection = db.collection("Places")
        var list = mutableListOf<PlaceOfInterrest>()

        collection.get().addOnSuccessListener { documentSnapShot ->
            for (document in documentSnapShot.documents){

                val items = document.toObject<PlaceOfInterrest>()
                if(items != null)
                    list.add(items)
            }
            for (place in list){
                val latlong = LatLng(place.lat,place.long)
                mMap.addMarker(MarkerOptions().position(latlong).title(place.name))

            }
        }



        val lat = 61.173826
        val long = 12.991915

        val salen = LatLng(lat,long )
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(salen, 6f))
        mMap.addMarker(MarkerOptions().position(salen).title("Marker in salen"))






    }
}