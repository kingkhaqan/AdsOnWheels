package com.example.zeesh.aowprototype

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.PolylineOptions
import android.R.attr.clickable
import com.google.android.gms.maps.model.Polyline
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.model.MarkerOptions









class DriverLocationActivity : AppCompatActivity() , OnMapReadyCallback{
    override fun onMapReady(gmap: GoogleMap?) {
        val polyline1 = gmap?.addPolyline(PolylineOptions()
                .add(
                        LatLng(-35.016, 143.321),
                        LatLng(-34.747, 145.592),
                        LatLng(-34.364, 147.891),
                        LatLng(-33.501, 150.217),
                        LatLng(-32.306, 149.248),
                        LatLng(-32.491, 147.309)))
        val sydney = LatLng(-33.852, 151.211)
        gmap?.addMarker(MarkerOptions().position(sydney)
                .title("Marker in Sydney"))
        gmap?.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 5f))
        gmap?.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(-23.684, 133.903), 4f))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_driver_location)

//        val mapFragment = supportFragmentManager
//                .findFragmentById(R.id.map) as SupportMapFragment
//          mapFragment.getMapAsync(this)
    }
}
