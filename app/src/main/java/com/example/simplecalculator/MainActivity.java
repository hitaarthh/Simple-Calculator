package com.example.simplecalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    public EditText e1, e2;
    TextView t1;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Initialize EditText and TextView
        e1 = findViewById(R.id.num1);
        e2 = findViewById(R.id.num2);
        t1 = findViewById(R.id.result);
    }

    public boolean getNumbers() {
        // Get the input from the EditText fields
        String s1 = e1.getText().toString();
        String s2 = e2.getText().toString();

        if (s1.isEmpty()) {
            e1.setError("Please enter value 1");
            return false;
        }
        if (s2.isEmpty()) {
            e2.setError("Please enter value 2");
            return false;
        }

        try {
            // Parse the input to integers
            num1 = Integer.parseInt(s1);
            num2 = Integer.parseInt(s2);
        } catch (NumberFormatException e) {
            t1.setText("Error: Invalid number format");
            return false;
        }

        return true;
    }

    public void doSum(View v) {
        if (getNumbers()) {
            int sum = num1 + num2;
            t1.setText(String.valueOf(sum));
        }
    }

    public void doSub(View v) {
        if (getNumbers()) {
            int difference = num1 - num2;
            t1.setText(String.valueOf(difference));
        }
    }

    public void doMul(View v) {
        if (getNumbers()) {
            int product = num1 * num2;
            t1.setText(String.valueOf(product));
        }
    }

    public void doDiv(View v) {
        if (getNumbers()) {
            if (num2 != 0) {
                double quotient = num1 / (double) num2;
                t1.setText(String.valueOf(quotient));
            } else {
                t1.setText("Error: Division by zero");
            }
        }
    }

    public void doMod(View v) {
        if (getNumbers()) {
            if (num2 != 0) {
                int remainder = num1 % num2;
                t1.setText(String.valueOf(remainder));
            } else {
                t1.setText("Error: Division by zero");
            }
        }
    }

    public void doPow(View v) {
        if (getNumbers()) {
            double power = Math.pow(num1, num2);
            t1.setText(String.valueOf(power));
        }
    }

    public void clearTextNum1(View v) {
        e1.getText().clear();
    }

    public void clearTextNum2(View v) {
        e2.getText().clear();
    }
}
