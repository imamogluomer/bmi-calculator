package com.example.boykilo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.boykilo.R;

public class MainActivity extends AppCompatActivity {

    EditText editTextHeight, editTextWeight;
    Button buttonCalculate;
    TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        buttonCalculate = findViewById(R.id.buttonCalculate);
        textViewResult = findViewById(R.id.textViewResult);

        buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = editTextHeight.getText().toString();
        String weightStr = editTextWeight.getText().toString();

        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            textViewResult.setText("Lütfen boş alan bırakmayın.");
            return;
        }

        float height = Float.parseFloat(heightStr) / 100; // cm to m
        float weight = Float.parseFloat(weightStr);

        float bmi = weight / (height * height);

        String result;
        if (bmi < 18.5) {
            result = "Zayıf";
        } else if (bmi < 24.9) {
            result = "Normal";
        } else if (bmi < 29.9) {
            result = "Fazla kilolu";
        } else {
            result = "Obez";
        }

        textViewResult.setText("Vücut Kitle İndeksi (BMI): " + String.format("%.2f", bmi) + "\nDurum: " + result);
    }
}
