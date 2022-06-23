package com.example.tryinggps;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private static ArrayList<Record> mRecords = new ArrayList<>();
    private boolean compare = false;
    private boolean cRec1 = false;
    private Record[] selectedRecords;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        selectedRecords = new Record[2];

        mRecords = checkForRecordFiles();

        Button startTracking = this.findViewById(R.id.startTrackingButton);
        startTracking.setOnClickListener(v -> {
            mRecords.add(new Record());
            Intent intent = new Intent(MainActivity.this, mRecords.get(mRecords.size()-1).getClass());
            startActivity(intent);
        });

        Button compareButton = this.findViewById(R.id.compareButton);
        compareButton.setOnClickListener(v -> {
            if (selectedRecords[0] != null && selectedRecords[1] != null && compare) {
                CompareActivity.initCompare(selectedRecords[0], selectedRecords[1]);
                Intent intent = new Intent(MainActivity.this, CompareActivity.class);
                startActivity(intent);
            }
        });

        Button reloadButton = this.findViewById(R.id.reloadButton);
        reloadButton.setOnClickListener(v -> loadRecords());

        CheckBox compareCB = this.findViewById(R.id.compareCB);
        compareCB.setOnClickListener(v -> {
            compare = compareCB.isChecked();
            loadRecords();
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void loadRecords() {
        ArrayList<Record> temp = checkForRecordFiles();
        if (!temp.isEmpty()) {
            LinearLayout linearLayout = this.findViewById(R.id.linearLayout);
            linearLayout.removeAllViews();

            for (Record r : temp) {
                cRec1 = false;
                if(r.mData.mLatitudes.size()  >= 1) {
                    System.out.println("LoadRecCount" +mRecords.size());
                    System.out.println("name: " + r.mData.mName + "  " + r.mData.mLatitudes.get(0) + " " + r.mData.mLongitudes.get(0)+ " Speed:" + r.mData.mSpeed.get(0));

                    if (r.mData.mName != null) {
                        TextView textView = new TextView(getBaseContext());
                        textView.setTextSize(1,20);
                        TextView empty = new TextView(getBaseContext());
                        empty.setText("");
                        textView.setText(r.mData.mName);
                        textView.setOnClickListener(v -> {
                            if (!compare) {
                                ShowRecordActivity.initRecord(r);
                                Intent intent = new Intent(MainActivity.this, ShowRecordActivity.class);
                                startActivity(intent);
                            }
                            else {
                                if (!r.isSelected) {
                                    r.isSelected = true;
                                    textView.setTextColor(Color.GREEN);

                                    if (selectedRecords[0] == null) {
                                        cRec1 = true;
                                        selectedRecords[0] = r;
                                    }
                                    if (selectedRecords[1] == null && !cRec1) {
                                        selectedRecords[1] = r;
                                    }
                                }
                                else {
                                    r.isSelected = false;
                                    textView.setTextColor(Color.BLACK);

                                    if (Objects.equals(selectedRecords[0].mData.mName, r.mData.mName)) {
                                        selectedRecords[0] = null;
                                    }
                                    if (Objects.equals(selectedRecords[1].mData.mName, r.mData.mName)) {
                                        selectedRecords[1] = null;
                                    }
                                }
                            }
                        });
                        linearLayout.addView(textView);
                    }
                }
            }
        }
    }


    @Override
    protected void onStop() {
        System.out.println("STOP");
        super.onStop();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private ArrayList<Record> checkForRecordFiles() {

        ArrayList<Record> records = new ArrayList<>();
        SharedPreferences sh;
        try {
            sh = getSharedPreferences("al", Context.MODE_PRIVATE);
        } catch (Exception e) {
            return records;
        }
        String[] allRecords;
        try {
            allRecords = sh.getString("al","").split("#");
        } catch (Exception e) {
            return records;
        }
        if(allRecords.length > 1) {
            for (int i = 0; i < allRecords.length; i++) {
                String[] allLocations = allRecords[i].split(";");
                ArrayList<Double> lon = new ArrayList<>();
                ArrayList<Double> lat = new ArrayList<>();
                long time = 0;
                String name = "";
                ArrayList<Float> speed = new ArrayList<>();
                for (int x = 0; x < allLocations.length; x++) {
                    String[] lonlat = allLocations[x].split(",");
                    lat.add(Double.parseDouble(lonlat[0]));
                    lon.add(Double.parseDouble(lonlat[1]));
                    name=lonlat[2];
                    speed.add(Float.valueOf(lonlat[3]));
                    time = Long.parseLong(lonlat[4]);
                }
                Data data = new Data();
                data.mSpeed = speed;
                data.mTime = time;
                data.mLatitudes = lat;
                data.mLongitudes = lon;
                data.mName = name;
                Record record = new Record();
                record.mData = data;
                records.add(record);
                System.out.println(records.get(0).mData.mLatitudes + " Speed" + records.get(0).mData.mSpeed);
            }
        }
        return  records;
    }
}