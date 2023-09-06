package com.example.fitapp;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Workout_Diary extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton button;
    DBHelper dbh;
    ArrayList<String> uexercises, usetss, urepss, uweights;
    MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.workout_diary);

        recyclerView = findViewById(R.id.recycler);
        button = findViewById(R.id.floatingActionButton);
        dbh = new DBHelper(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Workout_Diary.this, Add_exercise.class);
                startActivity(intent);
            }
        });

        uexercises = new ArrayList<>();
        usetss = new ArrayList<>();
        urepss = new ArrayList<>();
        uweights = new ArrayList<>();

        myAdapter = new MyAdapter(Workout_Diary.this, uexercises, usetss, urepss, uweights);
        recyclerView.setAdapter(myAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(Workout_Diary.this));

        displaydata();
    }

    private void displaydata() {
        Cursor cursor = dbh.getdata();
        if (cursor.getCount()==-1){
            Toast.makeText(this, "No Exercises Logged", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            while(cursor.moveToNext()){
                uexercises.add(cursor.getString(0));
                usetss.add(cursor.getString(1));
                urepss.add(cursor.getString(2));
                uweights.add(cursor.getString(3));
            }
        }
    }
}