package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Edit_exercise extends AppCompatActivity {

    EditText edit_exercise, edit_sets, edit_reps, edit_weight;
    ImageView delete, edit;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_exercise);

        edit_exercise = findViewById(R.id.editexercise);
        edit_sets = findViewById(R.id.editsets);
        edit_reps = findViewById(R.id.editreps);
        edit_weight = findViewById(R.id.editweight);
        delete = findViewById(R.id.deleteIV);
        edit = findViewById(R.id.editIV);
        db = new DBHelper(this);

        Intent intent = getIntent();

        edit_exercise.setText(intent.getStringExtra("exercises"));
        edit_sets.setText(intent.getStringExtra("sets"));
        edit_reps.setText(intent.getStringExtra("reps"));
        edit_weight.setText(intent.getStringExtra("weights"));

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String exerciseTEXT = edit_exercise.getText().toString();
                Boolean deletedata = db.deleteuserdata(exerciseTEXT);

                    if(deletedata==true){
                        Toast.makeText(Edit_exercise.this, "Exercise Deleted", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(Edit_exercise.this, "Exercise Not Deleted", Toast.LENGTH_SHORT).show();
                    }
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String exerciseTEXT = edit_exercise.getText().toString();
                String setsTEXT = edit_sets.getText().toString();
                String repsTEXT = edit_reps.getText().toString();
                String weightTEXT = edit_weight.getText().toString();
                Boolean updatedata = db.updateuserdata(exerciseTEXT, setsTEXT, repsTEXT, weightTEXT);

                if(updatedata==true){
                    Toast.makeText(Edit_exercise.this, "Exercise Updated", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(Edit_exercise.this, "Exercise Not Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}