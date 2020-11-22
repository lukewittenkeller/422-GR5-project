package com.example.mymanifit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class Scheduler extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    CheckBox mon, tues, wed, thurs, fri, sat, sun, am, pm;
    Spinner s1, s2;
    Button next, back;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scheduler);

        s1 = (Spinner) findViewById(R.id.spinner1);
        s2 = (Spinner) findViewById(R.id.spinner2);
        next = (Button) findViewById(R.id.nextButton);
        back = (Button) findViewById(R.id.backButton);
        sun = (CheckBox) findViewById(R.id.checkBox1);
        mon = (CheckBox) findViewById(R.id.checkBox2);
        tues = (CheckBox) findViewById(R.id.checkBox3);
        wed = (CheckBox) findViewById(R.id.checkBox4);
        thurs = (CheckBox) findViewById(R.id.checkBox5);
        fri = (CheckBox) findViewById(R.id.checkBox6);
        sat = (CheckBox) findViewById(R.id.checkBox7);

        ArrayAdapter<CharSequence> hourAdapter = ArrayAdapter.createFromResource(this, R.array.hours, android.R.layout.simple_spinner_item);
        hourAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(hourAdapter);
        s1.setOnItemSelectedListener(this);

        ArrayAdapter<CharSequence> minsAdapter = ArrayAdapter.createFromResource(this, R.array.minutes, android.R.layout.simple_spinner_item);
        minsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s2.setAdapter(minsAdapter);
        s2.setOnItemSelectedListener(this);


    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}