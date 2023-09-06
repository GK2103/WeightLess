package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Edit_meal extends AppCompatActivity {

    EditText mealname, mealtype, calories, protein, carbs, fats;
    ImageView delete, edit;
    DBHelper2 db2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_meal);

        mealname = findViewById(R.id.editTextTextPersonName);
        mealtype = findViewById(R.id.editTextTextPersonName2);
        calories = findViewById(R.id.editTextTextPersonName3);
        protein = findViewById(R.id.editTextTextPersonName4);
        carbs = findViewById(R.id.editTextTextPersonName5);
        fats = findViewById(R.id.editTextTextPersonName6);
        delete = findViewById(R.id.imageView3);
        edit = findViewById(R.id.imageView4);
        db2 = new DBHelper2(this);

        Intent intent = getIntent();

        mealname.setText(intent.getStringExtra("mealnames"));
        mealtype.setText(intent.getStringExtra("mealtypes"));
        calories.setText(intent.getStringExtra("caloriess"));
        protein.setText(intent.getStringExtra("proteinss"));
        carbs.setText(intent.getStringExtra("carbss"));
        fats.setText(intent.getStringExtra("fatss"));

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mealNameTEXT = mealname.getText().toString();
                Boolean deletedata = db2.deletedata(mealNameTEXT);

                    if (deletedata==true){
                        Toast.makeText(Edit_meal.this, "Deleted Meal Logged", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Edit_meal.this, "Not deleted", Toast.LENGTH_SHORT).show();
                    }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mealNameTEXT = mealname.getText().toString();
                String mealTypeTEXT = mealtype.getText().toString();
                String caloriesTEXT = calories.getText().toString();
                String proteinTEXT = protein.getText().toString();
                String carbsTEXT = carbs.getText().toString();
                String fatsTEXT = fats.getText().toString();
                Boolean updatedata = db2.updatedata(mealNameTEXT, mealTypeTEXT, caloriesTEXT, proteinTEXT, carbsTEXT, fatsTEXT);

                if (updatedata==true){
                    Toast.makeText(Edit_meal.this, "Editted Meal Logged", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Edit_meal.this, "Not Editted", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}