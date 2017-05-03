package com.example.poj.financialcalculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoanActivity extends AppCompatActivity {

    double ans;
    EditText A1, i, P1, n1, goal1;
    double A1_var, i_var, P1_var, n1_var, goal1_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan);

        Button loanCalc = (Button) findViewById(R.id.loan_calculate);
        loanCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Convert inputs to Doubles
                A1_var = Double.parseDouble(A1.getText().toString());
                i_var = Double.parseDouble(i.getText().toString());
                P1_var = Double.parseDouble(P1.getText().toString());
                n1_var = Double.parseDouble(n1.getText().toString());
                goal1_var = Double.parseDouble(goal1.getText().toString());

                calculateLoan();
                if(ans == goal1_var) {
                    new AlertDialog.Builder(LoanActivity.this)
                            .setTitle("Congratulations!")
                            .setMessage("You have met your goal! " + "\n" +
                                    "Your Loan Balance is: " + ans + "\n")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Closes the dialog
                                }
                            })
                            .show();
                }
                else {
                    new AlertDialog.Builder(LoanActivity.this)
                            .setTitle("Work Harder! ")
                            .setMessage("Unfortunately, you have not met your goal, try harder next time! " + "\n" +
                                    "Your Loan Balance is: " + ans + "\n")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Closes the dialog
                                }
                            })
                            .show();
                }
            }
        });

        // A1 = Initial Investment
        A1 = (EditText) findViewById(R.id.init_invest_enter);
        // i = Interest Rate
        i = (EditText) findViewById(R.id.interest_rate_enter);
        // P1 = Equal Payment
        P1 = (EditText) findViewById(R.id.equal_pay_enter);
        // n1 = Number of Time Periods Elapsed
        n1 = (EditText) findViewById(R.id.time_per_enter);
        // goal1 = Goal Amount
        goal1 = (EditText) findViewById(R.id.goal_amount_enter);
    }

    public double calculateLoan() {
        // Answer Calculation
        // Loan Balance Equation: B = A(1+i)^n - (P/i) * [(1+i)^n - 1]

        ans = A1_var * (Math.pow((1+i_var), n1_var) - (P1_var/i_var) * (Math.pow((1+i_var), n1_var) - 1));

        return ans;
    }
}
