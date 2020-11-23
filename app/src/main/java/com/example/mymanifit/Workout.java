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
    Button editBtn, viewBtn;
    CountDownTimer timer;
    boolean timerRunning;
    long timeLeft;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout);

        timeLeft = 30000;
        workoutText = (TextView) findViewById(R.id.textViewWorkout);
        timerText = (TextView) findViewById(R.id.countdown);
        editBtn = (Button) findViewById(R.id.editBtn);
        viewBtn = (Button) findViewById(R.id.viewBtn);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Workout.this, WorkoutInfo.class);
                startActivity(i);
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Workout.this, Scheduler.class);
                startActivity(i);
            }
        });





        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", 100, 0); // see this max value coming back here, we animate towards that value
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
                workoutText.setText("Rest");
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
