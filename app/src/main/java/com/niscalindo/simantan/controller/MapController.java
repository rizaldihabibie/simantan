package com.niscalindo.simantan.controller;

import android.content.ContentValues;
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
import com.niscalindo.simantan.database.dao.MapDao;
import com.niscalindo.simantan.database.dao.dao.impl.MapDaoImpl;
import com.niscalindo.simantan.database.helper.DatabaseHelper;

/**
 * Created by USER on 2/4/2018.
 */
public class MapController extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap gMap;
    Context cob = this;
    @Override        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map_activity);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

    }
    @Override    public void onMapReady(GoogleMap googleMap)
    {
        gMap = googleMap;
        LatLng jaipur = new LatLng(26.923952,75.826743);
        CameraPosition cameraPosition = CameraPosition.builder()
                .zoom(17).tilt(20).bearing(90).target(jaipur).build();
        gMap.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        gMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override            public void onMapClick(LatLng point) {

                drawMarker(point);   // Draw marker

                ContentValues contentValues = new ContentValues();
                // get  & set with contentvalues

                contentValues.put(DatabaseHelper.FIELD_LAT, point.latitude);
                contentValues.put(DatabaseHelper.FIELD_LNG, point.longitude);
                contentValues.put(DatabaseHelper.FIELD_ZOOM, gMap.getCameraPosition().zoom);
                MapDao lb = new MapDaoImpl();
                // Storing the latitude, longitude and zoom level to SQLite database

                long row = lb.insert(contentValues,cob);
                if(row>0)
                    Toast.makeText(cob, "Your Location Inserted Successfully...." ,
                            Toast.LENGTH_SHORT).show();
                else

                    Toast.makeText(cob, "Something Wrong...", Toast.LENGTH_SHORT).show();

            }
        });
    }
    private void drawMarker(LatLng point){
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(point);
        gMap.addMarker(markerOptions);
    }
}
