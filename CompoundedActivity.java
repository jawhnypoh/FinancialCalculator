package com.example.poj.financialcalculator;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CompoundedActivity extends AppCompatActivity {

    double ans;
    EditText P2, r1, t, goal2;
    double P2_var, r1_var, t_var, goal2_var;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compounded);

        Button compoundedCalc = (Button) findViewById(R.id.compounded_calc);
        compoundedCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Convert inputs to doubles
                P2_var = Double.parseDouble(P2.getText().toString());
                r1_var = Double.parseDouble(r1.getText().toString());
                t_var = Double.parseDouble(t.getText().toString());
                goal2_var = Double.parseDouble(goal2.getText().toString());

                calculateCompound();
                if(ans == goal2_var) {
                    new AlertDialog.Builder(CompoundedActivity.this)
                            .setTitle("Congratulations!")
                            .setMessage("You have met your goal! " + "\n" +
                                    "Your Continuously Compounded Interest is: " + ans + "\n")
                            .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    // Closes the dialog
                                }
                            })
                            .show();
                }
                else {
                    new AlertDialog.Builder(CompoundedActivity.this)
                            .setTitle("Work Harder! ")
                            .setMessage("Unfortunately, you have not met your goal, try harder next time! " + "\n" +
                                    "Your Continuously Compounded Interest is: " + ans + "\n")
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

        // P2 = Principle Investment
        P2 = (EditText) findViewById(R.id.princ_invest_enter);
        // r1 = Annual Interest Rate
        r1 = (EditText) findViewById(R.id.interest_rate_enter);
        // t = Amount of Time
        t = (EditText) findViewById(R.id.time_per_enter);
        // goal2 = Goal Amount
        goal2 = (EditText) findViewById(R.id.goal_amount_enter);
    }

    public double calculateCompound() {
        // Continuously Compounded Equation: A = Pe^r(t)

        ans = P2_var * Math.exp(r1_var * t_var);

        return ans;
    }
}
