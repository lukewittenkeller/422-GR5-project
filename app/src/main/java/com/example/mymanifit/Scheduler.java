package com.example.mymanifit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class Scheduler extends AppCompatActivity {

    CheckBox mon, tues, wed, thurs, fri, sat, sun;
    Button next, back;
    Boolean monSelected,tuesSelected,wedSelected,thursSelected,friSelected, satSelected, sunSelected = false;

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

        if(savedInstanceState != null){
            Log.i("testa", savedInstanceState.getString("test"));
        }

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
           //     Intent i = new Intent(Scheduler.this, WorkoutInfo.class);
        //        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
         //       startActivity(i);
                finish();
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = "Enter Time";
                if(!sunText.getText().toString().contains(s) || !monText.getText().toString().contains(s) || !tuesText.getText().toString().contains(s) ||
                        !wedText.getText().toString().contains(s) || !thursText.getText().toString().contains(s) || !friText.getText().toString().contains(s) || !satText.getText().toString().contains(s)) {
                    Intent i = new Intent(Scheduler.this, Timer.class);
                    startActivity(i);
                }
                else{
                    Toast toast = Toast.makeText(Scheduler.this, "Please select at least one workout day and a time!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.TOP, 0, 950);
                    toast.show();
                }
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


        sat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                satSelected = b;
                if(b == true) {
                    satText.setBackgroundColor(Color.WHITE);
                    satText.setTextColor(Color.BLACK);
                    satText.setEnabled(true);
                }
                else{

                    satText.setTextColor(Color.TRANSPARENT);
                    satText.setBackgroundColor(Color.TRANSPARENT);
                    satText.setEnabled(false);
                }
            }
        });


        sun.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sunSelected = b;
                if(b == true) {
                    sunText.setBackgroundColor(Color.WHITE);
                    sunText.setTextColor(Color.BLACK);
                    sunText.setEnabled(true);
                }
                else{
                    sunText.setTextColor(Color.TRANSPARENT);
                    sunText.setBackgroundColor(Color.TRANSPARENT);
                    sunText.setEnabled(false);
                }
            }
        });


        mon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                monSelected = b;
                if(b == true) {
                    monText.setBackgroundColor(Color.WHITE);
                    monText.setTextColor(Color.BLACK);
                    monText.setEnabled(true);
                }
                else{

                    monText.setBackgroundColor(Color.TRANSPARENT);
                    monText.setTextColor(Color.TRANSPARENT);
                    monText.setEnabled(false);
                }
            }
        });



        tues.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                tuesSelected = b;
                if(b == true) {
                    tuesText.setBackgroundColor(Color.WHITE);
                    tuesText.setTextColor(Color.BLACK);
                    tuesText.setEnabled(true);
                }
                else{

                    tuesText.setBackgroundColor(Color.TRANSPARENT);
                    tuesText.setTextColor(Color.TRANSPARENT);
                    tuesText.setEnabled(false);
                }
            }
        });

        wed.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                wedSelected = b;
                if(b == true) {
                    wedText.setBackgroundColor(Color.WHITE);
                    wedText.setTextColor(Color.BLACK);
                    wedText.setEnabled(true);
                }
                else{

                    wedText.setBackgroundColor(Color.TRANSPARENT);
                    wedText.setTextColor(Color.TRANSPARENT);
                    wedText.setEnabled(false);
                }
            }
        });


        thurs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                thursSelected = b;
                if(b == true) {
                    thursText.setBackgroundColor(Color.WHITE);
                    thursText.setTextColor(Color.BLACK);
                    thursText.setEnabled(true);
                }
                else{

                    thursText.setBackgroundColor(Color.TRANSPARENT);
                    thursText.setTextColor(Color.TRANSPARENT);
                    thursText.setEnabled(false);
                }
            }
        });


        fri.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                friSelected = b;
                if(b == true) {
                    friText.setBackgroundColor(Color.WHITE);
                    friText.setTextColor(Color.BLACK);
                    friText.setEnabled(true);
                }
                else{

                    friText.setBackgroundColor(Color.TRANSPARENT);
                    friText.setTextColor(Color.TRANSPARENT);
                    friText.setEnabled(false);
                }
            }
        });
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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString("test", "lol");
    }
}