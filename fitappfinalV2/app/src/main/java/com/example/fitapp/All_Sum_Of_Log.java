package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class All_Sum_Of_Log extends AppCompatActivity {

    TextView totalcal, totalpro, totalcarb, totalfat;
    DBHelper2 dbh2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_sum_of_log);
        totalcal = findViewById(R.id.totalcal);
        totalpro = findViewById(R.id.totalpro);
        totalcarb = findViewById(R.id.totalcarb);
        totalfat = findViewById(R.id.totalfat);

        dbh2 = new DBHelper2(this);
        int totalCalories = dbh2.getTotalCalories();
        int totalProtein = dbh2.getTotalProtein();
        int totalCarbs = dbh2.getTotalCarbs();
        int totalFats = dbh2.getTotalFats();
        totalcal.setText("Total Calories: " + totalCalories);
        totalpro.setText(("Total Protein(g): " + totalProtein));
        totalcarb.setText(("Total Carbs(g): " + totalCarbs));
        totalfat.setText(("Total Fats(g): " + totalFats));
    }
}