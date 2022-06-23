package com.example.tryinggps;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;


public class Record extends AppCompatActivity {
    private LocationManager locationManager;
    public boolean mRecording = false;
    public Data mData;
    public MapsActivity mMapsActivity;
    public boolean isSelected = false;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Record() {
        mData = new Data();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        mMapsActivity = new MapsActivity();

        try {
            record();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Button mapButton = this.findViewById(R.id.mapButton);
        mapButton.setOnClickListener(v -> {
            Intent intent = new Intent(Record.this, mMapsActivity.getClass());
            startActivity(intent);
        });

        Button stop = findViewById(R.id.stopButton);
        stop.setOnClickListener(v -> {
            System.out.println("stop record from " + mData.mName);

            for (Double lat : mData.mLatitudes) {
                System.out.println("on stop record button click latitude: " + lat);
            }

            mRecording = false;
            finish();
        });
    }



    @RequiresApi(api = Build.VERSION_CODES.O)
    public void record() throws IOException {
        Record record = new Record();
        mData = new Data();
        long[] fullTime = new long[1];
        long StartTime = System.currentTimeMillis();
        boolean[] shouldRun = new boolean[1];
        shouldRun[0] = true;
        mRecording = true;
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if(ContextCompat.checkSelfPermission(Record.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(Record.this, Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(Record.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},1);
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10, 0, new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {

                if(!mRecording ) {
                    if(!shouldRun[0]){

                    }

                    else{
                        System.out.println("Stop");
                        SharedPreferences sharedPreferences;
                        record.mData = mData;
                        fullTime[0] = System.currentTimeMillis() -  StartTime;
                        sharedPreferences = getSharedPreferences("al", MODE_PRIVATE);
                        StringBuilder allRecords =  new StringBuilder(sharedPreferences.getString("al", ""));
                        if(record.mData.mLatitudes.size() > 2){
                            SharedPreferences.Editor myEdit = sharedPreferences.edit();
                            for (int x = 0; x < record.mData.mLatitudes.size(); x++) {
                                allRecords.append(record.mData.mLongitudes.get(x)).append(",").append(record.mData.mLatitudes.get(x)).append(",").append(record.mData.mName).append(",").append(record.mData.mSpeed.get(x)).append(",").append(fullTime[0] / 1000).append(";");
                            }
                            allRecords.append("#");
                            System.out.println("HEY WAS FÜRN SPASS " + allRecords);
                            myEdit.putString("al", allRecords.toString());
                            myEdit.apply();
                        }
                        shouldRun[0] = false;
                    }
                }
                else {
                    System.out.println(location.getLatitude());
                    System.out.println(location.getLongitude());
                    mData.updateData(location.getLongitude(),location.getLatitude(), location.getSpeed());
                    updateTextViews(StartTime);
                    mMapsActivity.updateLocations(location);
                }
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras){
                LocationListener.super.onStatusChanged(provider, status, extras);
            }

            @Override
            public void onProviderEnabled(@NonNull String provider) {
                LocationListener.super.onProviderEnabled(provider);
            }

            @Override
            public void onProviderDisabled(@NonNull String provider) {
                LocationListener.super.onProviderDisabled(provider);
            }
        });
    }

    private void updateTextViews(long startTime) {
        TextView latTV = this.findViewById(R.id.latTV);
        TextView lonTV = this.findViewById(R.id.lonTV);
        TextView speedTV = this.findViewById(R.id.speedTextView);
        TextView time = this.findViewById(R.id.textView5);
        String lat = "Current Latitude: ";
        lat +=  String.valueOf(mData.mLatitudes.get(mData.mLatitudes.size()-1));
        String lon = "Current Longitude: ";
        lon += String.valueOf(mData.mLongitudes.get(mData.mLongitudes.size()-1));
        String speed = "Speed: ";
        speed +=   String.valueOf(mData.mSpeed.get(mData.mSpeed.size()-1));
        String timeString = "Time: ";
        timeString += String.valueOf((System.currentTimeMillis() - startTime) /1000);
        latTV.setText(lat);
        lonTV.setText(lon);
        speedTV.setText(speed);
        time.setText(timeString);
    }
}