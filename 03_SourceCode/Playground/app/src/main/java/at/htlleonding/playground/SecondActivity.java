package at.htlleonding.playground;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TableRow;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button button = findViewById(R.id.buttonR);
        TableRow tableRow = findViewById(R.id.tableRow1);
        button.setOnClickListener(v -> {
            tableRow.setBackgroundColor(Color.GREEN);
        });
    }
}