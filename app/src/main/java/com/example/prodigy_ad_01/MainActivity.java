package com.example.prodigy_ad_01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvDisplay;
    private double firstValue = Double.NaN;
    private String currentAction = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvDisplay = findViewById(R.id.tvDisplay);
    }

    public void onNumberClick(View view) {
        Button b = (Button) view;
        if (tvDisplay.getText().toString().equals("0")) {
            tvDisplay.setText(b.getText().toString());
        } else {
            tvDisplay.append(b.getText().toString());
        }
    }

    public void onOperatorClick(View view) {
        try {
            Button b = (Button) view;
            firstValue = Double.parseDouble(tvDisplay.getText().toString());
            currentAction = b.getText().toString();
            tvDisplay.setText("0");
        } catch (Exception e) {
            tvDisplay.setText("Error");
        }
    }

    public void onEqualClick(View view) {
        try {
            if (!Double.isNaN(firstValue)) {
                double secondValue = Double.parseDouble(tvDisplay.getText().toString());
                double result = 0;

                if (currentAction.equals("+")) result = firstValue + secondValue;
                else if (currentAction.equals("-")) result = firstValue - secondValue;
                else if (currentAction.equals("*")) result = firstValue * secondValue;
                else if (currentAction.equals("/")) {
                    if (secondValue != 0) result = firstValue / secondValue;
                    else { tvDisplay.setText("Error"); return; }
                }

                tvDisplay.setText(String.valueOf(result));
                firstValue = Double.NaN;
            }
        } catch (Exception e) {
            tvDisplay.setText("Error");
        }
    }

    public void onClearClick(View view) {
        tvDisplay.setText("0");
        firstValue = Double.NaN;
        currentAction = "";
    }
}