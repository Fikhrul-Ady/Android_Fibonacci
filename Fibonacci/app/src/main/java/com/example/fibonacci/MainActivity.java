package com.example.fibonacci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.core.content.ContextCompat;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private long fibo1 = 0;
    private long fibo2 = 1;
    private long currentFib = 0;
    private TextView mShowFibonacci;
    private long i = 0;
    private  long n = 0;
    private long limit = 0;
    private EditText mLimitInput;

    @Override
    protected  void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.activity_main);
        mShowFibonacci = findViewById(R.id.show_count);
        mLimitInput = findViewById(R.id.limit_input);
        updateFibonacciDisplay();
    }

    public void countUp(View view) {
        if (mLimitInput.getText().toString().isEmpty()) {
            Toast.makeText(this, "Masukkan Angka Limit", Toast.LENGTH_SHORT).show();
            return;
        }

        limit = Long.parseLong(mLimitInput.getText().toString());

        if (n >= limit) {
            Toast.makeText(this, "Fibonacci Anda Telah mencapai Limit", Toast.LENGTH_SHORT).show();
            return;
        }

        long newFib = fibo1 + fibo2;
        fibo2 = fibo1;
        fibo1 = newFib;
        currentFib = newFib;
        n++;

        updateFibonacciDisplay();
    }

    public void showFibonacci(View view) {
        Toast toast = Toast.makeText(this, R.string.fibonacci_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    public void reset(View view) {
        currentFib = 0;
        fibo2 = 1;
        fibo1 = 0;
        limit = 0;
        n = 0;
        mLimitInput.setText("");
        updateFibonacciDisplay();
    }

    private void updateFibonacciDisplay() {
        if (mShowFibonacci != null) {
            mShowFibonacci.setText(Long.toString(currentFib));
            mShowFibonacci.setTextColor(getFibonacciColor());

        }
    }

    private int getFibonacciColor() {
        i++;
        if (i % 2 == 0) {
            return ContextCompat.getColor(this, R.color.Berry);
        } else {
            return ContextCompat.getColor(this, R.color.dark_teal);
        }
    }

}