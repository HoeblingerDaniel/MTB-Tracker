package at.htlleonding.mtb_tracker_smartphoneapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import at.htlleonding.mtb_tracker_smartphoneapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addTrailButton = findViewById(R.id.addTrailButton);
        addTrailButton.setOnClickListener(view -> {
            Intent intent = new Intent(getBaseContext(), AddTrackActivity.class);
            startActivity(intent);
        });
    }
}
