package com.example.suwan.godrivefinalproject;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;

public class WhereActivity extends AppCompatActivity implements
        ConnectionCallbacks, OnConnectionFailedListener, OnMapReadyCallback, GoogleMap.OnMarkerClickListener{

    GoogleApiClient mGoogleApiClient;
    Location mLastLocation;
    TextView mLatitudeText;
    TextView mLongtitudeText;
    GoogleMap map;

    private Marker myLocationMarker;
    private Marker nearLocationMarker;

    public static final int MY_PERMISSIONS_REQUEST =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_where);
        mLatitudeText = (TextView)
                findViewById(R.id.LatitudeText);
        mLongtitudeText = (TextView)
                findViewById(R.id.LongtitudeText);

        // Create an instance of GoogleAPIClient.
        if (mGoogleApiClient == null) {
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .addApi(LocationServices.API)
                    .build();
        }

        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Check for the external storage permission
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // If you do not have permission, request it
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                    MY_PERMISSIONS_REQUEST);
        } else {
            // Launch the camera if the permission exists
           // launchLocation();
        }
    }

    protected void onStart() {
        mGoogleApiClient.connect();
        super.onStart();
    }

    protected void onStop() {
        mGoogleApiClient.disconnect();
        super.onStop();
    }

    public void launchLocation() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mLastLocation = LocationServices.FusedLocationApi.getLastLocation(mGoogleApiClient);
            if(mGoogleApiClient == null) {
                Toast.makeText(this, "null", Toast.LENGTH_SHORT).show();
            }

            if (mLastLocation != null) {
                mLatitudeText.setText(String. valueOf(mLastLocation.getLatitude()));
                mLongtitudeText.setText(String.valueOf(mLastLocation.getLongitude()));
                LatLng myLatLng = new LatLng(
                        mLastLocation.getLatitude(),
                        mLastLocation.getLongitude()
                );

                map.moveCamera(
                        CameraUpdateFactory.newLatLng(myLatLng)
                );

                myLocationMarker = map.addMarker(new MarkerOptions()
                        .position(myLatLng)
                        .title("My Location"));
                myLocationMarker.setTag("mylocation");

                nearLocationMarker = map.addMarker(new MarkerOptions()
                        .position(new LatLng(13.7300718,100.5791508))
                        .title("Nearby Location"));
                nearLocationMarker.setTag("nearlocation");
                //Intent intent = new Intent(this,DestinationActivity.class);
                //startActivity(intent);
                map.setOnMarkerClickListener(this);

            } else {
                mLatitudeText.setText("Latitude");
                mLongtitudeText.setText("Longtitude");
            }

        }

    }

    @Override
    public void onConnected(Bundle connectionHint) {
        launchLocation();
    }

    @Override
            public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                switch (requestCode) {
                    case MY_PERMISSIONS_REQUEST: {
                        if (grantResults.length > 0
                                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                            launchLocation();
                        } else {
                            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
                        }
                        break;
                    }
                }
            }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.map = googleMap;
        launchLocation();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
        //getMenuInflater().inflate(R.menu.main, menu);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.bar_setting) {
            return true;
        }
        if (id == R.id.bar_logout) {
            //logout();
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(WhereActivity.this, LoginActivity.class);
            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        Log.e("----", "hey");
        if(marker.getTag().equals("mylocation")) {
            Intent intent = new Intent(this,DestinationActivity.class);
            startActivity(intent);
        } else {
            if (marker.getTag().equals("nearlocation")) {
                Intent intent = new Intent(this, DestinationActivity.class);
                startActivity(intent);
            }
        }
        return false;
    }
}

