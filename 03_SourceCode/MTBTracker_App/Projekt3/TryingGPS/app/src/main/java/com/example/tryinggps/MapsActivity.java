package com.example.tryinggps;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.internal.maps.zzad;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.tryinggps.databinding.ActivityMapsBinding;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private GoogleMap mMap;
    private ActivityMapsBinding binding;
    private ArrayList<Location> mLocations = new ArrayList<>();
    private double lat = 0;
    private double lon = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    public void drawAllLines(Data data) {
        if (mMap != null) {
            LatLng myPos = new LatLng(data.mLatitudes.get(0), data.mLongitudes.get(0));
            mMap.addMarker(new MarkerOptions().position(myPos).title("You are here"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(myPos));

            //draw
        }
    }

    public void updateLocations(Location l) {
        mLocations.add(l);
        displayLinesLive();
    }

    private void displayLinesLive() {
        if (mMap != null) {
            if (mLocations.size() >= 1) {
                lat = mLocations.get(mLocations.size() - 1).getLatitude();
                lon = mLocations.get(mLocations.size() - 1).getLongitude();
            }

            if (mLocations.size() >= 2) {
                double la1 = mLocations.get(mLocations.size() - 1).getLatitude();
                double lo1 = mLocations.get(mLocations.size() - 1).getLongitude();
                double la2 = mLocations.get(mLocations.size() - 2).getLatitude();
                double lo2 = mLocations.get(mLocations.size() - 2).getLongitude();

                LatLng pos1 = new LatLng(la1, lo1);
                LatLng pos2 = new LatLng(la2, lo2);

                mMap.addPolyline(new PolylineOptions().add(pos1, pos2));
            }

            LatLng myPos = new LatLng(48.26852, 14.25228);
            mMap.addMarker(new MarkerOptions().position(myPos).title("You are here"));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(myPos));
        }
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
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap = googleMap;
        displayLinesLive();
    }
}