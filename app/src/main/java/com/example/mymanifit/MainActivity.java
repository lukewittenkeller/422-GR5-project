package com.example.mymanifit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

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