package com.example.mymanifit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TimePicker;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{
   // ImageView plusBtn;
    FloatingActionButton plusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        plusBtn = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        plusBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                makeAct();
            }
        });
    }

    public void makeAct()
    {
        Intent i = new Intent(this, WorkoutInfo.class);
        startActivity(i);
    }
}