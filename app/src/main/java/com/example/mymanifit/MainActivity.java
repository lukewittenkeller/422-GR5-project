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

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{
    ImageView plusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        plusBtn = (ImageView) findViewById(R.id.plusButton);
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