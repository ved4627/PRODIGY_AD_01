package com.example.prodigy_ad_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private double firstValue = Double.NaN;
    private double secondValue;
    private String currentAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDisplay = findViewById(R.id.tvDisplay);
    }

    // Number Buttons Click Logic
    public void onNumberClick(View view) {
        Button button = (Button) view;
        String currentText = tvDisplay.getText().toString();

        if (currentText.equals("0")) {
            tvDisplay.setText(button.getText().toString());
        } else {
            tvDisplay.append(button.getText().toString());
        }
    }

    // Clear (AC) Logic
    public void onClearClick(View view) {
        tvDisplay.setText("0");
        firstValue = Double.NaN;
    }
}