package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText resultEditText;
    private StringBuilder input = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultEditText = findViewById(R.id.resultEditText);

        setupButtonListeners();
    }

    private void setupButtonListeners() {
        int[] buttonIds = {
            R.id.button0, R.id.button1, R.id.button2, R.id.button3,
            R.id.button4, R.id.button5, R.id.button6, R.id.button7,
            R.id.button8, R.id.button9, R.id.buttonAdd, R.id.buttonSubtract,
            R.id.buttonMultiply, R.id.buttonDivide, R.id.buttonEquals, R.id.buttonClear
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onButtonClick((Button) v);
                }
            });
        }
    }

    private void onButtonClick(Button button) {
        String buttonText = button.getText().toString();

        switch (buttonText) {
            case "=":
                calculateResult();
                break;
            case "C":
                clearInput();
                break;
            default:
                input.append(buttonText);
                resultEditText.setText(input.toString());
                break;
        }
    }

    private void calculateResult() {
        // Simple calculation logic (for demonstration purposes)
        String expression = input.toString();
        // Here you would implement a proper expression evaluation
        // For now, just display the input
        resultEditText.setText(expression);
        input.setLength(0); // Clear input after calculation
    }

    private void clearInput() {
        input.setLength(0);
        resultEditText.setText("");
    }
}