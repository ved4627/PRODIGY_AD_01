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
        String text = b.getText().toString();

        if (tvDisplay.getText().toString().equals("0") || tvDisplay.getText().toString().equals("Error")) {
            tvDisplay.setText(text);
        } else {

            if (text.equals(".") && tvDisplay.getText().toString().contains(".")) {
                return;
            }
            tvDisplay.append(text);
        }
    }

    public void onOperatorClick(View view) {
        try {
            Button b = (Button) view;
            String op = b.getText().toString();

            // Special logic for +/- button
            if (op.equals("+/-")) {
                double val = Double.parseDouble(tvDisplay.getText().toString());
                val = val * -1;
                tvDisplay.setText(String.valueOf(val));
                return;
            }

            firstValue = Double.parseDouble(tvDisplay.getText().toString());
            currentAction = op;
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

                switch (currentAction) {
                    case "+": result = firstValue + secondValue; break;
                    case "-": result = firstValue - secondValue; break;
                    case "*": result = firstValue * secondValue; break;
                    case "/":
                        if (secondValue != 0) result = firstValue / secondValue;
                        else { tvDisplay.setText("Error"); return; }
                        break;
                    case "%": result = (firstValue / 100) * secondValue; break;
                }


                if (result == (long) result) {
                    tvDisplay.setText(String.valueOf((long) result));
                } else {
                    tvDisplay.setText(String.valueOf(result));
                }
                firstValue = Double.NaN;
                currentAction = "";
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