package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView numberResultTextView;
    RadioButton maleButton;
    RadioButton femaleButton;

    EditText ageEditText;
    EditText feetEditText;
    EditText inchesEditText;
    EditText weightEditText;

    Button calculateButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
        onClickCalculateBth();

    }

    private void onClickCalculateBth() {
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calculateBmi();
            }
        });
    }



    private void calculateBmi() {

       String ageText = ageEditText.getText().toString();
       String feetText = feetEditText.getText().toString();
       String inchesText = inchesEditText.getText().toString();
       String weightText = weightEditText.getText().toString();

       //Convert number 'String' into 'int'
       int age = Integer.parseInt(ageText);
       int feet = Integer.parseInt(feetText);
       int inches = Integer.parseInt(inchesText);
       int weight = Integer.parseInt(weightText);

       int totalInches = (feet * 12) * inches;

       //Height in metes is the inches multiplied by 0.0254
       double heightMetes = totalInches * 0.0252;
       double bmi = weight / (heightMetes * heightMetes);
       //String bmiTextResult = String.valueOf(bmi);
       DecimalFormat decimalFormatter = new DecimalFormat("0.00");
       String bmiTextResult = decimalFormatter.format(bmi);


       String fullResultString;
       if(bmi < 18.5){
           fullResultString = bmiTextResult + " - You are underweight";
           numberResultTextView.setTextColor(getResources().getColor(R.color.teal_200));

       }else if(bmi > 25){
           fullResultString = bmiTextResult + " - You are overweight";
           numberResultTextView.setTextColor(getResources().getColor(R.color.black));
       }else{
           fullResultString = bmiTextResult + " - You are a healthy weight";
           numberResultTextView.setTextColor(getResources().getColor(R.color.purple_700));
       }
       numberResultTextView.setText(fullResultString);


    }



    private void findViews(){
        numberResultTextView = findViewById(R.id.text_view_number_bmi);
        maleButton = findViewById(R.id.radio_bth_male);
        femaleButton = findViewById(R.id.radio_bth_female);
        ageEditText = findViewById(R.id.edit_text_age);
        feetEditText = findViewById(R.id.edit_text_feet);
        inchesEditText = findViewById(R.id.edit_text_inches);
        weightEditText = findViewById(R.id.edit_text_weight);
        calculateButton = findViewById(R.id.bth_calculate_bmi);
    }




}