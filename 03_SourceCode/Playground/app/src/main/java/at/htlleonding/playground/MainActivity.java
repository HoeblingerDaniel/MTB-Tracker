package at.htlleonding.playground;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button1);
        TextView text = findViewById(R.id.text);
        btn.setOnClickListener(v -> {
            Intent intent = new Intent(getBaseContext(), SecondActivity.class);
            startActivity(intent);
        });
    }
}