package com.example.poj.financialcalculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FutureActivity extends AppCompatActivity {

    double ans;
    EditText C0, r2, n2, goal3;
    double C0_var, r2_var, n2_var, goal3_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_future);

        Button futureCalc = (Button) findViewById(R.id.future_calc);
        futureCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Convert inputs to doubles
                C0_var = Double.parseDouble(C0.getText().toString());
                r2_var = Double.parseDouble(r2.getText().toString());
                n2_var = Double.parseDouble(n2.getText().toString());
                goal3_var = Double.parseDouble(goal3.getText().toString());

                calculateFuture();
                if(ans == goal3_var) {
                    new AlertDialog.Builder(FutureActivity.this)
                            .setTitle("Congratulations!")
                            .setMessage("You have met your goal! " + "\n" +
                                    "Your Future Value is: " + ans + "\n")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Closes the dialog
                                }
                            })
                            .show();
                }
                else {
                    new AlertDialog.Builder(FutureActivity.this)
                            .setTitle("Work Harder! ")
                            .setMessage("Unfortunately, you have not met your goal, try harder next time! " + "\n" +
                                    "Your Future Value is: " + ans + "\n")
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

        // C0 = Starting Cash Flow
        C0 = (EditText) findViewById(R.id.start_cash_enter);
        // r2 = Rate of Return
        r2 = (EditText) findViewById(R.id.rate_return_enter);
        // n2 = Number of Periods
        n2 = (EditText) findViewById(R.id.num_periods_enter);
        // goal3 = Goal Amount
        goal3 = (EditText) findViewById(R.id.goal_amount_enter);
    }

    public double calculateFuture() {
        // Future Value Equation: FV = C0 * (1+r)^n

        ans = C0_var * Math.pow((1+r2_var), n2_var);

        return ans;
    }
}
