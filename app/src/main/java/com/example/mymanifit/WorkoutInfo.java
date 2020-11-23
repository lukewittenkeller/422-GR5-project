package com.example.mymanifit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class WorkoutInfo extends AppCompatActivity {

    Button b1, b2, b3, backBtn, nextBtn;
    EditText durationField;

    boolean isStrength, isFit, isHuge;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_info);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        backBtn = (Button) findViewById(R.id.backButton);
        nextBtn = (Button) findViewById(R.id.nextButton);
        durationField = (EditText) findViewById(R.id.editText);

        b1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!isStrength)
                {
                    //set this button color green
                    b1.setBackgroundColor(Color.GREEN);
                    isStrength = true;
                    b2.setBackgroundColor(Color.WHITE);
                    b3.setBackgroundColor(Color.WHITE);
                    isFit = false;
                    isHuge = false;
                }
                // button is already selected so this is deselect
                else
                {
                    b1.setBackgroundColor(Color.WHITE);
                    isStrength = false;
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!isFit)
                {
                    //set this button color green
                    b2.setBackgroundColor(Color.GREEN);
                    isFit = true;
                    b1.setBackgroundColor(Color.WHITE);
                    b3.setBackgroundColor(Color.WHITE);
                    isStrength = false;
                    isHuge = false;
                }
                // button is already selected so this is deselect
                else
                {
                    b2.setBackgroundColor(Color.WHITE);
                    isFit = false;
                }
            }
        });

        b3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if(!isHuge)
                {
                    //set this button color green
                    b3.setBackgroundColor(Color.GREEN);
                    isHuge = true;
                    b1.setBackgroundColor(Color.WHITE);
                    b2.setBackgroundColor(Color.WHITE);
                    isStrength = false;
                    isFit = false;
                }
                // button is already selected so this is deselect
                else
                {
                    b3.setBackgroundColor(Color.WHITE);
                    isHuge = false;
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WorkoutInfo.this, MainActivity.class);
                startActivity(i);
            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //grab workout length and type
                if(isStrength || isFit || isHuge)
                {
                    String s = durationField.getText().toString();
                    if(s.equals(""))
                    {
                        Toast.makeText(WorkoutInfo.this, "Please enter your workout duration", Toast.LENGTH_LONG).show();
                    }
                    else
                    {

                        Intent i = new Intent(WorkoutInfo.this, Scheduler.class);
                        i.putExtra("length", Integer.parseInt(s));
                        if(isStrength)
                        {
                            i.putExtra("type", "getStrong");
                        }
                        else if(isFit)
                        {
                            i.putExtra("type", "getFit");
                        }
                        else
                        {
                            i.putExtra("type", "getHuge");
                        }
                        startActivity(i);
                    }
                }
                else
                {
                    Toast.makeText(WorkoutInfo.this, "Please select a workout type", Toast.LENGTH_LONG).show();
                }
            }
        });

    }
}