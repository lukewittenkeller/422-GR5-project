package com.example.mymanifit;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.ArrayList;
import java.util.Calendar;

public class Scheduler extends AppCompatActivity {

    CheckBox mon, tues, wed, thurs, fri, sat, sun;
    Button next, back;

    Button backBtn, nextBtn;

    TextView monText;
    TextView tuesText;
    TextView wedText;
    TextView thursText;
    TextView friText;
    TextView satText;
    TextView sunText;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);

        Calendar calendar = Calendar.getInstance();

        final int monHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int monMin = calendar.get(Calendar.MINUTE);

        monText = (TextView) findViewById(R.id.textViewMon);

        monText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(Scheduler.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        monText.setText(singleDigit(i) + ":" + singleDigit(i1));
                    }
                }, monHour, monMin, true);
                timePickerDialog.show();
            }
        });



        final int tuesHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int tuesMin = calendar.get(Calendar.MINUTE);

        tuesText = (TextView) findViewById(R.id.textViewTues);

        tuesText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(Scheduler.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        tuesText.setText(singleDigit(i) + ":" + singleDigit(i1));
                    }
                }, tuesHour, tuesMin, true);
                timePickerDialog.show();
            }
        });



        final int wedHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int wedMin = calendar.get(Calendar.MINUTE);

        wedText = (TextView) findViewById(R.id.textViewWed);

        wedText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(Scheduler.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        wedText.setText(singleDigit(i) + ":" + singleDigit(i1));
                    }
                }, wedHour, wedMin, true);
                timePickerDialog.show();
            }
        });


        final int thursHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int thursMin = calendar.get(Calendar.MINUTE);

        thursText = (TextView) findViewById(R.id.textViewThurs);

        thursText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(Scheduler.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        thursText.setText(singleDigit(i) + ":" + singleDigit(i1));
                    }
                }, thursHour, thursMin, true);
                timePickerDialog.show();
            }
        });


        final int friHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int friMin = calendar.get(Calendar.MINUTE);

        friText = (TextView) findViewById(R.id.textViewFri);

        friText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(Scheduler.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        friText.setText(singleDigit(i) + ":" + singleDigit(i1));
                    }
                }, friHour, friMin, true);
                timePickerDialog.show();
            }
        });


        final int satHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int satMin = calendar.get(Calendar.MINUTE);

        satText = (TextView) findViewById(R.id.textViewSat);

        satText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(Scheduler.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1) {
                        satText.setText(singleDigit(i) + ":" + singleDigit(i1));
                    }
                }, satHour, satMin, true);
                timePickerDialog.show();
            }
        });


        final int sunHour = calendar.get(Calendar.HOUR_OF_DAY);
        final int sunMin = calendar.get(Calendar.MINUTE);

        sunText = (TextView) findViewById(R.id.textViewSun);

        sunText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TimePickerDialog timePickerDialog = new TimePickerDialog(Scheduler.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int i, int i1)
                    {
                        sunText.setText(singleDigit(i) + ":" + singleDigit(i1));
                    }
                }, sunHour, sunMin, true);
                timePickerDialog.show();
            }
        });

        backBtn = (Button) findViewById(R.id.backButton);
        nextBtn = (Button) findViewById(R.id.nextButton);


        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Scheduler.this, MainActivity.class);
                startActivity(i);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(Scheduler.this, Timer.class);
                startActivity(i);
            }
        });
        next = (Button) findViewById(R.id.nextButton);
        back = (Button) findViewById(R.id.backButton);
        sun = (CheckBox) findViewById(R.id.checkBox1);
        mon = (CheckBox) findViewById(R.id.checkBox2);
        tues = (CheckBox) findViewById(R.id.checkBox3);
        wed = (CheckBox) findViewById(R.id.checkBox4);
        thurs = (CheckBox) findViewById(R.id.checkBox5);
        fri = (CheckBox) findViewById(R.id.checkBox6);
        sat = (CheckBox) findViewById(R.id.checkBox7);
    }

    public String singleDigit(int i)
    {
        String s = Integer.toString(i);
        if(s.length() == 1)
        {
            s = "0" + s;
        }
        return s;
    }


}