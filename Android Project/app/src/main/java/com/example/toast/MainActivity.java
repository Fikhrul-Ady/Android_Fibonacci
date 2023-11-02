package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tampil;
    private int hitung = 0; // Memulai dengan index 0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tampil = findViewById(R.id.textView);

        Button buttonback = findViewById(R.id.button3);
        buttonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                back(view);
            }
        });
    }
    public void toast(View view) {
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, R.string.hello_toast, Toast.LENGTH_SHORT);
        toast.show();
    }
    public void count(View view) {
        int hasil = calculateFibonacci(hitung);
        tampil.setText(String.valueOf(hasil));
        hitung++; //Menaikkan index untuk mendapatkan angka Fibonacci berikutnya
    }
    private int calculateFibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1|| n == 2) return 1;

        int fib1 = 1;
        int fib2 = 1;
        int fibN = 0;

        for (int i = 3; i <= n; i++){
            fibN = fib1 +fib2;
            fib1 = fib2;
            fib2 = fibN;
        }
        return fibN;
    }

    public void back(View view){
        if (hitung > 0){
            int hasil = calculateFibonacci(hitung);
            tampil.setText(String.valueOf(hasil));
            hitung--;
        }
    }

}