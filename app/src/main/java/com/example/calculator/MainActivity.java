package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView showTxt;
    private TextView resTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void init() {
        showTxt = (TextView) findViewById(R.id.inputTxt);
        resTxt = (TextView) findViewById(R.id.resTxt);
    }
}