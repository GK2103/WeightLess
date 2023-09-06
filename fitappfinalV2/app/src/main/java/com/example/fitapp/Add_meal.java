package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class Add_meal extends AppCompatActivity {

        TextInputEditText mealname, mealtype, calories, protein, carbs, fats;
        Button save;
        DBHelper2 db2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_meal);

        mealname = findViewById(R.id.textedit72);
        mealtype = findViewById(R.id.textedit82);
        calories = findViewById(R.id.textedit92);
        protein = findViewById(R.id.textedit102);
        carbs = findViewById(R.id.textedit112);
        fats = findViewById(R.id.textedit122);
        save = findViewById(R.id.button2);
        db2 = new DBHelper2(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mealNameTEXT = mealname.getText().toString();
                String mealTypeTEXT = mealtype.getText().toString();
                String caloriesTEXT = calories.getText().toString();
                String proteinTEXT = protein.getText().toString();
                String carbsTEXT = carbs.getText().toString();
                String fatsTEXT = fats.getText().toString();
                Boolean savedata = db2.savedata(mealNameTEXT, mealTypeTEXT, caloriesTEXT, proteinTEXT, carbsTEXT, fatsTEXT);
                if(TextUtils.isEmpty(mealNameTEXT) || TextUtils.isEmpty(mealTypeTEXT) || TextUtils.isEmpty(caloriesTEXT) || TextUtils.isEmpty(proteinTEXT) || TextUtils.isEmpty(carbsTEXT) || TextUtils.isEmpty(fatsTEXT)){
                    Toast.makeText(Add_meal.this, "All Boxes must be filled to add Meal", Toast.LENGTH_SHORT).show();
                    return;
                }
                else {
                    if (savedata==true){
                        Toast.makeText(Add_meal.this, "Meal Logged", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(Add_meal.this, "Already Entered", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}