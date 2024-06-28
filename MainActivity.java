package com.example.jiya_pagal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;
    TextView status;
    int flag = 0;
    int count = 0;
    String b1, b2, b3, b4, b5, b6, b7, b8, b9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        status = findViewById(R.id.status);
    }

    public void Check(View view) {
        Button btnCurrent = (Button) view;
        if (btnCurrent.getText().toString().equals("")) {
            count++;
            if (flag == 0) {
                btnCurrent.setText("X");
                flag = 1;
                status.setText("Player O's Turn");
            } else {
                btnCurrent.setText("O");
                flag = 0;
                status.setText("Player X's Turn");
            }
            if (count > 4) {
                b1 = btn1.getText().toString();
                b2 = btn2.getText().toString();
                b3 = btn3.getText().toString();
                b4 = btn4.getText().toString();
                b5 = btn5.getText().toString();
                b6 = btn6.getText().toString();
                b7 = btn7.getText().toString();
                b8 = btn8.getText().toString();
                b9 = btn9.getText().toString();
                // Check for winner
                if (checkWinner(b1, b2, b3) || checkWinner(b4, b5, b6) || checkWinner(b7, b8, b9) ||
                        checkWinner(b1, b4, b7) || checkWinner(b2, b5, b8) || checkWinner(b3, b6, b9) ||
                        checkWinner(b1, b5, b9) || checkWinner(b3, b5, b7)) {
                    // Winner found
                    disableButtons();
                } else if (count == 9) {
                    // It's a draw
                    Toast.makeText(this, "It's a Draw!", Toast.LENGTH_SHORT).show();
                    resetGame();
                }
            }
        }
    }

    private boolean checkWinner(String a, String b, String c) {
        if (!a.equals("") && a.equals(b) && b.equals(c)) {
            Toast.makeText(this, "Winner is : " + a, Toast.LENGTH_SHORT).show();
            status.setText("Winner is : " + a);
            return true;
        }
        return false;
    }

    private void disableButtons() {
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
        btn8.setEnabled(false);
        btn9.setEnabled(false);
    }

    public void resetGame(View view) {
        resetGame();
    }

    private void resetGame() {
        btn1.setText("");
        btn2.setText("");
        btn3.setText("");
        btn4.setText("");
        btn5.setText("");
        btn6.setText("");
        btn7.setText("");
        btn8.setText("");
        btn9.setText("");
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
        btn8.setEnabled(true);
        btn9.setEnabled(true);
        count = 0;
        flag = 0;
        status.setText("Player X's Turn");
    }
}
