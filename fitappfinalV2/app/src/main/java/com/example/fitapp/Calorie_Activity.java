package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Calorie_Activity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton button;

    Button view;
    DBHelper2 dbh;
    ArrayList<String> umealNames, umealTypes, ucalories, uprotein, ucarbs, ufats;
    MyAdapter2 myAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);

        recyclerView = findViewById(R.id.recycler2);
        button = findViewById(R.id.floatingActionButton2);
        view = findViewById(R.id.button3);
        dbh = new DBHelper2(this);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(Calorie_Activity.this, All_Sum_Of_Log.class);
                startActivity(intent2);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Calorie_Activity.this, Add_meal.class);
                startActivity(intent);
            }
        });

        umealNames = new ArrayList<>();
        umealTypes = new ArrayList<>();
        ucalories = new ArrayList<>();
        uprotein = new ArrayList<>();
        ucarbs = new ArrayList<>();
        ufats = new ArrayList<>();

        myAdapter2 = new MyAdapter2(Calorie_Activity.this, umealNames, umealTypes, ucalories, uprotein, ucarbs, ufats);
        recyclerView.setAdapter(myAdapter2);

        recyclerView.setLayoutManager(new LinearLayoutManager(Calorie_Activity.this));

        displaydata();
    }

    private void displaydata() {
        Cursor cursor = dbh.getdata();
        if(cursor.getCount()==-1){
            Toast.makeText(this, "No Meals Logged", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            while (cursor.moveToNext()){
                umealNames.add(cursor.getString(0));
                umealTypes.add(cursor.getString(1));
                ucalories.add(cursor.getString(2));
                uprotein.add(cursor.getString(3));
                ucarbs.add(cursor.getString(4));
                ufats.add(cursor.getString(5));
            }
        }
    }
}