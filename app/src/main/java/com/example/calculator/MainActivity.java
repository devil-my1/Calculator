package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    private TextView showTxt, resTxt;
    private String strSeq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        showTxt = findViewById(R.id.inputTxt);
        resTxt = findViewById(R.id.resTxt);
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

        if (!strSeq.equals("") && !strSeq.equals(".")) {
            strSeq += " " + crnt.getText().toString() + " ";
            showTxt.setText(strSeq);
        }
    }

    public void getRes(View v) {

        if (!strSeq.equals("") && !strSeq.equals(".")) {
            try {
                List<Double> numbers = new ArrayList<>();
                List<String> signs = new ArrayList<>();
                double result = 0, num1, num2;
                int i;
                String[] flags = strSeq.split(" ");

                for (i = 0; i < flags.length; i++) {
                    if (Pattern.matches("[+-/*/%]?", flags[i]))
                        signs.add(flags[i]);
                    else
                        numbers.add(Double.parseDouble(flags[i]));
                }


                if (signs.size() != 1 && numbers.size() % signs.size() == 0)
                    Toast.makeText(this, "Input correct formul", Toast.LENGTH_SHORT).show();
                else {
                    i = 0;
                    for (String sign : signs) {
                        num1 = numbers.get(Math.min(i, numbers.size() - 1));
                        num2 = i != 0 ? result : numbers.get(i + 1);
                        if (num1 < num2) {
                            double temp = num2;
                            num2 = num1;
                            num1 = temp;

                        }
                        switch (sign) {
                            case "+":
                                result = num1 + num2;
                                break;
                            case "-":
                                result = num1 - num2;
                                break;
                            case "*":
                                result = num1 * num2;
                                break;
                            case "/":
                                if (num2 != 0)
                                    result = num1 / num2;
                                else
                                    Toast.makeText(this, "Can not divide to 0.", Toast.LENGTH_SHORT).show();
                                break;
                            case "%":
                                result = num1 % num2;
                                break;
                        }
                        i += 2;
                    }

                    resTxt.setText(String.valueOf(result));
                }

            } catch (NullPointerException e) {
                Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
            }
        }
    }
}