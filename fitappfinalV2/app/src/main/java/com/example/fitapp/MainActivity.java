package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView dumbellbutton;
    private ImageView foodbutton;
    private ImageView infobutton;
    private ImageView profilebutton;

    private Button calbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dumbellbutton = (ImageView) findViewById(R.id.dumbell);
        foodbutton = (ImageView) findViewById(R.id.food);
        infobutton = (ImageView) findViewById(R.id.info);
        profilebutton = (ImageView) findViewById(R.id.profilepic);
        calbutton = findViewById(R.id.calbutton);

        dumbellbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                take_to_Workout_Diary(v);
            }
        });

        foodbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                take_to_Calorie_Diary(v);
            }
        });

        infobutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                take_to_Info_Station(v);
            }
        });

        profilebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                take_to_profile(v);
            }
        });

        calbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {take_to_calgoal(v);}
        });

    }

    public void take_to_Info_Station(View v) {
        Intent intent1 = new Intent(this, Info_Station.class);
        startActivity(intent1);
    }

    public void take_to_Workout_Diary(View v) {
        Intent intent2 = new Intent(this, Workout_Diary.class);
        startActivity(intent2);
    }

    public void take_to_Calorie_Diary(View v) {
        Intent intent3 = new Intent(this, Calorie_Activity.class);
        startActivity(intent3);
    }

    public void take_to_profile(View v) {
        Intent intent4 = new Intent(this, Profile_Page.class);
        startActivity(intent4);
    }

    public void take_to_calgoal(View v) {
        Intent intent5 = new Intent(this, CalorieCal.class);
        startActivity(intent5);
    }
}