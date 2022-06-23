package com.example.tryinggps;

import android.location.Location;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Data {
    public String mName;
    public ArrayList<Double> mLatitudes;
    public ArrayList<Double> mLongitudes;
    public ArrayList<Float> mSpeed;
    boolean isFinished;
    long mTime;

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Data(){
        mTime = 0;
        isFinished = false;
        LocalDateTime localDateTime = LocalDateTime.now();
        mName = "RecordNumber:"+ localDateTime;
        mLongitudes = new ArrayList<>();
        mLatitudes = new ArrayList<>();
        mSpeed = new ArrayList<>();
    }

    public void updateData(Double lat, Double lon, Float speed) {
        mLatitudes.add(lat);
        mLongitudes.add(lon);
        mSpeed.add(speed);
    }

}
