package at.htlleonding.mtb_tracker_smartphoneapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addTrackButton = findViewById(R.id.addTrackButton);
        addTrackButton.setOnClickListener(v -> {
            Intent
        });
    }
}