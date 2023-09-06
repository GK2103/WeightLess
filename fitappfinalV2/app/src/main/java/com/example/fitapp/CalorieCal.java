package com.example.fitapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class CalorieCal extends AppCompatActivity {

    EditText genderTEXT, ageTEXT, weightTEXT, heightTEXT;
    Button button;
    TextView tv;

    RadioButton male, female, seditary, moderate, veryactive;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_cal);

        ageTEXT = findViewById(R.id.AgeET);
        weightTEXT = findViewById(R.id.WeightET);
        heightTEXT = findViewById(R.id.HeightET);
        button = findViewById(R.id.buttoncal);
        tv = findViewById(R.id.caloriecalculator);
        male = findViewById(R.id.radioButtonM);
        female = findViewById(R.id.radioButtonF);
        seditary = findViewById(R.id.radioButton1);
        moderate = findViewById(R.id.radioButton2);
        veryactive = findViewById(R.id.radioButton3);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Float age = Float.parseFloat(ageTEXT.getText().toString());
                Float weight = Float.parseFloat(weightTEXT.getText().toString());
                Float height = Float.parseFloat(heightTEXT.getText().toString());
                if (male.isChecked()){
                    Double BMR = 66.47 + (13.75 * weight) + (5.003*height) - (6.755*age);
                    if(seditary.isChecked()){
                        Double AMR = (BMR*1.2)-300;
                        tv.setText(String.valueOf(AMR));
                    }
                    else if(moderate.isChecked()){
                        Double AMR = (BMR*1.55)-300;
                        tv.setText(String.valueOf(AMR));
                    }
                    else if (veryactive.isChecked()) {
                        Double AMR = (BMR* 1.9)-300;
                        tv.setText(String.valueOf(AMR));
                    }
                } else if (female.isChecked()) {
                    Double BMR = 655.1 + (9.563 * weight) + (1.850*height) - (4.676*age);
                    if(seditary.isChecked()){
                        Double AMR = (BMR*1.2)-300;
                        tv.setText(String.valueOf(AMR));
                    }
                    else if(moderate.isChecked()){
                        Double AMR = (BMR*1.55)-300;
                        tv.setText(String.valueOf(AMR));
                    }
                    else if (veryactive.isChecked()) {
                        Double AMR = (BMR* 1.9)-300;
                        tv.setText(String.valueOf(AMR));
                    }
                }


            }
        });
    }
}