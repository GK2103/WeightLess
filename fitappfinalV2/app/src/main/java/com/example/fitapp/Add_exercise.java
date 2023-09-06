package com.example.fitapp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class Add_exercise extends AppCompatActivity {

    TextInputEditText exercise, sets, reps, weight;
    Button save;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_exercise);

        exercise = findViewById(R.id.textedit);
        sets = findViewById(R.id.textedit2);
        reps = findViewById(R.id.textedit3);
        weight = findViewById(R.id.textedit4);
        save = findViewById(R.id.button);
        db = new DBHelper(this);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String exerciseTEXT = exercise.getText().toString();
                String setsTEXT = sets.getText().toString();
                String repsTEXT = reps.getText().toString();
                String weightTEXT = weight.getText().toString();
                Boolean savedata = db.saveuserdata(exerciseTEXT, setsTEXT, repsTEXT, weightTEXT);
                if(TextUtils.isEmpty(exerciseTEXT) || TextUtils.isEmpty(setsTEXT) || TextUtils.isEmpty(repsTEXT) || TextUtils.isEmpty(weightTEXT)){
                    Toast.makeText(Add_exercise.this, "All Boxes must be filled to add Workout", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    if(savedata==true){
                        Toast.makeText(Add_exercise.this, "Exercise Logged", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Add_exercise.this, "Already Entered", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}