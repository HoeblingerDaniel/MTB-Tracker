package at.htlleonding.mtb_tracker_smartphoneapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import at.htlleonding.mtb_tracker_smartphoneapp.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addTrackButton = findViewById(R.id.addTrackButton);
        addTrackButton.setOnClickListener(v -> {
           // Intent addTrackIntent = new Intent(getBaseContext(), AddTrailActivity.class);
          //  startActivity(addTrackIntent);
            setContentView(R.layout.activity_add_track);
        });
    }

}


//https://www.programmierenlernenhq.de/tutorial-android-daten-in-datei-speichern/