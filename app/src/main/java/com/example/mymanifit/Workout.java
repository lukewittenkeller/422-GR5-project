package com.example.mymanifit;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class Workout extends AppCompatActivity {
    TextView timerText;
    TextView workoutText;
    Button homeBtn;
    CountDownTimer timer;
    ObjectAnimator animation;
    boolean timerRunning;
    long timeLeft;
    int counter = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);
        timeLeft = 30000;
        workoutText = (TextView) findViewById(R.id.textViewWorkout);
        timerText = (TextView) findViewById(R.id.countdown);
        homeBtn = (Button) findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Workout.this, MainActivity.class);
                startActivity(i);
            }
        });
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        animation = ObjectAnimator.ofInt(progressBar, "progress", 100, 0); // see this max value coming back here, we animate towards that value
        animation.setDuration(30000); // in milliseconds
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
        startTimer();
    }

    private void startTimer()
    {
        timer = new CountDownTimer(timeLeft, 1000) {
            @Override
            // long l is amount of milliseconds until the timer is finished
            public void onTick(long l) {
                timeLeft = l;
                updateTimer();
            }

            @Override
            public void onFinish()
            {
                if(counter == 0)
                {
                    workoutText.setText("Rest");
                    counter = 1;
                    timeLeft = 10000;
                    animation.setDuration(timeLeft);
                    animation.start();
                    startTimer();
                }
                else if(counter == 1)
                {
                    workoutText.setText("Bench press");
                    counter = 2;
                    timeLeft = 10000;
                    animation.setDuration(timeLeft);
                    animation.start();
                    startTimer();
                }
                else if(counter == 2)
                {
                    workoutText.setText("Rest");
                    counter = 3;
                    timeLeft = 5000;
                    animation.setDuration(timeLeft);
                    animation.start();
                    startTimer();
                }
                else if(counter == 3)
                {
                    workoutText.setText("Workout complete");
                    counter = 0;
                    homeBtn.setEnabled(true);
                }
            }
        }.start();
        timerRunning = true;
    }

    private void updateTimer()
    {
        int minutes = (int) (timeLeft / 1000) / 60;
        int seconds = (int) (timeLeft / 1000) % 60;
        String timeString = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        timerText.setText(timeString);
    }
}
