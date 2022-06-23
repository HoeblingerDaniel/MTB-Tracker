package com.example.tryinggps;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class CompareActivity extends AppCompatActivity {

    private static Record[] records = new Record[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compare);

        Button backButton = this.findViewById(R.id.backButtonC);
        backButton.setOnClickListener(v -> finish());

        Button mapButton1 = this.findViewById(R.id.compareMapButton1);
        mapButton1.setOnClickListener(v -> {
            MapsActivity mapsActivity = new MapsActivity();
            mapsActivity.drawAllLines(records[0].mData);
            Intent intent = new Intent(CompareActivity.this, mapsActivity.getClass());
            startActivity(intent);
        });
        Button mapButton2 = this.findViewById(R.id.compareMapButton2);
        mapButton2.setOnClickListener(v -> {
            MapsActivity mapsActivity = new MapsActivity();
            mapsActivity.drawAllLines(records[1].mData);
            Intent intent = new Intent(CompareActivity.this, mapsActivity.getClass());
            startActivity(intent);
        });

        displayRecords();
    }

    public static void initCompare(Record r1, Record r2) {
        records[0] = r1;
        records[1] = r2;
    }

    @SuppressLint("SetTextI18n")
    private void displayRecords() {
        TextView tv1 = this.findViewById(R.id.compareTV1);
        TextView tv2 = this.findViewById(R.id.compareTV2);
        TextView time1 = this.findViewById(R.id.compareTimeTV1);
        TextView time2 = this.findViewById(R.id.compareTimeTV2);
        TextView speed1 = this.findViewById(R.id.compareSpeedTV1);
        TextView speed2 = this.findViewById(R.id.compareSpeedTV2);

        tv1.setText(records[0].mData.mName);
        tv2.setText(records[1].mData.mName);

        if(records[0].mData.mTime < 60){
            time1.setText("The time u took: " + records[0].mData.mTime +" seconds");
        }
        else {
            double minutes = records[0].mData.mTime / 60;
            double seconds = records[0].mData.mTime %60 * 60;
            time1.setText("The time you took: " + minutes + " minutes and " + seconds+ " seconds." );
        }

        if(records[1].mData.mTime < 60){
            time2.setText("The time u took: " + records[1].mData.mTime +" seconds");
        }
        else {
            double minutes = records[1].mData.mTime / 60;
            double seconds = records[1].mData.mTime %60 * 60;
            time2.setText("The time you took: " + minutes + " minutes and " + seconds+ " seconds." );
        }

        float avgSpeed1 = 0;
        for (int i = 0; i < records[0].mData.mSpeed.size(); i++) {
            avgSpeed1 += records[0].mData.mSpeed.get(i);
        }
        avgSpeed1 /= records[0].mData.mSpeed.size();
        speed1.setText(String.valueOf(avgSpeed1));

        float avgSpeed2 = 0;
        for (int i = 0; i < records[1].mData.mSpeed.size(); i++) {
            avgSpeed2 += records[1].mData.mSpeed.get(i);
        }
        avgSpeed2 /= records[1].mData.mSpeed.size();
        speed2.setText(String.valueOf(avgSpeed2));
    }
}