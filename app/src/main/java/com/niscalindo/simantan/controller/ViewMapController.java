package com.niscalindo.simantan.controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.niscalindo.simantan.R;
import com.niscalindo.simantan.database.model.Gardu;

/**
 * Created by USER on 2/4/2018.
 */
public class ViewMapController extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    Context cob = this;
    private Gardu gardu;
    @Override        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        gardu = (Gardu)getIntent().getSerializableExtra("GARDU_DATA_SESSION");
        Toast.makeText(cob, gardu.getNomorGardu() ,
                Toast.LENGTH_SHORT).show();
    }
    @Override    public void onMapReady(GoogleMap googleMap)
    {
        gMap = googleMap;
        LatLng jaipur = new LatLng(gardu.getLatitude(),gardu.getLongitude());
        CameraPosition cameraPosition = CameraPosition.builder()
                .zoom(17).tilt(20).bearing(90).target(jaipur).build();
        gMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        drawMarker(new LatLng(gardu.getLatitude(),gardu.getLongitude()));

    }
    private void drawMarker(LatLng point){
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(point);
        gMap.addMarker(markerOptions);
    }
}
