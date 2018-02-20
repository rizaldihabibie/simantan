package com.niscalindo.simantan.controller;

import android.content.Context;
import android.content.Intent;
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

import java.io.Serializable;

/**
 * Created by USER on 2/4/2018.
 */
public class MapController extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    Context cob = this;
    String action = "";
    private Gardu gardu;
    @Override        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        gardu = (Gardu)getIntent().getSerializableExtra("GARDU_SESSION");
        action = (String)getIntent().getStringExtra("SESSION");
        Toast.makeText(cob, gardu.getNomorGardu() ,
                Toast.LENGTH_SHORT).show();
    }
    @Override    public void onMapReady(GoogleMap googleMap)
    {
        gMap = googleMap;
        LatLng jaipur = new LatLng(-6.9861652,110.380033);
        CameraPosition cameraPosition = CameraPosition.builder()
                .zoom(17).tilt(20).bearing(90).target(jaipur).build();
        gMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override            public void onMapClick(LatLng point) {

                drawMarker(point);   // Draw marker
                gardu.setLatitude(point.latitude);
                gardu.setLongitude(point.longitude);
                gardu.setZoom(gMap.getCameraPosition().zoom);
                Intent intent = null;
                if(action.equals("ADD")){
                    intent = new Intent("com.niscalindo.simantan.controller.AddGardu");
                    intent.putExtra("GARDU_AND_MAP", (Serializable)gardu);
                }else{
                    intent = new Intent("com.niscalindo.simantan.controller.EditGardu");
                    intent.putExtra("GARDU_DATA_SESSION", (Serializable)gardu);
                }
                startActivity(intent);

//                ContentValues contentValues = new ContentValues();
                // get  & set with contentvalues

//                contentValues.put(DatabaseHelper.FIELD_LAT, point.latitude);
//                contentValues.put(DatabaseHelper.FIELD_LNG, point.longitude);
//                contentValues.put(DatabaseHelper.FIELD_ZOOM, gMap.getCameraPosition().zoom);
//                MapDao lb = new MapDaoImpl();
                // Storing the latitude, longitude and zoom level to SQLite database

//                long row = lb.insert(contentValues,cob);
//                if(row>0)
//                    Toast.makeText(cob, "Your Location Inserted Successfully...." ,
//                            Toast.LENGTH_SHORT).show();
//                else
//
//                    Toast.makeText(cob, "Something Wrong...", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void drawMarker(LatLng point){
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(point);
        gMap.addMarker(markerOptions);
    }
}
