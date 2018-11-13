package com.example.bobby.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText newNumber;
    private TextView textView;

    private double op1;
    private double op2;
    private String pendingOp ="=";

    private static final int[] ButtonArray ={R.id.button0, R.id.button1,R.id.button2,R.id.button3,R.id.button4,R.id.button5,R.id.button6,R.id.button7,R.id.button8,R.id.button9,
                                            R.id.buttonDot,R.id.buttonEquals,R.id.buttonAdd,R.id.buttonMinus,R.id.buttonMultiply,R.id.buttonDivide};

    private Button[] button = new Button[ButtonArray.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        newNumber = findViewById(R.id.newNumber);
        textView = findViewById(R.id.textView);

        textView.setText("");

        for (int i = 0; i < 11; i++) {
            button[i] = findViewById(ButtonArray[i]);
            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button b = (Button) v;
                    newNumber.append(b.getText().toString());
                }

            };
            button[i].setOnClickListener(listener);

        }
        for (int i= 11; i<ButtonArray.length; i++){
            button[i] = findViewById(ButtonArray[i]);
            View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button p = (Button) v;
                String op = p.getText().toString();
                String value = newNumber.getText().toString();
                if (value.length() != 0) {
                    performOperation(value, op);
                }
                pendingOp = op;
                textView.setText(pendingOp);


            }
        };

            button[i].setOnClickListener(opListener);
        }

    }
    private void performOperation(String value, String operation){
        textView.setText(operation);
    }












    }

