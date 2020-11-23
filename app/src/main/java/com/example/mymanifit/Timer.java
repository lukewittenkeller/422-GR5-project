package com.example.mymanifit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class Timer extends AppCompatActivity
{
    Button editBtn, viewBtn;
    TextView timerText;
    CountDownTimer timer;
    boolean timerRunning;
    long timeLeft;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        editBtn = (Button) findViewById(R.id.editBtn);
        viewBtn = (Button) findViewById(R.id.viewBtn);

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Timer.this, WorkoutInfo.class);
                i.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT| Intent.FLAG_ACTIVITY_SINGLE_TOP);
                timer.cancel();
                startActivity(i);
            //    finish();
            }
        });

        viewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(Timer.this, Scheduler.class);

                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_SINGLE_TOP);
                timer.cancel();

                startActivity(i);
            }
        });

        timeLeft = 10000;
        timerText = (TextView) findViewById(R.id.countdown);
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
                Toast.makeText(Timer.this, "Begin workout!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(Timer.this, Workout.class);
                startActivity(i);
            }
        }.start();
        timerRunning = true;
    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }

    private void updateTimer()
    {
        int minutes = (int) (timeLeft / 1000) / 60;
        int seconds = (int) (timeLeft / 1000) % 60;
        String timeString = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);
        timerText.setText(timeString);
    }
}