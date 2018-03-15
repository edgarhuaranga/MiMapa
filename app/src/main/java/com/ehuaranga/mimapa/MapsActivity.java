package com.ehuaranga.mimapa;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        LatLng uni = new LatLng(-12.013724,-77.0506784);
        LatLng pucp = new LatLng(-12.065726, -77.081062);

        Marker markerUNI = mMap.addMarker(new MarkerOptions().position(uni).title("Marker in Sydney"));
        Marker markerPUCP = mMap.addMarker(new MarkerOptions().position(pucp).title("Marker in Sydney"));

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String rutaUniPucp = "https://maps.googleapis.com/maps/api/directions/json?origin="+
                uni.latitude+","+uni.longitude+"&destination="+
                pucp.latitude+","+pucp.longitude+"&key=AIzaSyC9o0DddWB5zziv1-kcqqJG-rvDGI3BxVg";


        StringRequest request = new StringRequest(Request.Method.GET, rutaUniPucp, this);
        requestQueue.add(request);
    }
}
