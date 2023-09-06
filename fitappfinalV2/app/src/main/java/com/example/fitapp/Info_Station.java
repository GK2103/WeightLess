package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Info_Station extends AppCompatActivity {
    
    ConstraintLayout Workout;
    ConstraintLayout Wloss;

    ConstraintLayout Hfood;

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_station);
        
        Workout = findViewById(R.id.WRlayout);
        Workout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotourl("https://www.google.co.uk/");
            }
        });

        Wloss = findViewById(R.id.constraintLayout2);
        Wloss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotourl("https://www.google.co.uk/");
            }
        });

        Hfood = findViewById(R.id.questionlayout);
        Hfood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotourl("https://www.google.co.uk/");
            }
        });
        
    }

    private void gotourl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }
}