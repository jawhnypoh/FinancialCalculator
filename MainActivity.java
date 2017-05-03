package com.example.poj.financialcalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button howToButton = (Button) findViewById(R.id.howto_button);
        howToButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Open a Dialog box with How To Information
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("HOW TO USE")
                        .setMessage("This is the Financial Calculator. You have three different " +
                                "choices to choose from: " + "\n" +
                                "1. Calculate your Loan Balance" + "\n" +
                                "2. Calculate your Compounded Interest" + "\n" +
                                "3. Calculate your Future Value" + "\n")
                        .setPositiveButton("Got it!", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Closes the dialog
                            }
                        })
                        .show();
            }
        });

        Button loanButton = (Button) findViewById(R.id.loan_button);
        loanButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Go to loan calculation page
                goToLoanBal();
            }
        });

        Button compButton = (Button) findViewById(R.id.compounded_button);
        compButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Go to compounded interest calculation page
                goToCompound();
            }
        });

        Button futvalButton = (Button) findViewById(R.id.futval_button);
        futvalButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Go to future value calculation page
                goToFuture();
            }
        });
    }

    void goToLoanBal() {
        Intent intent = new Intent(this, LoanActivity.class);
        startActivity(intent);
    }

    void goToCompound() {
        Intent intent = new Intent(this, CompoundedActivity.class);
        startActivity(intent);
    }

    void goToFuture() {
        Intent intent = new Intent(this, FutureActivity.class);
        startActivity(intent);
    }
}
