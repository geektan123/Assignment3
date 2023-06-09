package com.example.myapplication;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private TextView textView1;
    private CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        textView1 = findViewById(R.id.textView1);

        // Start the timer for 5 seconds
        startTimer(78000);
    }

    private void startTimer(long duration) {
        timer = new CountDownTimer(duration, 3000) {
            public void onTick(long millisUntilFinished) {
                // Generate random values every second
                int randomValue = generateRandomValue();
                ArrayList<Integer> numbers = new ArrayList<>();
                numbers.add(randomValue);
                // Display the random value in the TextView
                textView.setText("Storing data " +String.valueOf(numbers));
                textView1.setText("flash memory address-"+String.valueOf(numbers.hashCode()));
            }

            public void onFinish() {
                // This method won't be called
            }
        };

        timer.start();
    }

    private int generateRandomValue() {
        Random random = new Random();
        return random.nextInt(100); // Generate a random value between 0 and 99
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Cancel the timer to prevent memory leaks
        if (timer != null) {
            timer.cancel();
        }
    }
}
