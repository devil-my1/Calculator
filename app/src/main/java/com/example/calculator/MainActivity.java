package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView showTxt;
    private TextView resTxt;
    private Button divBtn;
    private Button mulBtn;
    private Button subBtn;
    private Button addBtn;
    private Button parcentBtn;
    private Button bracersBtn;
    private Button negBtn;
    private Button dotBtn;
    private Button equalBtn;
    private Button clearBtn;
    private String strSeq;
    private int num1;
    private int num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        showTxt = (TextView) findViewById(R.id.inputTxt);
        resTxt = (TextView) findViewById(R.id.resTxt);
        divBtn = (Button) findViewById(R.id.divBtn);
        mulBtn = (Button) findViewById(R.id.mulBtn);
        subBtn = (Button) findViewById(R.id.subBtn);
        addBtn = (Button) findViewById(R.id.addBtn);
        parcentBtn = (Button) findViewById(R.id.parcentBtn);
        bracersBtn = (Button) findViewById(R.id.bracersBtn);
        negBtn = (Button) findViewById(R.id.negBtn);
        dotBtn = (Button) findViewById(R.id.dotBtn);
        equalBtn = (Button) findViewById(R.id.equalBtn);
        clearBtn = (Button) findViewById(R.id.clearBtn);
        strSeq = "";
    }

    public void click(View v) {
        Button currentBtn = (Button) v;

        if (!resTxt.getText().toString().equals("")) {
            clearBtn(v);
        }
        strSeq += currentBtn.getText().toString();
        showTxt.setText(strSeq);

    }

    public void clearBtn(View v) {
        strSeq = "";
        showTxt.setText(strSeq);
        resTxt.setText("");
    }

    public void funcbtn(View v) {
        Button crnt = (Button) v;

        if (!strSeq.equals("")) {
            strSeq += " " + crnt.getText().toString() + " ";
            showTxt.setText(strSeq);
        }
    }

    public void getRes(View v) {

        if (!strSeq.equals("")) {
            try {
                String[] flags = strSeq.split(" ");
                num1 = Integer.parseInt(flags[0]);
                String sign = flags[1];
                num2 = Integer.parseInt(flags[2]);

                switch (sign) {
                    case "+":
                        resTxt.setText(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        resTxt.setText(String.valueOf(num1 - num2));
                        break;
                    case "*":
                        resTxt.setText(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        if (num2 != 0)
                            resTxt.setText(String.valueOf(num1 / num2));
                        else
                            Toast.makeText(this, "Can not divide to 0.", Toast.LENGTH_SHORT).show();
                        break;
                    case "%":
                        resTxt.setText(String.valueOf(num1 % num2));
                        break;
                }

            } catch (NullPointerException e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }


        }
    }
}