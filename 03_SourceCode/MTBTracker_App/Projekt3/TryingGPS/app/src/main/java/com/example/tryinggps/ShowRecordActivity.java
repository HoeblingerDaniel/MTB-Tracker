package com.example.tryinggps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.LocaleList;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowRecordActivity extends AppCompatActivity {
    private static Record mRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_record);

        Button backButton = this.findViewById(R.id.showRecordBackButton);
        backButton.setOnClickListener(v -> finish());

        System.out.println("Should give Locations");
        for (Double lat : mRecord.mData.mLatitudes) {
            System.out.println("Latitude: " + lat);
        }

        Button showMapButton = this.findViewById(R.id.showMapButton);
        showMapButton.setOnClickListener(v -> {
            MapsActivity mapsActivity = new MapsActivity();
            mapsActivity.drawAllLines(mRecord.mData);
            Intent intent = new Intent(ShowRecordActivity.this, mapsActivity.getClass());
            startActivity(intent);
        });

        displayRecord();
    }

    public static void initRecord(Record r) {
        mRecord = r;
    }

    @SuppressLint("SetTextI18n")
    private void displayRecord() {
        TextView nameTV = this.findViewById(R.id.nameTV);
        TextView speedTV = this.findViewById(R.id.speedTV);
        TextView time = this.findViewById(R.id.textView4);
        TextView distanceTV = this.findViewById(R.id.distanceTV);

        if (mRecord != null) {
            if (mRecord.mData.mName == null) {
                nameTV.setText("Name is null!");
            }
            else {
                nameTV.setText(mRecord.mData.mName);
            }
            System.out.println("displays name");

            double avgSpeed = 0; //why does it say that its null
            for (int i = 0; i < mRecord.mData.mSpeed.size(); i++) {
                avgSpeed += mRecord.mData.mSpeed.get(i).doubleValue();
            }
            avgSpeed /= mRecord.mData.mSpeed.size();
            speedTV.setText("Your average speed: " + avgSpeed);
            TextView headline = new TextView(getBaseContext());
            headline.setText("This is the Record :" + mRecord.mData.mName);

            distanceTV.setText("Distance " + mRecord.mData.mTime * avgSpeed + " m");

            if(mRecord.mData.mTime < 60){
                time.setText("The time u took: " + mRecord.mData.mTime +" seconds");
            }
            else {
                double minutes = mRecord.mData.mTime / 60;
                double seconds = mRecord.mData.mTime %60 * 60;
                time.setText("The time you took: " + minutes + " minutes and " + seconds+ " seconds." );
            }
        }
    }
}